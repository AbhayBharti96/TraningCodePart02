package streamsPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluation {

	public static void main(String[] args) {
	List<String> names  = Arrays.asList("Alice","Bob","Charlie","David");
	Stream<String> stream = names.stream()
			.filter(name->{
				System.out.println("Filtering: "+name);
				return name.length()>3;
			});
	//Until or unless we run the terminal operation the filtering will not be done
	System.out.println("Before terminal operation");
	List<String>result = stream.collect(Collectors.toList());
	System.out.println("After Terminal operation");
	System.out.println(result);
	}

}
