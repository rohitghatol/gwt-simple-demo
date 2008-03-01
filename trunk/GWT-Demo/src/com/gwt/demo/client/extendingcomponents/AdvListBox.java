/**
 * 
 */
package com.gwt.demo.client.extendingcomponents;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.ListBox;

/**
 * @author rohit
 * 
 */
public class AdvListBox extends ListBox {
	private DoubleClickListenerCollection dblClickListeners = new DoubleClickListenerCollection();

	public AdvListBox() {
		this.sinkEvents(Event.ONDBLCLICK);
	}

	public void onBrowserEvent(Event event) {
		super.onBrowserEvent(event);
		if(DOM.eventGetType(event)==Event.ONDBLCLICK){
			dblClickListeners.fireDoubleClickEvent(this);
		}
		
	}

	public void add(DoubleClickListener listener) {
		dblClickListeners.add(listener);
	}

	public void remove(DoubleClickListener listener) {
		dblClickListeners.remove(listener);
	}

}
