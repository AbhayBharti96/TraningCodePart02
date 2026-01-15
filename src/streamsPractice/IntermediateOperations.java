package streamsPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Intermediate Operation convert one stream into another stream
 * They are lazy,meaning they dont execute untile a terminal operation is invoked
 */
public class IntermediateOperations {

	public static void main(String[] args) {
		//Filter
		List<String> l = Arrays.asList("Abhay", "Ram", "Shyam", "Aniket", "Aayush","Abhay");
		System.out.println("Printing 2 names StartsWith A:  "
				+ l.stream().filter(x -> x.startsWith("A")).limit(2).collect(Collectors.toList()));
		System.out.println("Count Names Start with A: " + l.stream().filter(x -> x.startsWith("A")).count());
		//Map
		Stream<String>Up =l.stream().map(x->x.toUpperCase());
		List<String>ans1 =Up.collect(Collectors.toList());
		System.out.println("Uppercase list is: "+ans1);
		Stream<String>Lo =l.stream().map(String::toLowerCase);
		List<String>ans2 = Lo.collect(Collectors.toList());
		System.out.println("Lower using Method reference: "+ans2);
		//SortedList
		Stream<String>sortedStream =l.stream().sorted();
		Stream<String>sortedStreamUsingComparator = l.stream().sorted((a,b)->a.length()-b.length());
		System.out.println(sortedStreamUsingComparator.collect(Collectors.toList()));
		//Dsitinct
		Stream<String>dis = l.stream().filter(x->x.startsWith("A")).distinct();
		System.out.println("Distinct Startswith A: "+dis.collect(Collectors.toList()));
		//Limit
		Stream<Integer>inf =Stream.iterate(1, x->x+2).limit(20);
		System.out.println("Odd between 1 to 20: "+inf.collect(Collectors.toList()));
		  // 6. skip
        System.out.println("skip output: "+Stream.iterate(1, x -> x + 1).skip(10).limit(30).count());

        // 7. peek
        // Performs an action on each element as it is consumed.
        Stream.iterate(1, x -> x + 1).skip(10).limit(50).peek(System.out::println).count();
        //8 .toArray
        Object[]arr =Stream.of(1,2,3).toArray();
        //9. min/max
        System.out.println("MAX IS: "+Stream.of(2,44,69).max(Comparator.naturalOrder()).get());
        System.out.println("Min IS: "+Stream.of(2,44,69).min(Comparator.naturalOrder()).get());
        //10 FlatMap
        //handles stream of collection(e.g list within list) so that they can be processed as single opretaion	
        //Transform and flatten elements at the same time
        List<List<String>>list = Arrays.asList(
        		Arrays.asList("apple","banana"),
        		Arrays.asList("orange","kiwi"),
        		Arrays.asList("pear","grape"));
        System.out.println(list.get(1).get(1));
        System.out.println("Created a single list in uppercase: "+
        list.stream().flatMap(x->x.stream()
        		).map(String::toUpperCase).toList());
        List<String>list2 = Arrays.asList(
        		"Hello world",
        		"Java Streams are powerful",
        		"Flatmap is useful");
        System.out.println(
                list2.stream()
                     .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                     .map(String::toUpperCase)
                     .toList()
        );

}
}
