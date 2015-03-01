package com.vdranik.spring.observer;

import java.util.List;

public interface Subject {

	List<Observer> getObservers();

	void setObservers(List<Observer> observers);

	void addObserver(Observer observer);

	public void removeObserver(Observer listener);

	public void removeAllObservers();

	public void notifyObservers(String message);
}