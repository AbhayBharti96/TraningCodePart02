package ArrayListCollectionOfList;

import java.util.ArrayList;
import java.util.List;

class Details {
	int id;
	String name;
	List<String> sub;

	Details(int id, String name, List<String> sub) {
		this.id = id;
		this.name = name;
		this.sub = sub;
	}

	void showDetails() {
		System.out.println("Id- > " + id + " Name -> " + name + " Subjects-> " + sub);
	}

	void checkJava() {
		if (sub.contains("Java")) {
			System.out.println("Name-> " + name);
		}
	}

	void countSubjects() {

		List<String> counted = new ArrayList<>();

		for (String s : sub) {

			if (!counted.contains(s)) {
				int count = 0;

				for (String x : sub) {
					if (x.equals(s)) {
						count++;
					}
				}

				System.out.println(s + " -> " + count);
				counted.add(s);
			}
		}
	}

}

public class StudentMarksOfSubjects {

	public static void main(String[] args) {

		List<String> sub1 = new ArrayList<>();
		sub1.add("Java");
		sub1.add("CN");
		sub1.add("Java");

		List<String> sub2 = new ArrayList<>();
		sub2.add("DSA");
		sub2.add("Java");
		sub2.add("DSA");

		List<String> sub3 = new ArrayList<>();
		sub3.add("CN");
		sub3.add("OS");
		sub3.add("Java");

		Details d1 = new Details(123, "Abhay", sub1);
		Details d2 = new Details(124, "Ankit", sub2);
		Details d3 = new Details(125, "Ravi", sub3);

		List<Details> students = new ArrayList<>();
		students.add(d1);
		students.add(d2);
		students.add(d3);

		// 🔍 Search students enrolled in Java
		System.out.println("Students enrolled in Java:");
		for (Details d : students) {
			d.checkJava();
		}

		// 📊 Count subjects for EACH student
		System.out.println("\nSubject count for each student:");
		for (Details d : students) {
			System.out.println("\n" + d.name + "'s subjects:");
			d.countSubjects();
		}
	}
}
