package com.transaction.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.transaction.dto.AccountDTO;
import com.transaction.dto.UserDTO;
import com.transaction.model.Login;
import com.transaction.service.AccountService;
import com.transaction.service.UserService;

@Controller
public class UserController {
	
	private Logger logger= Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;
	private int userid;

	/**
	 * @param login
	 * @return ModelAndView
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
	    return "index";
	} 
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView showLoginPage(@ModelAttribute("login") Login login) {
		Login log = new Login();
		return new ModelAndView("login").addObject(log);

	}

	/**
	 * @param login
	 * @param result
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login") @Valid Login login, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("login");
		}
		UserDTO dto = userService.valdiateUser(login.getUsername(), login.getPassword());
		logger.info("user logged in with username : " + login.getUsername());
		if (dto != null) {
			userid = dto.getUserId();
			return new ModelAndView("redirect:/details");
		}
		return new ModelAndView("accessdenied").addObject("message", "Wrong Credentails");

	}

	/**
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView getDetails() {
		ModelAndView modelAndView = new ModelAndView();
		UserDTO userDTO = userService.getUserByUserId(userid);
		AccountDTO accountDTO = accountService.getAccountDetails(userid);
		modelAndView.addObject("account", accountDTO);
		modelAndView.addObject("user", userDTO);
		modelAndView.setViewName("accountsummary");
		logger.info("Account information of user with userid : " + userid);
		return modelAndView;
	}

}

