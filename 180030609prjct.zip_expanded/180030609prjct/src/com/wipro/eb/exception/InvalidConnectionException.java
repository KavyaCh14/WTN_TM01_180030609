package com.wipro.eb.exception;

public class InvalidConnectionException extends Exception {
	
	public InvalidConnectionException()
	{
		super();
	}
	public String toString()
	{
		return("Invalid ConnectionType");
	}

}
