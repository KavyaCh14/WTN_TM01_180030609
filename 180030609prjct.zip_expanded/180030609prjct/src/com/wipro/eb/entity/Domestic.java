package com.wipro.eb.entity;

public class Domestic extends Connection {

	public Domestic(int currentReading, int previousReading, float[] slabs) {
		super(currentReading, previousReading, slabs);
		
	}

	int cr,pr;
	static float[] Slabs= {2.3f,4.2f,5.5f};
	public Domestic() {
		super(getpreviousReading(), getcurrentReading(), slabs);
		this.cr=getcurrentReading();
		this.pr=getpreviousReading();
		
	}
	
	public float computeBill(int cr,int pr) {
		int res=cr-pr;
		float amt=0;
		
		//computation of Bill
		if(res>=100)
		{
			amt+=(50)*Slabs[0]+(50)*Slabs[1]+(res-100)*Slabs[2];
		}
		if(res>50 && res<100)
		{
			amt+=(50)*Slabs[0]+(res-50)*Slabs[1];
		}
		if(res<=50)
		{
			amt+=(res)*Slabs[0];
		}
		return amt;
	}
	

}