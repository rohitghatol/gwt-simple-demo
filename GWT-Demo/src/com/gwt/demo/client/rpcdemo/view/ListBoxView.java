/**
 * 
 */
package com.gwt.demo.client.rpcdemo.view;

import java.util.Iterator;

import com.google.gwt.user.client.ui.ListBox;
import com.gwt.demo.client.mvc.Observable;
import com.gwt.demo.client.mvc.Observer;
import com.gwt.demo.client.rpcdemo.model.ListBoxModel;

/**
 * @author rohit
 * 
 */
public class ListBoxView extends ListBox implements Observer {

	public ListBoxView(ListBoxModel model) {
		renderList(model);
		model.addObserver(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gwt.demo.client.mvc.Observer#update(com.gwt.demo.client.mvc.Observable,
	 *      java.lang.Object)
	 */
	public void update(Observable model, Object hint) {
		renderList((ListBoxModel) model);
	}

	private void renderList(ListBoxModel model) {
		if (model != null && model.getEntries() != null) {
			this.clear();
			Iterator iter = model.getEntries().iterator();
			while (iter.hasNext()) {
				String value = (String) iter.next();
				this.addItem(value);
			}
		}
	}

}
