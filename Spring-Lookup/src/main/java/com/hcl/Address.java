package com.hcl;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Address {

	private String country;
	private String city;
	private int pincode;

	public String getDate() {
		String date = LocalDateTime.now().toString();
		return date;
	}

}
