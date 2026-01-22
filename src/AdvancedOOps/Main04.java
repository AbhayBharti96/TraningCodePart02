package AdvancedOOps;

import java.util.Scanner;

interface Notifier{
	void send(String message);
}
abstract class BaseNotification implements Notifier{
	protected String type;
	BaseNotification(String type){
		this.type= type;
	}
	void showType() {
		System.out.println("Notification: "+type);
	}
	
}
class EmailNotification extends BaseNotification{

	EmailNotification(String type) {
		super("Email");
	}
	public void send(String message) {
		System.out.println("Sending Email: "+message);
		
	}
	
}
class SMSNotification extends BaseNotification{

	SMSNotification(String type) {
		super("SMS");
	}

	public void send(String message) {
		System.out.println("Sending Sms: "+message);
		
	}
	
}
class PushNotification extends BaseNotification{

	PushNotification(String type) {
		super("Push");
	}
	public void send(String message) {
		System.out.println("Sending Push Message: "+message);
		
	}
}



public class Main04 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	String e = s.next().toLowerCase();
	String m = s.next();
	Notifier n = null;
	switch(e) {
	case "email":
		n = new EmailNotification (e);
		break;
	case "sms":
		n = new SMSNotification (e);
		break;
	case "push":
		n = new PushNotification(e);
		break;
		default:
			System.out.println("Invalid Message Request..");
	}
	 BaseNotification bn = (BaseNotification) n; // safe downcasting
     bn.showType();
     n.send(m);
	}
	}


