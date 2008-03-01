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

public class CeliusView extends VerticalPanel implements Observer {
	private Label celiusLabel;

	public CeliusView(final TemperatureModel model) {
		Label label = new Label("Celius Editor");
		HorizontalPanel editorPanel = new HorizontalPanel();
		celiusLabel = new Label();
		PushButton increment = new PushButton(new Image("uparrow.gif"));
		PushButton decrement = new PushButton(new Image("downarrow.gif"));
		float celiusValue = TemperatureConverter.getCelius(model
				.getTemperature());
		celiusLabel.setText(String.valueOf(celiusValue));
		celiusLabel.setStyleName("TemperatureEditor");
		increment.addClickListener(new ClickListener() {

			public void onClick(Widget sender) {
				float celiusValue = Float.parseFloat(celiusLabel.getText()) + 1;
				float fahrenietValue = TemperatureConverter
						.getFahreniet(celiusValue);
				model.setTemperature(fahrenietValue);

			}
		});

		decrement.addClickListener(new ClickListener() {

			public void onClick(Widget sender) {
				float celiusValue = Float.parseFloat(celiusLabel.getText()) - 1;
				float fahrenietValue = TemperatureConverter
						.getFahreniet(celiusValue);
				model.setTemperature(fahrenietValue);

			}
		});
		celiusLabel.addMouseWheelListener(new MouseWheelListener() {

			public void onMouseWheel(Widget sender, MouseWheelVelocity velocity) {
				int delta=0;
				if(velocity.isNorth()){
					delta=1;
				}
				else if(velocity.isSouth()){
					delta=-1;
				}
				float celiusValue = Float.parseFloat(celiusLabel.getText()) + delta;
				float fahrenietValue = TemperatureConverter
						.getFahreniet(celiusValue);
				model.setTemperature(fahrenietValue);
				
			}
		});
		editorPanel.add(celiusLabel);
		VerticalPanel buttonPanel = new VerticalPanel();
		buttonPanel.add(increment);
		buttonPanel.add(decrement);
		editorPanel.add(buttonPanel);
		this.add(label);
		this.add(editorPanel);

		model.addObserver(this);
	}

	public void update(Observable model, Object hint) {
		float celiusValue = TemperatureConverter
				.getCelius(((TemperatureModel) model).getTemperature());
		celiusLabel.setText(String.valueOf(celiusValue));

	}
}
