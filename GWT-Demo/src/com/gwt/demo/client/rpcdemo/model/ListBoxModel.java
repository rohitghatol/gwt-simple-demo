/**
 * 
 */
package com.gwt.demo.client.rpcdemo.model;

import java.util.ArrayList;
import java.util.List;

import com.gwt.demo.client.mvc.Observable;

/**
 * @author rohit
 * 
 */
public class ListBoxModel extends Observable {
	private List entries=new ArrayList();

	public List getEntries() {
		return entries;
	}

	public void setEntries(List entries) {
		this.entries = entries;
		this.notifyObservers();
	}
}
