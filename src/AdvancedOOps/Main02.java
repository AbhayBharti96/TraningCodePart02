package AdvancedOOps;

import java.util.Scanner;

abstract class Vehicle{
	abstract double calculateRent(int days);
}
class Bike extends Vehicle{
	double calculateRent(int days) {
		
		return days*200;
	}
}
class Car extends Vehicle{
	double calculateRent(int days) {
		return days*1000;
	}
}
public class Main02 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String a = s.nextLine().toLowerCase();
		int b = s.nextInt();
		Vehicle v =null;
		switch(a) {
		case "car":
			v = new Car();
			break;
		case "bike":
			v = new Bike();
			break;
			default :
				System.out.println("Invalid choice");
		}
		System.out.println("Vehicle Type: "+a);
		if(v!=null) {
			System.out.print("Total Rent: ");
			double x =v.calculateRent(b);
			System.out.println(x);
		}
	
	}

}
