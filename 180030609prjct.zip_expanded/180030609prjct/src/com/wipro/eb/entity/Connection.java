package com.wipro.eb.entity;

public abstract class Connection {
	private static int previousReading;
	private static int currentReading;
	static float[] slabs;
	public Connection(int currentReading, int previousReading,float slabs[])
	{
		Connection.currentReading=currentReading;
		Connection.previousReading=previousReading;
		Connection.slabs=slabs;
	}
	
	public abstract float computeBill(int cr,int pr);
	
	
	public static int getcurrentReading() 
	{
		return currentReading;
	}

	public void setcurrentReading(int currentReading) 
	{
		Connection.currentReading = currentReading;
	}
	
	public static int getpreviousReading() 
	{
		return currentReading;
	}

	public void setpreviousReading(int previousReading) 
	{
		Connection.previousReading = previousReading;
	}

}
