package com.vdranik.spring.observer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ConcreteSubject implements Subject, ApplicationContextAware, BeanNameAware, BeanFactoryAware, InitializingBean {

	private List<Observer> observers = new ArrayList<Observer>();

	public ConcreteSubject() {
		System.out.println("create ConcreteSubject");
	}

	@Override
	public List<Observer> getObservers() {
		return observers;
	}

	@Override
	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(Observer listener) {
		observers.remove(listener);
	}

	@Override
	public void removeAllObservers() {
		getObservers().clear();
	}

	@Override
	public void notifyObservers(String message) {
		for (Observer observer : getObservers()) {
			observer.notify(message);
		}
	}

	public void init() {
		System.out.println(this + " init ConcreteSUBJECT");
	}

	public void destroy() {
		System.out.println(this + " destroy ConcreteSUBJECT");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(this + " afterPropertiesSet");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println(this + " BEAN FACTORY - " + beanFactory);
	}

	@Override
	public void setBeanName(String name) {
		System.out.println(this + " bean name " + name);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(this + " applicationContext " + applicationContext);
	}
}