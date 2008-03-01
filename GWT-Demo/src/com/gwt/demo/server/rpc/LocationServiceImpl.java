/**
 * 
 */
package com.gwt.demo.server.rpc;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.demo.client.rpc.LocationService;

/**
 * @author rohit
 *
 */
public class LocationServiceImpl extends RemoteServiceServlet implements
		LocationService {

	public List getStates(String country) {
		List states=new ArrayList();
		if(country.equals("USA")){
			states.add("California");
			states.add("Texas");
		}
		else if(country.equals("India")){
			states.add("Maharashtra");
			states.add("MadyaPradesh");
			states.add("AndhraPradesh");
			states.add("Kerala");
			states.add("Karnataka");
			states.add("HimachalPradesh");
			states.add("Jammu and Kashmir");
			states.add("ArunachalPradesh");
			states.add("Kerala");
			
		}
		return states;
	}

}
