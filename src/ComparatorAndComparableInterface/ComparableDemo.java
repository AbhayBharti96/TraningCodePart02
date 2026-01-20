package ComparatorAndComparableInterface;

import java.util.ArrayList;
import java.util.Collections;

class Book implements Comparable<Book>{
	int price;
	Book(){
		
	}
	Book(int price){
		this.price = price;
	}
	@Override
	public int compareTo(Book o) {
		return o.price-this.price ;// Sort in Descending
	
	}
	public String toString() {
		return "Price is ->"+price;
	}
}


public class ComparableDemo {

	public static void main(String[] args) {
	ArrayList<Book>  l = new ArrayList<>();
	l.add(new Book(500));
	l.add(new Book(200));
	l.add(new Book(600));
	l.add(new Book(400));
	Collections.sort(l);
	System.out.println(l);
	}
	}



