/**
 * 
 */
package com.gwt.demo.client.mvcdemo.model;

import com.gwt.demo.client.mvc.Observable;

/**
 * @author rohit
 *
 */
public class TemperatureModel extends Observable {
	//Temperature in fahreniet
	private float temperature;

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
		notifyObservers();
	}
	
}
