package ArrayListCollectionOfList;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListImplementation {

	public static void main(String[] args) {
Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of List: ");
		int n  = s.nextInt();
		System.out.println("Insert the Elements: ->");
	ArrayList<Integer>list = new ArrayList<>();
	for(int i=0;i<n;i++) {
		list.add(s.nextInt());
	}
	System.out.print("List is -> ");
	for(Integer x:list)
	System.out.print(x+" ");
	}

}
