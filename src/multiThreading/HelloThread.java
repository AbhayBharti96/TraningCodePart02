package multiThreading;
/*
 *MultiThreading refers to the ability to execute multiple
 *threads within a single process concurrently.
 *Eg ->Like an web browser can have separate threads for
 *rendering the page,running JS and managing user inputs.
 *This makes the browser more responsive and efficient..
 * 
 * 
 * Time Slicing
• Definition: Time slicing divides CPU time into small intervals called
time slices or quanta.
• Function: The OS scheduler allocates these time slices to different
processes and threads, ensuring each gets a fair share of CPU time.
• Purpose: This prevents any single process or thread from
monopolizing the CPU, improving responsiveness and enablin
concurrent execution.
 */
public class HelloThread {
public static void main(String[] args) {
	System.out.println("Hello world");
	System.out.println("Running Main Thread -> "
			+ Thread.currentThread().getName());
	WorldThread w = new WorldThread();
	w.start();
	for(; ;) { // Infinite Loop
		System.out.println("Hello");
	}
}
}
