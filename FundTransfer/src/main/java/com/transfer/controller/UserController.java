package com.transfer.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.transfer.command.UserCmd;
import com.transfer.dto.UserDTO;
import com.transfer.service.UserService;
import com.transfer.validations.LoginValidator;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	private LoginValidator validator;

	private Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showForm(Model model) {
		logger.info("execute show FormPage......");
		UserCmd user = new UserCmd();
		model.addAttribute("userCmd", user);
		// return lvn
		return "login";
	}// method

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processForm(Model model, @ModelAttribute("userCmd") UserCmd cmd, BindingResult errors,
			HttpSession session) {
		// convert cmd object to dto
		UserDTO udto = new UserDTO();
		udto.setUname(cmd.getUname());
		udto.setPwd(cmd.getPwd());

		// user validator
		if (validator.supports(UserCmd.class)) {
			validator.validate(cmd, errors);
			if (errors.hasErrors()) {
				return "login";
			}
//			else
//				return "login";
		}

		UserDTO userdto = service.checkLogin(cmd.getUname(), cmd.getPwd());
		if (userdto.getUname() != null && userdto.getPwd() != null) {
			System.out.println("UserId in a login     :" + userdto.getId());
			System.out.println("UserName in a login     :" + userdto.getUname());
			System.out.println("Email in a login     :" + userdto.getEmail());
			
			// session.setAttribute("loginForm", userdto);
			model.addAttribute("user", userdto);
			
			logger.info("after login request forword to home page");
			return "home";
		} else {
			errors.rejectValue("userName", "invaliduser");
			return "login";
		}
	}
}// class
