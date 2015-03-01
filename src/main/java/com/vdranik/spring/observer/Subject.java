package com.vdranik.spring.observer;
public class Subject {

	private String message;

	public Subject() {
        //local code review (vtegza): no need to call super() @ 01.03.15
		super();
	}

	public Subject(String message) {
        //local code review (vtegza): no need to call super() @ 01.03.15
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