package com.spring.lookup;

import java.awt.Container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/java/com/spring/lookup/applicationContext.xml");
		MyContainer mycontainer = context.getBean("container", MyContainer.class);
		mycontainer.processRequest("");
		mycontainer.processRequest("hari");
		System.out.println(mycontainer.getClass());

	}
}
