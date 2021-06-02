package com.spring.lifecycleinit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

//		ApplicationContext context = new FileSystemXmlApplicationContext(
//				"src/main/java/com/spring/lifecyclemethod/applicationContext.xml");
		AbstractApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/java/com/spring/lifecycleinit/applicationContext.xml");
		MessageGenarator bean = context.getBean("emp", MessageGenarator.class);
		String m = bean.show();
		System.out.println(m);
		
	}
}
