package com.vdranik.spring.observer;
public class Listener implements PublisherActionListener {

	@Override
	public void notifyListener(Subject subj) {
		System.out.println(subj.getMessage());
	}
}
