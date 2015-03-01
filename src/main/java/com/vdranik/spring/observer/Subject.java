package com.vdranik.spring.observer;

import java.util.List;

public interface Subject {

	List<Observer> getListeners();

	void setObservers(List<Observer> observers);

	public void removeObserver(Observer listener);

	public void removeAllObservers();

	public void notifyObservers(String message);
}