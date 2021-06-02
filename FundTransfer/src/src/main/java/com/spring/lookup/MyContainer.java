package com.spring.lookup;

public abstract class MyContainer {

	public MyContainer() {
		System.out.println("MyContainer: 0-Param-constructor");
	}

	public void processRequest(String data) {
		RequestHandler handler = getRequestHandler();
		handler.handle(data);
	}

	public abstract RequestHandler getRequestHandler();
}
