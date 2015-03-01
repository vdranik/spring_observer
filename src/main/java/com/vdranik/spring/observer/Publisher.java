package com.vdranik.spring.observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements PublisherInterface {

    //local code review (vtegza): could be final @ 01.03.15
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
        //local code review (vtegza): prefer readable names @ 01.03.15
        for (PublisherActionListener l : getListeners()) {
			l.notifyListener(subj);
		}
	}
}