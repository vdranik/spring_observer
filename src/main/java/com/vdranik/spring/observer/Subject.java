package com.vdranik.spring.observer;
public class Subject {

	private String message;

	public Subject() {
		super();
	}

	public Subject(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}