package AdvancedOOps;

import java.util.Scanner;

interface Payment{
	void pay(double amount);
}

class CreditCardPayemnt implements Payment{
	public void pay(double amount) {
		System.out.println("Payment Mode: CREDITCARD");
		System.out.println("Amount Paid is: "+amount);
	}
}
class UPIPayment implements Payment{
	public void pay(double amount) {
		System.out.println("Payment Mode: UPI");
		System.out.println("Amount Paid is: "+amount);
	}
}
class NetBankingPayment implements Payment{
	public void pay(double amount) {
		System.out.println("Payment Mode: NETBANKING");
		System.out.println("Amount Paid is: "+amount);
	}
}

public class Main01 {
	public static void main(String []args) {
		Scanner s = new Scanner(System.in);
		double a = s.nextDouble();
		s.nextLine();
		String b = s.nextLine().toUpperCase();
		
		Payment p=null;
		switch(b) {
		case "UPI" :
			p = new UPIPayment();
			break;
		case "CREDITCARD":
			p = new CreditCardPayemnt();
			break;
		case "NETBANKING":
			p = new NetBankingPayment();
		}
		if(p!=null) {
			p.pay(a);
		}
		s.close();
		
	}
}



