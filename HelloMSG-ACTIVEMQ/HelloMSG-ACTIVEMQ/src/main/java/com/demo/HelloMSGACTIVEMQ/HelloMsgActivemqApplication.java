package com.demo.HelloMSGACTIVEMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class HelloMsgActivemqApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(HelloMsgActivemqApplication.class, args);
		
		
		
		JmsTemplate jms = ctx.getBean(JmsTemplate.class);
		jms.convertAndSend("java", "test message");
	}

}
