package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException 
	{
		
		if(currentReading<previousReading || currentReading<0 || previousReading<0)
		{
			throw new InvalidReadingException();
		}
		else if(!(type.equals("Domestic") || type.equals("Commercial")))
		{
			throw new InvalidConnectionException();
		}
		return true; 
	}
		
	
	public float calculateBillAmt(int currentReading, int previousReading, String type)  
	{
		float bill = 0;
		try 
		{
			validate(currentReading, previousReading, type);
			if(type.equals("Domestic"))
			{
				Domestic d=new Domestic();
				bill=d.computeBill(currentReading, previousReading);
			}
			if(type.equals("Commercial"))
			{
				Commercial c=new Commercial();
				bill=c.computeBill(currentReading, previousReading);
			}
		} 
		catch (InvalidReadingException e) 
		{
			return -1;
		}
        catch (InvalidConnectionException e) 
		{
        	return -2;
		}
		return bill;
		
	}
	public String generateBill(int currentReading, int previousReading, String type) 
	{
		float r=calculateBillAmt(currentReading, previousReading, type);
		if(r==-1)
		{
			return "Incorrect Reading";
		}
		else if(r==-2)
		{
			return "Invalid ConnectionType";
		}
		else
		{
			return "Amount to be paid: "+r;
		}
		
		
	}
}
