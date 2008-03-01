package com.gwt.demo.client.shufflebox;

import java.util.Iterator;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ShuffleBox extends HorizontalPanel {

	
	private ListBox leftListBox=null;
	private ListBox rightListBox=null;
	
	public ShuffleBox(List leftList,List rightList){
		leftListBox=populateListBox(leftList);
		rightListBox=populateListBox(rightList);
		this.add(leftListBox);
		this.add(getButtonPanel());
		this.add(rightListBox);
	}
	
	private ListBox populateListBox(List list){
		ListBox listBox=new ListBox();
		Iterator iter=list.iterator();
		while(iter.hasNext()){
			String value=(String)iter.next();
			listBox.addItem(value);
		}
		listBox.setVisibleItemCount(10);
		return listBox;
	}
	
	private VerticalPanel getButtonPanel(){
		Button moveRight=new Button("&gt;");
		moveRight.addClickListener(new ClickListener(){

			public void onClick(Widget sender) {
				int leftIndex=leftListBox.getSelectedIndex();
				if(leftIndex==-1){
					Window.alert("Select an Item from Left List Box");
				}
				else{
					String item=leftListBox.getItemText(leftIndex);
					leftListBox.removeItem(leftIndex);
					rightListBox.addItem(item);
				}
			}
			
		});
		
		Button moveLeft=new Button("&lt;");
		moveLeft.addClickListener(new ClickListener(){

			public void onClick(Widget sender) {
				int rightIndex=rightListBox.getSelectedIndex();
				if(rightIndex==-1){
					Window.alert("Select an Item from Right List Box");
				}
				else{
					String item=rightListBox.getItemText(rightIndex);
					rightListBox.removeItem(rightIndex);
					leftListBox.addItem(item);
				}
			}
			
		});
		
		VerticalPanel vPanel=new VerticalPanel();
		vPanel.add(moveRight);
		vPanel.add(moveLeft);
		return vPanel;
	}
	
	
}
