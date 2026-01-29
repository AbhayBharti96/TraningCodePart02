package streamCollectorMethods;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectorDemo {

	public static void main(String[] args) {
		// Joining Strings
		List<String> l = Arrays.asList("Alice","Bob","John");
		String ans1 = l.stream().collect(Collectors.joining(" - "));
	System.out.println(ans1);
	 // Collection to a Specifi Collection
	ArrayDeque<String>ans2 = l.stream().collect(Collectors.toCollection(()-> new ArrayDeque()));
	System.out.println("Class is: "+ans2.getClass()+"\n"+ans2);
	// Summarizing Data (sum, avg, count, min, max)
	List<Integer> l2 = Arrays.asList(1,2,3,4,5,6);
	IntSummaryStatistics st=l2.stream().collect(Collectors.summarizingInt(x->x));
	System.out.println("--- IntStats Functions ---");
	System.out.println("Sum is: "+st.getSum());
	System.out.println("Avg is: "+st.getAverage());
	System.out.println("Max is: "+st.getMax());
	System.out.println("Min is: "+st.getMin());
	System.out.println("Count is: "+st.getCount());
	// Calculating Average
	double avg =l2.stream().collect(Collectors.summarizingInt(x->x)).getAverage();
	System.out.println("Individual Average is: " +avg); 
	Long c = l2.stream().collect(Collectors.counting());
	System.out.println("Counting using short fun-> "+c);
	// Grouping Elements
	List<String>l3 = Arrays.asList("hello","world","java","streams","collecting");
	System.out.println(l3.stream().collect(Collectors.groupingBy(x->x.length())));
	System.out.println(l3.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(","))));
	System.out.println(l3.stream().collect(Collectors.groupingBy(String::length,Collectors.counting())));
	System.out.println(l3.stream().collect(Collectors.groupingBy(String::length,TreeMap::new,Collectors.counting())));
// Partitioning Element
// Partitions elements into two groups (true and false) based on a predicate
	System.out.println(l3.stream().collect(Collectors.partitioningBy(x->x.length()<5)));
	//Mapping and Collecting
	System.out.println(l3.stream().collect(Collectors.mapping(x->x.toUpperCase(),Collectors.toList())));
	Map<String, Integer> result =
	        l3.stream()
	          .collect(Collectors.toMap(
	              x -> x.toUpperCase(),   // key
	              x -> x.length()         // value
	          ));

	System.out.println(result);
	 // Example 1: Collecting Names by Length
    List<String> l1 = Arrays.asList("Anna", "Bob", "Alexander", "Brian", "Alice");
    System.out.println(l1.stream()
    		.collect(Collectors.groupingBy(String::length)));

    // Example 2: Counting Word Occurrences
    String sentence = "hello world hello java world";
    System.out.println(Arrays.stream(sentence.split(" "))
    		.collect(Collectors.groupingBy(x -> x, Collectors.counting())));

    // Example 3: Partitioning Even and Odd Numbers
    List<Integer> l21 = Arrays.asList(1, 2, 3, 4, 5, 6);
    System.out.println(l21.stream()
    		.collect(Collectors.partitioningBy(x -> x % 2 == 0)));

    // Example 4: Summing Values in a Map
    Map<String, Integer> items = new HashMap<>();
    items.put("Apple", 10);
    items.put("Banana", 20);
    items.put("Orange", 15);
    System.out.println(items.values()
    		.stream()
    		.reduce(Integer::sum));
    System.out.println(items.values()
    		.stream()
    		.collect(Collectors.summingInt(x -> x)));

    // Example 5: Creating a Map from Stream Elements
    List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
    System.out.println(fruits.stream()
    		.collect(Collectors.toMap(x -> x.toUpperCase(), x -> x.length())));

    // Example 6:
    List<String> words2 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
    System.out.println(words2.stream()
    		.collect(Collectors.toMap(k -> k, v -> 1, (x, y) -> x + y)));;

	}

}
