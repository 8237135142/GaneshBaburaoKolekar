//package com.spring.lifecycle;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
//
//import com.spring.lifecyclemethod.MessageGenarator;
//
//public class App {
//	public static void main(String[] args) {
//		
//		AbstractApplicationContext context = new FileSystemXmlApplicationContext(
//				"src/main/java/com/spring/basic/applicationContext.xml");
//
//		MessageGenarator emp = (MessageGenarator) context.getBean("emp");
//		emp.show();
//		context.registerShutdownHook();
//
//	}
//}
