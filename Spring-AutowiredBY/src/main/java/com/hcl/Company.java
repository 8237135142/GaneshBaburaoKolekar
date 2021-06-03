package com.hcl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("company")
public class Company {

	private String companyName;
	private int companyId;
	
	private List<String> location;
	
	private Map<String, String> speciality;

	private Address address2;

	public Company() {
		System.out.println("HCL Tech");
	}

}
