package test.javasamples;

public class OneComplement {

	public static void main(String[] argv) {
		int a = 2; //1010 1's complement -> 0101
		
		a = ~a;				//1011
		System.out.println(a);
	}
}
