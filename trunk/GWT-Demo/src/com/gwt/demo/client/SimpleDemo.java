package com.gwt.demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwt.demo.client.extendingcomponents.AdvListBoxDemo;
import com.gwt.demo.client.mvcdemo.model.TemperatureModel;
import com.gwt.demo.client.mvcdemo.view.CelciusThermometerView;
import com.gwt.demo.client.mvcdemo.view.CeliusView;
import com.gwt.demo.client.mvcdemo.view.FahrenietView;
import com.gwt.demo.client.rpcdemo.RPCDemoView;
import com.gwt.demo.client.shufflebox.ShuffleBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SimpleDemo implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		//Uncomment only one of the following to see its demo
		shuffleBoxDemo();
		//mvcDemo();
		//rpcDemo();
		//extendingWidgetsDemo();
	}

	private void shuffleBoxDemo() {
		ShuffleBox shuffleBox = new ShuffleBox(DataProvider.getLeftList(),
				DataProvider.getRightList());
		shuffleBox.setStyleName("ShuffleBox");
		RootPanel.get().add(shuffleBox);

	}

	private void mvcDemo() {
		TemperatureModel model = new TemperatureModel();
		model.setTemperature(100);

		FahrenietView fahrenietView = new FahrenietView(model);
		CeliusView celiusView = new CeliusView(model);
		CelciusThermometerView thermometerView = new CelciusThermometerView(
				model);

		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setWidth("100%");
		hPanel.add(fahrenietView);
		hPanel.add(celiusView);
		hPanel.add(thermometerView);
		RootPanel.get().add(hPanel);
	}
	
	private void rpcDemo(){
		RPCDemoView view=new RPCDemoView();
		RootPanel.get().add(view);
	}
	private void extendingWidgetsDemo(){
		AdvListBoxDemo view= new AdvListBoxDemo();
		RootPanel.get().add(view);
	}
}
