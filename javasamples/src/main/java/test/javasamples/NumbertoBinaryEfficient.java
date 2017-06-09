package test.javasamples;

public class NumbertoBinaryEfficient {

	private static void printBinary(int a) {
		StringBuilder binRep = new StringBuilder();
		int remainder = a;
		while (remainder > 1) {
			binRep.append(remainder%2);
			remainder = remainder/2;
		}
		binRep.append(remainder);
		System.out.println(binRep.reverse());
	}
	
	public static void main(String[] argv) {
		int a = 33;		//	100001	
	
		printBinary(4);				
	}
	
}
