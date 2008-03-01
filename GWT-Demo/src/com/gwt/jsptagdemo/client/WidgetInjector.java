package com.gwt.jsptagdemo.client;

import java.util.Iterator;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * <h1>Widget Injector</h1>
 * <p>
 * The documented way of creating a Widget states that we need to use RootPanel.get() or 
 * RootPanel.get(id) to place a Widget in the page.
 * </p>
 * <p>
 * The whole problem with this approach is that we need to place the <i><b>id</b></i> in the code. Also another constraint that
 * we can see is that the widget we make can only be injected at a specified place.
 * </p>
 * <p>
 * In a typical ajax development team, we would have GWT developers and some JSP (non-GWT) developers. 
 * The idea here is to use JSP 2.0 Tag Files to allow GWT developers to ship the rich widgets developed by them
 * to the JSP developers.  
 * </p>
 * <p>
 * Imagine if a GWT Developer could provide a ShuffleBox to the JSP developers as follows <br/><br/> <code>
 * &lt;h2&gt;Shuffle&lt;/h2&gt;<br/>
 * &lt;div id='shuffle' widget='ShuffleBox'/&gt;<br/>
 * <br/> Please note in this case the <b>id</b> and <b>widget</b> are the necessary attributes
 * </p>
 * @author Rohit Ghatol
 * 
 */
public abstract class WidgetInjector implements EntryPoint {

  /**
   * Finds all the html elements in the page with <i><b>widget</b></i> attribute and then
   * places the Widget inside it. The widget to be place is retrieved using the abstract method <b>createWidget()</b>.
   * Once the widget has been added, another method named <b>onWidgetLoad()</b> is being called for allowing user to 
   * do post initialization actions.
   */
  public void onModuleLoad() {
    final List placeHolders = (List) GWTPageContext.getInstance()
        .getWidgetPlaceHolder().get(getModuleName());
    if (placeHolders != null) {
      final Iterator iter = placeHolders.iterator();
      while (iter.hasNext()) {
        final Element placeHolder = (Element) iter.next();
        final String id = DOM.getElementAttribute(placeHolder, "id");
        if (id != null && id.trim().length() > 0) {
          final Widget widget = createWidget(id);
          RootPanel.get(id).add(widget);
          onWidgetLoad();
        }
      }
    }
  }

  /**
   * 
   * 
   * @return The Class name of the Module
   */
  private String getModuleName() {
    final String pkgName = GWT.getModuleName();
    return pkgName.substring(pkgName.lastIndexOf('.') + 1);
  }

  /**
   * @param id The unique id 
   * @param key The key whose value has to be retrieved. 
   * @return The value of the given key
   */
  public String getValue(final String id,final String key) {
    return DOM.getElementAttribute(DOM.getElementById(id), key);
  }

  /**
   * Abstract method which allows user to create the Widge to be injected
   */
  public abstract Widget createWidget(final String id);
  
  /**
   * Abstract method for Post initialization logic 
   * 
   */
  public abstract void onWidgetLoad();

}
