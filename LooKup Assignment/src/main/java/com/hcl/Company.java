package com.hcl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @ToString
public class Company {

	public Company() {
		System.out.println("HCL Technologies");
	}

	private String companyName;
	private int companyId;
	
	@Autowired
	private Address address;

	public Address getAddress() {
		Address address = address();
		return address;
	}

	@Lookup
	public Address address() {
		// TODO Auto-generated method stub
		return null;
	}

}

// creates address bean
// creates company bean
// then injects address into company