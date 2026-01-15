package streamsPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,5);
	Stream<Integer>st1 = Arrays.asList(1,2,3,4).stream();
	//1. Collect
	System.out.println(st1.collect(Collectors.toList()));
	//OR
	// st1.toList();
	//2 .foreach
	list.stream().forEach(x -> System.out.println(x));
	//3 reduce -> Combines elementṡ to single result
	System.out.println(list.stream().reduce((x,y)->x+y));//Shows as Single output
	//4. Count
	//5. anyMacth,allMatch.noneMatch(--Short Circuit Methods--)
	boolean b = list.stream().anyMatch(x->x%2==0);
	System.out.println(b);
	boolean ans =list.stream().allMatch(x->x%2==0);
	System.out.println(ans);
	boolean ans2 = list.stream().noneMatch(x->x%2<0);
	System.out.println(ans2);
	//6. findFirst and findAny
	System.out.println(list.stream().findFirst().get());
	System.out.println(list.stream().findAny().get());
	
	// --- Examples ---
	List<String>ex0 =Arrays.asList("Abhay","Reema","Aayush","Abhi","Vishesh");
	System.out.println(ex0.stream().filter(x->x.length()==5).toList());
	List<Integer>ex1 = Arrays.asList(1,7,3,4,9,6);
	System.out.println(ex1.stream().map(x->x*x).sorted().toList());
	List<Integer>integers = Arrays.asList(1,2,3,4);
	System.out.println("Sum is: "+integers.stream().reduce(Integer::sum).get());
	String sentence = "Hello world";
	System.out.println("Count of L is: "+ sentence.chars().filter(x->x=='l').count());
	//this will create an Stream of intgers using characters
	
	// StateFull and StateLess operations
	
	
	}

}
