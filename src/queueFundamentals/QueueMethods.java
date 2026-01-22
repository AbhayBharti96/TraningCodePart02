package queueFundamentals;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMethods {

	public static void main(String[] args) {
		Queue<Integer>q = new LinkedList<>();
		System.out.println("Size: "+q.size());
		q.offer(10);
		q.offer(30);
		q.offer(50);
		q.add(60);
		System.out.println("Queue is: "+q);
		System.out.println("Top element: "+q.element());
		System.out.println("Queue after Remove element using poll");
		q.poll();
		System.out.println(q);
	}

}
