package WrapperClass;

import java.util.ArrayList;
import java.util.Scanner;

public class WrapperAutoBoxing {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the int value: ");
        
        // Autoboxing
        int a = s.nextInt();
        Integer x = a;
        System.out.println("x belongs to: " + x.getClass());

        // Manual Boxing
        int b = 10;
        Integer y = Integer.valueOf(b);
        System.out.println("y belongs to: " + y.getClass());

        // Autoboxing
        int c = 30;
        Integer z = c;
        System.out.println("z belongs to: " + z.getClass());

        // Autoboxing in Collection
        ArrayList<Integer> list = new ArrayList<>();
        int lobj = 20;
        list.add(lobj);
        s.close();
       // ArrayList<int>list2 = new ArrayList<>(); This will show the error 
    // Unboxing 
        int j = y;
        System.out.println("Unboxed Value of y is:"+j);
        //We can convert by using _typeNameValue();
        int result = x.intValue();
        System.out.println("Unbox Value of x is: "+result);
        
       Integer ans = null;
       try{int r1 = ans;
       System.out.println("r1 is"+r1);
    }catch(Exception e) {
    	System.out.println("Exception is: "+e);
    	System.out.println("Shows error while concvert non-primitive to primitve:\n"+e.getMessage());
   
   
    }
}
}
