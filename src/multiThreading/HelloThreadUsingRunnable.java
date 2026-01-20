package multiThreading;

public class HelloThreadUsingRunnable implements Runnable {

	@Override
	public void run() {
		for(; ;) {
		System.out.println("Hello");
	}

}
}
/*
A new class World is created that implements Runnable.
The run method is overridden to define the code that
constitutes the new thread.
A Thread object is created by passing an instance of
MyRunnable.
start method is called on the Thread object to initiate the
new thread.
-> In both cases, the run method contains the code that will be
executed in the new thread.
*/
