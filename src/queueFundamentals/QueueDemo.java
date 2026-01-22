package queueFundamentals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
 * A data Structure that works on FIFO
 * Enque -> It means to Add element in Queue
 * Deque -> Remove element
 */
public class QueueDemo {
public static void main(String[] args) {
	
//	LinkedList<Integer>ls = new LinkedList<>();
//	ls.addLast(1);
//	ls.addLast(2);
//	ls.addLast(3);
//	ls.addLast(4);
//	ls.offer(30);//Offer also used to add element
//	System.out.println(ls);
//	Integer i =ls.removeFirst();
//	System.out.println(ls);
//	System.out.println(ls.getFirst());
//	Queue<Integer> q = new LinkedList<>();
//	
	ArrayBlockingQueue q = new ArrayBlockingQueue(5);
	System.out.println(q.remainingCapacity());
	q.offer(10);
	q.offer(20);
	q.offer(30);
	q.offer(40);
	q.offer(50);
	q.offer(80);
	try {
		boolean added = q.offer(70, 2, TimeUnit.SECONDS);
		System.out.println(added);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // Wait up to 2 seconds

	q.offer(70);
	System.out.println(q.remainingCapacity());
	System.out.println(q);
}
}
