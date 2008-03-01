/**
 * 
 */
package com.gwt.demo.client.mvcdemo.view;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MouseWheelListener;
import com.google.gwt.user.client.ui.MouseWheelVelocity;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.demo.client.mvc.Observable;
import com.gwt.demo.client.mvc.Observer;
import com.gwt.demo.client.mvcdemo.model.TemperatureConverter;
import com.gwt.demo.client.mvcdemo.model.TemperatureModel;

/**
 * @author rohit
 * 
 */
public class FahrenietView extends VerticalPanel implements Observer {
	private Label fahrenietLabel;

	public FahrenietView(final TemperatureModel model) {
		Label label = new Label("Fahreniet Editor");
		HorizontalPanel editorPanel = new HorizontalPanel();
		fahrenietLabel = new Label();
		PushButton increment = new PushButton(new Image("uparrow.gif"));
		PushButton decrement = new PushButton(new Image("downarrow.gif"));
		float fahrenietValue = model.getTemperature();
		fahrenietLabel.setText(String.valueOf(fahrenietValue));
		fahrenietLabel.setStyleName("TemperatureEditor");

		increment.addClickListener(new ClickListener() {

			public void onClick(Widget sender) {
				float fahrenietValue = Float.parseFloat(fahrenietLabel.getText()) + 1;
				model.setTemperature(fahrenietValue);

			}
		});

		decrement.addClickListener(new ClickListener() {

			public void onClick(Widget sender) {
				float fahrenietValue = Float.parseFloat(fahrenietLabel.getText()) - 1;
				model.setTemperature(fahrenietValue);

			}
		});
		
		fahrenietLabel.addMouseWheelListener(new MouseWheelListener() {

			public void onMouseWheel(Widget sender, MouseWheelVelocity velocity) {
				int delta=0;
				if(velocity.isNorth()){
					delta=1;
				}
				else if(velocity.isSouth()){
					delta=-1;
				}
				float fahrenietValue = Float.parseFloat(fahrenietLabel.getText()) + delta;
				model.setTemperature(fahrenietValue);
				
			}
		});
		editorPanel.add(fahrenietLabel);
		VerticalPanel buttonPanel=new VerticalPanel();
		buttonPanel.add(increment);
		buttonPanel.add(decrement);
		editorPanel.add(buttonPanel);
		this.add(label);
		this.add(editorPanel);
		
		model.addObserver(this);
	}

	public void update(Observable model, Object hint) {
		float fahrenietValue = ((TemperatureModel)model).getTemperature();
		fahrenietLabel.setText(String.valueOf(fahrenietValue));
	}
}
