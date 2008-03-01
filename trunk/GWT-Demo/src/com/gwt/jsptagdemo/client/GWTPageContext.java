package com.gwt.jsptagdemo.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * This is the GWT page context. This context stores and categories all the
 * location where widgets have to be injected.
 * <p>
 * Say a HTML page contains following divs
 * 
 * <pre>
 * &lt;div widget=&quot;ShuffleBox&quot; id=&quot;shuffle&quot;/&gt;&lt;br/&gt;
 * &lt;div widget=&quot;ShuffleBox&quot; id=&quot;shuffle2&quot;/&gt;&lt;br/&gt;
 * &lt;div widget=&quot;ColorPicker&quot; id=&quot;colorPicker1&quot;/&gt;&lt;br/&gt;
 * &lt;div widget=&quot;Calendar&quot; id=&quot;calendar1&quot;/&gt;&lt;br/&gt;
 * </pre>
 * 
 * The GWT page context will look for these divs and store and categorize them
 * in itself. When the widget injector comes into action, it will refer to the
 * GWTPageContext to get all the placeholder for its type
 * 
 * @author Rohit Ghatol
 */
public class GWTPageContext {

	private static GWTPageContext singleton = new GWTPageContext();

	private static String Widget = "widget";

	/**
	 * @return singleton instance of GWTPageContext
	 */
	public static GWTPageContext getInstance() {
		return singleton;
	}

	// stores widget types against List of ids
	private Map map = null;

	/**
	 * Private Constructor
	 */
	private GWTPageContext() {
	}

	/**
	 * 
	 * @return Categorized Map of widget injector locations. Categories by Type
	 *         of widget
	 */
	public Map getWidgetPlaceHolder() {
		//TODO - implement this
		return null;
	}


}
