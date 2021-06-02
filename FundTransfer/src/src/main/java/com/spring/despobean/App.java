package com.spring.despobean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		AbstractApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/java/com/spring/despobean/applicationContext.xml");
		context.registerShutdownHook();
		Triangle triangle = (Triangle) context.getBean("triangle");
		triangle.draw();
	}
}
