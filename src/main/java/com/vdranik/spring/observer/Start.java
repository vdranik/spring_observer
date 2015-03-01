package com.vdranik.spring.observer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");// ("beanRefContext.xml"); получение бина из beanRefContext
		context.registerShutdownHook();
		Subject subject = context.getBean(ConcreteSubject.class);
		// String message = new String("Hello Spring!");
		// subject.notifyObservers(message);

		// создание бина через java bean definition
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setInitMethodName("init");
		beanDefinition.setDestroyMethodName("destroy");
		beanDefinition.setBeanClass(ConcreteObserver.class);
		beanDefinition.setLazyInit(true);
		beanDefinition.setAbstract(false);
		beanDefinition.setAutowireCandidate(true);
		beanDefinition.setScope("prototype");
		beanFactory.registerBeanDefinition("concreteObserver", (BeanDefinition) beanDefinition);

		ConcreteObserver concreteObserver1 = context.getBean("concreteObserver", ConcreteObserver.class);
		ConcreteObserver concreteObserver2 = context.getBean("concreteObserver", ConcreteObserver.class);

		List<Observer> concreteObservers_FIRST_LIST = new ArrayList<Observer>();
		concreteObservers_FIRST_LIST.add(concreteObserver1);
		concreteObservers_FIRST_LIST.add(concreteObserver2);
		subject.setObservers(concreteObservers_FIRST_LIST);
		subject.notifyObservers("Hello");
		subject.removeAllObservers();
		System.out.println("======================================================================================");

		ConcreteObserver concreteObserver3 = context.getBean("concreteObserver", ConcreteObserver.class);
		// List<Observer> concreteObservers_SECOND_LIST = new ArrayList<Observer>();
		// concreteObservers_SECOND_LIST.add(concreteObserver3);
		// subject.setObservers(concreteObservers_SECOND_LIST);
		subject.addObserver(concreteObserver3);
		subject.notifyObservers("Spring!");
	}
}