package com.wipro.eb.entity;

public class Commercial extends Connection{

	public Commercial(int previousReading, int currentReading, float[] slabs) {
		super(previousReading, currentReading, slabs);
	}

	int cr,pr;
	float[] Slabs= {5.2f,6.8f,8.3f};
	public Commercial() {
		super(getpreviousReading(), getcurrentReading(), slabs);
		this.cr=getcurrentReading();
		this.pr=getpreviousReading();
		
	}

	public float computeBill(int cr,int pr) {
		int res=cr-pr;
		float amt=0;
		
		// Computation of Bill
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
		
		// additional electricity duty
		if(amt>=10000)
		{
			amt*=1.09;
		}
		else if(amt>=5000 && amt<10000)
		{
			amt*=1.06;
		}
		else if(amt<5000)
		{
			amt*=1.02;
		}
		return amt;
	}
	

}
