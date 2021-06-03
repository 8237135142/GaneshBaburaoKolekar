package com.hcl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Company company = context.getBean("company", Company.class);
		company.setCompanyId(121);
		company.setCompanyName("HCL");
		System.out.println(company.toString());

	}
}
