package PracticeQuestionScenarioBased;

import java.util.Scanner;

public class EchoWaveEncryption {
static void upper(String a ) {
	System.out.println("Uppercase:"+a.toUpperCase());
}
static void Freq(String a) {
	int [] fr= new int[256];
	for(int i=0;i<a.length();i++) {
		fr[a.charAt(i)]++;
	}
	for(int i=0;i<256;i++) {
		if(fr[i]>0) {
			System.out.print(Character.toUpperCase((char) i) + "(" + fr[i] + ") ");
		}
	}
}


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String a = s.next();
		System.out.println("Processing");
		upper(a);
		Freq(a);
	}

}
