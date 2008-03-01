/**
 * 
 */
package com.gwt.demo.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * @author rohit
 *
 */
public interface LocationService extends RemoteService {
	List getStates(String country);
}
