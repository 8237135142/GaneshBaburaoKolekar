package com.transfer.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.transfer.command.AccountCmd;


public class AccountValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(AccountCmd.class);
	}

	@Override
	public void validate(Object cmd, Errors errors) {
		
		AccountCmd acc = (AccountCmd) cmd;
		if (acc.getAccountNo() ==0 || acc.getAccountNo() < 0) {
			errors.rejectValue("uname", "accno.required");
		}
		if (acc.getAmount() == 0 || acc.getAmount()< 0) {
			errors.rejectValue("pwd", "amount.required");
		} // if
	}

}
