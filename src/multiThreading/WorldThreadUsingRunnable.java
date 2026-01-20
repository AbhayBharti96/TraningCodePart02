package multiThreading;

public class WorldThreadUsingRunnable {

	public static void main(String[] args) {
		HelloThreadUsingRunnable r = new HelloThreadUsingRunnable();
		Thread t1 = new Thread(r);
		t1.start();
		
	for(; ;) {
		System.out.println("World");
	}
	}

}
