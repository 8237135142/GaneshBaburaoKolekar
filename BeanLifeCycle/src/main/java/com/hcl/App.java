package com.hcl;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationcontext.xml");
		Lifecycle lifecycle = applicationContext.getBean("lifecycle", Lifecycle.class);
		applicationContext.registerShutdownHook();

	}
}
