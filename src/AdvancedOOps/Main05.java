package AdvancedOOps;

class Phone{
	int ram ;
	int rom;
	Phone(int ram ,int rom){
		this.ram = ram;
		this.rom = rom;
	}
	public String toString() {
		return "Phone --> "+"[Ram: "+ram+" ,"+" Rom: "+rom+" ]";
	}
}
public class Main05 {

	public static void main(String[] args) {
	Phone [] p ={
		 new Phone(5,5),
		 new Phone(6,6),
		 new Phone(8,8),
		 new Phone(4,4),
		 new Phone(3,3)
		 
	};
	System.out.println("---- Phones Are ----");
	for(Phone x:p) {
		System.out.println(x);
	}
	}

}
