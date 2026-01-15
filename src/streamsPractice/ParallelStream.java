package streamsPractice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/*
 * A type of stream that enables parallel processing of elements
 * Aloowing multiple thread to process parts of stream simultaneously
 * This can significantly improve performance for large datasets
 * Workload is distributed across mutliple threads
 * They are most effective for CPU-Intensive datasets where task are independent
 *They may add overhead for simple task or small datasets
 */
public class ParallelStream {
	private static long factorial(int n) {
		long r=1;
		for(int i=2;i<=n;i++) {
			r *= i;
		}
		return r;
	}

	public static void main(String[] args) {
		long st = System.currentTimeMillis();
		List<Integer> list =Stream.iterate(1,x->x+1).limit(20000).toList();
		List<Long>fl =list.stream().map(ParallelStream::factorial).toList();
		long et = System.currentTimeMillis();
		System.out.println("Time taken By Stream: "+(et-st)+" sec");
	
		
		// ParallelStream
		long st2 = System.currentTimeMillis();
	    fl = list.parallelStream().map(ParallelStream::factorial).toList();
		long et2 = System.currentTimeMillis();
		System.out.println("Time taken by Seq: "+(et2-st2)+" sec");
		
		// Commulative Sum
		List<Integer> l2 = Arrays.asList(1,2,3,4,5,6);
	AtomicInteger sum= new AtomicInteger(0);//Lambda always require use final 
		List<Integer>csum =l2.stream().map(x->sum.addAndGet(x))
		.toList();
		System.out.println("Csum is: "+(csum));
	}


}
