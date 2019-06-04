package com.demo.Service;

import com.demo.Response.SSTAServiceResponse;
import com.demo.Service.impl.SSTAServiceImpl;

/**
 * 
 * @author shaun.lee
 *
 */

public interface SSTAService {
	
	public SSTAServiceResponse processes(String request);
}
