package com.transfer.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.transfer.command.UserCmd;
@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return clazz.isAssignableFrom(UserCmd.class);
	}

	@Override
	public void validate(Object cmd, Errors errors) {
		UserCmd user = (UserCmd) cmd;
		if (user.getUname() == null || user.getUname().equals("") || user.getUname().length() == 0) {
			errors.rejectValue("uname", "uname.required");
		}
		if (user.getPwd() == null || user.getPwd().equals("") || user.getPwd().length() == 0) {
			errors.rejectValue("pwd", "pwd.required");
		} // if

	}// method

}// class
