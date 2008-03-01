package com.gwt.demo.client.mvcdemo.model;

public class TemperatureConverter {

	public static float getCelius(float fahreniet){
		return (float) ((fahreniet-32)/1.8);
	}
	public static float getFahreniet(float celius){
		return (float) ((celius*1.8)+32);
	}
}
