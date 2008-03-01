/**
 * 
 */
package com.gwt.demo.client.mvcdemo.view;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwt.demo.client.mvc.Observable;
import com.gwt.demo.client.mvc.Observer;
import com.gwt.demo.client.mvcdemo.model.TemperatureConverter;
import com.gwt.demo.client.mvcdemo.model.TemperatureModel;

/**
 * @author rohit
 * 
 */
public class CelciusThermometerView extends VerticalPanel implements Observer {

	private HTML tube = null;

	private static String stylePrefix = "transparent url(red.gif) repeat-x scroll 0px ";

	public CelciusThermometerView(TemperatureModel model) {
		tube = new HTML();
		tube.setStyleName("Tube");
		this.add(tube);
		Image image = new Image("Thermometer.gif");
		this.add(image);
		this.setValue(TemperatureConverter.getCelius(model.getTemperature()));
		model.addObserver(this);
	}

	private void setValue(float celciusValue) {
		int cssvalue = 0;
		if (celciusValue <= 100) {
			cssvalue = (int) (200 - (celciusValue * 2));
		} 
		String value = stylePrefix + cssvalue + "px";
		DOM.setStyleAttribute(tube.getElement(), "background", value);
	}

	public void update(Observable model, Object hint) {
		setValue(TemperatureConverter.getCelius(((TemperatureModel) model)
				.getTemperature()));

	}

}
