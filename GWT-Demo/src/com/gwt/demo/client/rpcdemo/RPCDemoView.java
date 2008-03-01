package com.gwt.demo.client.rpcdemo;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.demo.client.DataProvider;
import com.gwt.demo.client.rpc.LocationServiceAsync;
import com.gwt.demo.client.rpc.LocationServiceUtil;
import com.gwt.demo.client.rpcdemo.model.ListBoxModel;
import com.gwt.demo.client.rpcdemo.view.ListBoxView;

public class RPCDemoView extends VerticalPanel {

	public RPCDemoView() {
		final ListBoxView countriesListBox = new ListBoxView(DataProvider
				.getCountryListBoxModel());
		final ListBoxModel statesListBoxModel = new ListBoxModel();
		final ListBoxView statesListBox = new ListBoxView(statesListBoxModel);
		statesListBox.setVisibleItemCount(10);
		countriesListBox.addChangeListener(new ChangeListener() {

			public void onChange(Widget sender) {
				String country = countriesListBox.getItemText(countriesListBox
						.getSelectedIndex());
				LocationServiceAsync serviceAsync = LocationServiceUtil
						.createService();
				serviceAsync.getStates(country, new AsyncCallback() {

					public void onFailure(Throwable caught) {
						Window.alert("System Error!");

					}

					public void onSuccess(Object result) {
						List list = (List) result;
						statesListBoxModel.setEntries(list);
					}
				});
			}

		});
		this.add(new Label("Countries:"));
		this.add(countriesListBox);
		this.add(new Label("States:"));
		this.add(statesListBox);
	}
}
