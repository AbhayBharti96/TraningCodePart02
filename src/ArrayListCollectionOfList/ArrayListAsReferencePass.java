package ArrayListCollectionOfList;

import java.util.ArrayList;
import java.util.List;

class Student{
	List<String>Subject;
	int id;
	Student (List<String>l,int id){
		this.id= id;
		this.Subject= l;
	}
	void show_details() {
		System.out.println("Id is -> "+id);
		System.out.println("Subjects are -> "+Subject);
	}
	void search_subject(List<String>Subjects) {
		for(String s:Subjects) {
			if(s.contains("Java")) {
				System.out.println(s);
			}
		}
	}
}



public class ArrayListAsReferencePass {
	 public static void main(String[] args) {

	        List<String> sub1 = new ArrayList<>();
	        sub1.add("Math");
	        sub1.add("Java");
	        Student s1 = new Student(sub1, 101);
	        s1.show_details();
	        s1.search_subject(sub1);
}
}
