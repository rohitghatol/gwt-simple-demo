/**
 * 
 */
package com.gwt.jsptagdemo.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.demo.client.shufflebox.ShuffleBox;

/**
 * @author rohit
 * 
 */
public class ShuffleBoxTag extends WidgetInjector {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gwt.jsptagdemo.client.WidgetInjector#createWidget(java.lang.String)
	 */
	@Override
	public Widget createWidget(String id) {
		return new ShuffleBox(null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gwt.jsptagdemo.client.WidgetInjector#onWidgetLoad()
	 */
	@Override
	public void onWidgetLoad() {
		Window.alert("Widget attached");

	}

}
