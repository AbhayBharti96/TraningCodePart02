package streamsPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * -> Stream is an featue which helps to process collections
 * OR
 * -> Sequence of Elements which suppports various operations
 * in a functional and declarative manner
 * simplify data processing it doesnt store the data 
 * embrace functional programming
 * Enable easy parallelism
 * How to Use Stream ?
 * Source -> InterOperation -> Terminal Opeartion -> Output
 */


public class StreamDemo {

	public static void main(String[] args) {
		List<Integer>l = Arrays.asList(1,2,3,6,4,5,7);
		Stream<Integer>st = l.stream();
		//Here Source is numbers->InterOp is Filter ->TermOp is ->Count
		System.out.println("Count of Even is:"+st.filter(x ->x%2==0).count());
		//Creating Streams
		//1.From Collections
		List<Integer>l1 = Arrays.asList(1,2,3,6,4,5,7);
		l1.stream();
		//2. From Arrays
		String []arr= {"a","b","c","d"};
		Stream<String> str = Arrays.stream(arr);
		//3.Using Stream.of()
		Stream<String>s=Stream.of("a","b","c");
		//4.Infinite Stream
		Stream<Integer>one =Stream.generate(()->1).limit(10);
		List<Integer>res = one.collect(Collectors.toList());
		System.out.println("Using Infinite is: "+res);
		//It stores infinite 1 in it..to limit it we use limit(value)
		// 5.using iterate
		Stream<Integer>it = Stream.iterate(1,x->x+1).limit(10);
		List<Integer>it1 =Stream.iterate(1, x->x+1).limit(10).collect(Collectors.toList());
		System.out.println("Using iterator is:"+it1);

}
}
