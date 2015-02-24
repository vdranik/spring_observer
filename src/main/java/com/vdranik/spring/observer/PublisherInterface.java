package com.vdranik.spring.observer;

import java.util.List;

public interface PublisherInterface {

	List<PublisherActionListener> getListeners();

	void setListeners(List<PublisherActionListener> listeners);

	public void removeListener(PublisherActionListener listener);

	public void removeAllListeners();

	public void notifyAllListeners(Subject subj);
}