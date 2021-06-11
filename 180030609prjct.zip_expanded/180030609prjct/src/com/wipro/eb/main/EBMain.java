package com.wipro.eb.main;

import java.util.Scanner;

import com.wipro.eb.service.ConnectionService;

public class EBMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the prevoius month reading");
		int pre=sc.nextInt();
		System.out.println("Enter the current month reading");
		int cur=sc.nextInt();
		System.out.println("Enter the Connection type");
		String s=sc.next();
		
		System.out.println(new ConnectionService().generateBill(cur, pre, s));
		
		sc.close();

	}

}
