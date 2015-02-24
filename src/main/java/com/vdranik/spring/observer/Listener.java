package com.vdranik.spring.observer;

public class Listener implements PublisherActionListener {

	@Override
	public void notifyListener(Subject subject) {
		System.out.println(subject.getMessage());
	}
}
