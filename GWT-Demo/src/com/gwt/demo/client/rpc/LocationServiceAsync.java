/**
 * 
 */
package com.gwt.demo.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author rohit
 * 
 */
public interface LocationServiceAsync {
	void getStates(String country, AsyncCallback callback);
}
