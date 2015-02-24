package com.vdranik.spring.observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements PublisherInterface {

	private List<PublisherActionListener> listeners = new ArrayList<PublisherActionListener>();

	@Override
	public List<PublisherActionListener> getListeners() {
		return listeners;
	}

	@Override
	public void setListeners(List<PublisherActionListener> listeners) {
		this.listeners = listeners;
	}

	@Override
	public void removeListener(PublisherActionListener listener) {
		listeners.remove(listener);

	}

	@Override
	public void removeAllListeners() {
		getListeners().clear();
	}

	@Override
	public void notifyAllListeners(Subject subj) {
		for (PublisherActionListener l : getListeners()) {
			l.notifyListener(subj);
		}
	}
}