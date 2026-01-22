package AdvancedOOps;

class X {
	String name;
	int id;

	X(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public boolean equals(Object o) {
		X a = (X)o;
		return this.name.equals(a.name) && this.id == a.id;
		
	}

}

public class EqualsMethod02 {

	public static void main(String[] args) {
		X obj1 = new X("Abhay", 21);
		X obj2 = obj1;
		X obj3 = new X("Abhay", 21);
		System.out.println(obj1.equals(obj2));//
		System.out.println(obj1.equals(obj3));
		System.out.println(obj1 == obj3);// here only comparing the Object references...
		System.out.println(obj1.equals(obj3));// Now it has been overridden by using datamembers...

	}
}
