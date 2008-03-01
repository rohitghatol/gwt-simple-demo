/**
 * 
 */
package com.gwt.demo.client.extendingcomponents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.user.client.ui.Widget;

/**
 * @author rohit
 * 
 */
public class DoubleClickListenerCollection {
	private List listeners = new ArrayList();

	public void add(DoubleClickListener listener) {
		listeners.add(listener);
	}

	public void remove(DoubleClickListener listener) {
		listeners.remove(listener);
	}
	
	public void fireDoubleClickEvent(Widget sender){
		Iterator iter=listeners.iterator();
		while(iter.hasNext()){
			DoubleClickListener listener=(DoubleClickListener)iter.next();
			listener.onDoubleClick(sender);
		}
	}
}
