package ArrayListCollectionOfList;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDeleteOperations {

    public static void main(String[] args) {

        // Creating first ArrayList
        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5));

        // Creating second ArrayList
        ArrayList<Integer> list2 = new ArrayList<>(
                Arrays.asList(6, 7, 8, 9, 10, 5, 6, 1, 2));

        // Printing initial lists 
        System.out.println("Original List 1 : " + list);
        System.out.println("Original List 2 : " + list2);

        // --------------------------------------------------
        // 1. addAll() → Adds all elements of list2 into list
        // --------------------------------------------------
        list.addAll(list2);
        System.out.println("\nAfter addAll(list2) : " + list);

        // --------------------------------------------------
        // 2. remove(index) → Removes element at given index
        // --------------------------------------------------
        list.remove(0);   // removes element at index 0
        System.out.println("After remove(0) [index based] : " + list);

        // --------------------------------------------------
        // 3. remove(Object) → Removes specific value
        // --------------------------------------------------
        list.remove(Integer.valueOf(5));  // removes value 5
        System.out.println("After remove(value 5) : " + list);

        // --------------------------------------------------
        // 4. retainAll() → Keeps only common elements
        // --------------------------------------------------
        list.retainAll(list2);
        System.out.println("After retainAll(list2) [Common elements] : " + list);

        // --------------------------------------------------
        // 5. removeAll() → Removes all elements present in list2
        // --------------------------------------------------
        list.removeAll(list2);
        System.out.println("After removeAll(list2) : " + list);

        // --------------------------------------------------
        // 6. clear() → Removes all elements from list
        // --------------------------------------------------
        // This will remove from 2 where numbers are not even.. 
        list2.removeIf((x->x%2!=0));
        System.out.println("Ans is: "+list2);
        list.clear();
        System.out.println("After clear() : " + list);
    }
}
