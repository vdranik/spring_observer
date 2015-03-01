package com.vdranik.spring.observer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ConcreteObserver implements Observer, ApplicationContextAware, BeanNameAware, BeanFactoryAware, InitializingBean {

	private BeanFactory beanFactory;
	private ApplicationContext applicationContext;
	private String name;

	public ConcreteObserver() {
		System.out.println("create ConcreteObserver");
	}

	@Override
	public void notify(String message) {
		System.out.println(message);
	}

	public void init() {
		System.out.println(this + " init ConcreteOBSERVER");
	}

	public void destroy() {
		System.out.println(this + " destroy ConcreteOBSERVER");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(this + " afterPropertiesSet");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println(this + " BEAN FACTORY - " + beanFactory);
		this.beanFactory = beanFactory;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println(this + " bean name " + name);
		this.name = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(this + " applicationContext " + applicationContext);
		this.applicationContext = applicationContext;
	}
}
