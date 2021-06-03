package com.hcl;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Lifecycle lifecycle = context.getBean("lifecycle", Lifecycle.class);
		context.registerShutdownHook();

	}
}
