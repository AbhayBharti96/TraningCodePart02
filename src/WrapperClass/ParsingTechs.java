package WrapperClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParsingTechs {

	public static void main(String[] args) {

		/*
		 * ============================== 1. String → int ==============================
		 */
		String s1 = "123";
		int a = Integer.parseInt(s1);
		System.out.println("String to int: " + a);

		/*
		 * ============================== 2. String → Integer (Wrapper)
		 * ==============================
		 */
		Integer aObj = Integer.valueOf(s1);
		System.out.println("String to Integer: " + aObj);

		/*
		 * ============================== 3. String → double
		 * ==============================
		 */
		String s2 = "45.67";
		double d = Double.parseDouble(s2);
		System.out.println("String to double: " + d);

		/*
		 * ============================== 4. String → Double (Wrapper)
		 * ==============================
		 */
		Double dObj = Double.valueOf(s2);
		System.out.println("String to Double: " + dObj);

		/*
		 * ============================== 5. String → boolean
		 * ==============================
		 */
		String s3 = "true";
		boolean b = Boolean.parseBoolean(s3);
		System.out.println("String to boolean: " + b);

		/*
		 * ============================== 6. int → String ==============================
		 */
		int x = 100;
		String s4 = Integer.toString(x);
		System.out.println("int to String: " + s4);

		/*
		 * ============================== 7. double → String
		 * ==============================
		 */
		double y = 99.99;
		String s5 = Double.toString(y);
		System.out.println("double to String: " + s5);

		/*
		 * ============================== 8. String → char
		 * ==============================
		 */
		String s6 = "Java";
		char ch = s6.charAt(0);
		System.out.println("String to char: " + ch);

		/*
		 * ============================== 9. String → char array
		 * ==============================
		 */
		char[] arr = s6.toCharArray();
		System.out.println("String to char array:");
		for (char c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();

		/*
		 * ============================== 10. String → String array (split)
		 * ==============================
		 */
		String s7 = "I am learning Java";
		String[] words = s7.split(" ");
		System.out.println("String split into words:");
		for (String word : words) {
			System.out.println(word);
		}

		/*
		 * ============================== 11. String → long
		 * ==============================
		 */
		String s8 = "9876543210";
		long l = Long.parseLong(s8);
		System.out.println("String to long: " + l);

		/*
		 * ============================== 12. String → float
		 * ==============================
		 */
		String s9 = "12.5";
		float f = Float.parseFloat(s9);
		System.out.println("String to float: " + f);

		/*
		 * ============================== 13. Wrapper → primitive (Unboxing)
		 * ==============================
		 */
		Integer num = 50;
		int prim = num; // auto-unboxing
		System.out.println("Integer to int: " + prim);

		/*
		 * ============================== 14. String → Date (Parsing Date)
		 * ==============================
		 */
		String dateStr = "16-01-2026";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date date = sdf.parse(dateStr);
			System.out.println("String to Date: " + date);
		} catch (ParseException e) {
			System.out.println("Date parsing error");
		}

		/*
		 * ============================== 15. Number → String (Universal)
		 * ==============================
		 */
		String s10 = String.valueOf(500);
		System.out.println("Number to String: " + s10);
	}
}
