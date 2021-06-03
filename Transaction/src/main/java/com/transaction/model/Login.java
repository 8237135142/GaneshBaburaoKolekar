package com.transaction.model;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
@Data
public class Login {

	@NotEmpty(message = "enter username")
	private String username;

	@NotEmpty(message = "enter password")
	private String password;

}

