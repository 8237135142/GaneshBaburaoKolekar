package com.spring.lookup;

public class RequestHandler {
	private static int count;

	public RequestHandler() {
		count++;
		System.out.println("RequestHandler  :0 Param Constructor");
	}

	public void handle(String data) {

		System.out.println("Hndling Request" + count + "with data:" + data);
	}
}
