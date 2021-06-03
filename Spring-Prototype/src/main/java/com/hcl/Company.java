package com.hcl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Company {

	private int companyId;

	private String companyName;

	@Autowired
	private Address address;

	public void setAddress() {
		Address address = getAdress();
	}

	@Lookup
	public Address getAdress() {
		return null;
	}

	public Company() {
		System.out.println("HCL Tech");
	}
}
