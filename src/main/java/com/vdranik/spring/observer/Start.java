package com.vdranik.spring.observer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Publisher publisher = context.getBean(Publisher.class);

		Subject subject = new Subject("Hello Spring!");
		publisher.notifyAllListeners(subject);
	}
}