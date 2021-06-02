package com.transfer.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.transfer.dto.TransactionDTO;
import com.transfer.service.TransactionService;

@Controller
@RequestMapping("/transections")
public class TransactionController {
	@Autowired
	private TransactionService txnService;

	private Logger logger = Logger.getLogger(TransactionController.class);

	@RequestMapping(value = "/txnHistory", method = RequestMethod.GET)
	public String fundTransfer(Model model) {
		System.out.println("TransectionController");
		
		// convert cmd object to dto
		List<TransactionDTO> dto = new ArrayList<TransactionDTO>();

		dto = txnService.fatchTransection();
		if (dto != null)
			model.addAttribute("txnList", dto);
		logger.info("after login request forword to home page");
		return "txnDetails";
	}
}
