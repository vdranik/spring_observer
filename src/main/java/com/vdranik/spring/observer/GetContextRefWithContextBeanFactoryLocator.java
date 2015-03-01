package com.vdranik.spring.observer;

import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;

public class GetContextRefWithContextBeanFactoryLocator {
	public static void main(String[] args) {
		callContext("first");
		callContext("second");
	}

	private static void callContext(String value) {
		BeanFactoryLocator bfl = ContextSingletonBeanFactoryLocator.getInstance();
		BeanFactoryReference bf = bfl.useBeanFactory("mainContext");

		Subject subject = (Subject) bf.getFactory().getBean("concreteSubject");
		String message = new String("Hello Spring");
		subject.notifyObservers(message);

	}
}
