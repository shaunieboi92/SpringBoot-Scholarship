package com.demo.Exception;

public class SSTAException extends Exception{
	public String toString() {
	      return "SSTAException[" + message + "]";
	}
	
	public String message;

	public SSTAException(String message) {
		super();
		this.message = message;
	}
	
}
