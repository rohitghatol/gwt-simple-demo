/**
 * 
 */
package com.gwt.demo.client.extendingcomponents;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.ListBox;

/**
 * @author rohit
 * 
 */
public class AdvListBoxDemo extends HorizontalPanel {
	public AdvListBoxDemo() {
		this.add(new Label("Advanced List Box:"));
		AdvListBox box = new AdvListBox();
		box.setVisibleItemCount(10);
		box.addItem("A");
		box.addItem("B");
		box.addItem("C");
		box.addItem("D");
		this.add(box);

		box.add(new DoubleClickListener() {

			public void onDoubleClick(Widget sender) {
				ListBox box=(ListBox)sender;
				Window.alert("You double clicked "+box.getItemText(box.getSelectedIndex()));
				
			}
		});
	}
}
