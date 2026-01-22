package streamsPractice;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student{
	private String name ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	
	Student(String name,int age){
		this.name= name;
		this.age = age;
	}
}
public class CustomClass {

	public static void main(String[] args) {
		List<Student>st =Arrays.asList(
				new Student("Rahul",2),
				new Student("Aman",3),
				new Student("Ankit",4),
				new Student("Rahul",5)
				);
		List<Student> result = st.stream()
		        .filter(s -> s.getName().startsWith("A"))
		        .collect(Collectors.toList());
		for (Student x : result) {
		    System.out.println(x.getName() + " " + x.getAge());
		}


	}

}
