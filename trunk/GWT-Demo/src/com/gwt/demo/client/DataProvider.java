package com.gwt.demo.client;

import java.util.ArrayList;
import java.util.List;

import com.gwt.demo.client.rpcdemo.model.ListBoxModel;

public class DataProvider {

	public static List getLeftList() {
		List leftList = new ArrayList();
		leftList.add("Admin");
		leftList.add("Supervisor");
		leftList.add("Client");
		return leftList;
	}

	public static List getRightList() {
		List rightList = new ArrayList();
		rightList.add("Agent");
		return rightList;
	}
	
	public static ListBoxModel getCountryListBoxModel(){
		ListBoxModel model=new ListBoxModel();
		List entries=new ArrayList();
		entries.add("");
		entries.add("USA");
		entries.add("India");
		model.setEntries(entries);
		return model;
	}
}
