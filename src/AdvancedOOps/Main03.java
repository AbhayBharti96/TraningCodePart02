package AdvancedOOps;

import java.util.Scanner;

interface Billable {
    double calculateBill(int units);
    void printBill(double amount); // Added to interface so Main can call it
}

abstract class UtilityService implements Billable {
    String serviceName;

    // Constructor to set the service name
    UtilityService(String name) {
        this.serviceName = name;
    }
}

class ElectricityService extends UtilityService {
    ElectricityService() {
        super("Electricity");
    }

    public double calculateBill(int units) {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return units * 8.0;
        }
    }

    public void printBill(double amount) {
        System.out.println("Service: " + serviceName);
        System.out.println("Total Bill: " + amount);
    }
}

class WaterService extends UtilityService {
    WaterService() {
        super("Water");
    }

    public double calculateBill(int units) {
        return 3.0 * units;
    }

    public void printBill(double amount) {
        System.out.println("Service: " + serviceName);
        System.out.println("Total Bill: " + amount);
    }
}

class GasService extends UtilityService {
    GasService() {
        super("Gas");
    }

    public double calculateBill(int units) {
        return 6.0 * units;
    }

    public void printBill(double amount) {
        System.out.println("Service: " + serviceName);
        System.out.println("Total Bill: " + amount);
    }
}

public class Main03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        System.out.print("Enter Service: ");
        String a = s.nextLine().toLowerCase();
//        System.out.print("Enter Units: ");
        int unit = s.nextInt();
        
        Billable b = null;

        switch (a) {
            case "electricity":
                b = new ElectricityService();
                break;
            case "water":
                b = new WaterService();
                break;
            case "gas":
                b = new GasService();
                break;
            default:
                System.out.println("Invalid Service");
        }

        if (b != null) {
            double total = b.calculateBill(unit);
            b.printBill(total); // Now works because it's in the interface
        }
        s.close();
    }
}