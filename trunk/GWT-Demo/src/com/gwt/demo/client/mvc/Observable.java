/**
 * 
 */
package com.gwt.demo.client.mvc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author rohit
 * 
 */
public class Observable implements Serializable {
	private List observers;

	/**
	 * Add an Observer
	 * 
	 * @param observer
	 *            Add Observer who is interested in this Observable
	 * 
	 */
	public void addObserver(Observer observer) {
		if (observers == null) {
			observers = new ArrayList();
		}
		observers.add(observer);
	}

	/**
	 * Remove an Observer
	 * 
	 * @param observer
	 *            Remove Observer who is no longer interested in this Observable
	 */
	public void removeObserver(Observer observer) {
		if (observers != null) {
			observers.remove(observer);
		}
	}

	/**
	 * Notify all the Observer of a change
	 * 
	 */
	public void notifyObservers() {
		notifyObservers(null);
	}

	/**
	 * Notify all the Observer of a change along with an Hint Object
	 * 
	 * @param hint
	 *            Hint to the Observers as to what they should do.
	 */
	public void notifyObservers(Object hint) {
		if (observers != null) {
			Iterator iter = this.observers.iterator();
			while (iter.hasNext()) {
				Observer observer = (Observer) iter.next();
				observer.update(this, hint);
			}
		}
	}

}
