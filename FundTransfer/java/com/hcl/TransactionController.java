package com.hcl;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hcl.Exception.InsufficientBalanceException;
import com.hcl.dto.AccountDTO;
import com.hcl.dto.TransactionDTO;
import com.hcl.service.TransactionService;

/**
 * @author yash.ghawghawe
 *
 */
@Controller
public class TransactionController {

	private Logger logger = Logger.getLogger(TransactionController.class);
	private Boolean error = false;

	@Autowired
	private TransactionService service;

	/**
	 * @param transaction
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/showtransfer/{userId}")
	public ModelAndView showTransferPage(@ModelAttribute("transfer") TransactionDTO transaction,
			@PathVariable("userId") int userid) {
		transaction = new TransactionDTO();
		return new ModelAndView("fundtransfer").addObject("userid", userid);
	}

	/**
	 * @param transactionDTO
	 * @param result
	 * @param redirectAttributes
	 * @return ModelAndView
	 * @throws InsufficientBalanceException
	 */
	@RequestMapping(value = "showtransfer/showtransfer/transfer", method = RequestMethod.POST)
	public ModelAndView fundTransfer(@ModelAttribute("transfer") @Valid TransactionDTO transactionDTO,
			BindingResult result, Model model) {
		String accNotExists = "";
		String zero="";
		if (result.hasErrors()) {
			return new ModelAndView("fundtransfer");
		}
		if (transactionDTO.getAmountBig().equals(new BigDecimal("0"))) {
			zero ="amount cannot be zero";
			model.addAttribute("zero", zero);
			return new ModelAndView("fundtransfer");
		}
		if (transactionDTO.getAccountNo().equals(transactionDTO.getAccountnoben())) {
			return new ModelAndView("fundtransfer");
		}

		try {
			transactionDTO.setAmount(transactionDTO.getAmountBig().doubleValue());
			AccountDTO accountDTO = service.transferFund(transactionDTO);
			if (accountDTO == null) {
				accNotExists = "You have entered wrong account number " + transactionDTO.getAccountNo();
				model.addAttribute("check", accNotExists);
				return new ModelAndView("fundtransfer");
			}
		} catch (InsufficientBalanceException e) {
			this.error = true;
			model.addAttribute("error", error);
			logger.error(e);
			return new ModelAndView("fundtransfer");
		}
		logger.info("fund transfer has started");
		return new ModelAndView("redirect:/details");
	}

	/**
	 * @param accountNo
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/statement/{userId}", method = RequestMethod.GET)
	public ModelAndView getStatement(@PathVariable("userId") String userId) {
		ModelAndView modelAndView = new ModelAndView("transactionDetail");
		List<TransactionDTO> transactions = service.getStatement(userId);
		modelAndView.addObject("transactions", transactions);
		logger.info("Uploaded tranaction details of particular user");
		return modelAndView;

	}

}
