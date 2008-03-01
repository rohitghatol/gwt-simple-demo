/**
 * 
 */
package com.gwt.demo.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * @author rohit
 * 
 */
public class LocationServiceUtil {
	public static LocationServiceAsync  createService() {
		LocationServiceAsync serviceAsync = (LocationServiceAsync) GWT
				.create(LocationService.class);
		
		((ServiceDefTarget) serviceAsync).setServiceEntryPoint(GWT
				.getModuleBaseURL()
				+

				"/LocationService");
		return serviceAsync;
	}
}
