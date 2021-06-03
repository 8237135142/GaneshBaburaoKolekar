package com.hcl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Company company = context.getBean("company", Company.class);

		company.setCompanyId(121);
		company.setCompanyName("Hcl");

		System.out.println(company);
		System.out.println(company.getAddress());
		Thread.sleep(10000);
		System.out.println(company.getAddress());

	}
}
