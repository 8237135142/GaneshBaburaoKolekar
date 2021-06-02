package com.hcl;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Scope;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @ToString
public class Address {

	private String country;
	private String city;
	private int pincode;

	public String getDate() {
		String date = LocalDateTime.now().toString();
		return date;
	}

}
