package multiThreading;

public class WorldThread extends Thread{

	@Override
	public void run() {
		for(; ;) { //Infinite Loop
			System.out.println("World");
		}
		
	}

	
}
