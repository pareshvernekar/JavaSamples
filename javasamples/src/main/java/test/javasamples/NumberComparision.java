package test.javasamples;

public class NumberComparision {

	
	public static void main(String[] argv) {
		long l = Long.MAX_VALUE;
		int i = Integer.MAX_VALUE;
		System.out.println(l);
		System.out.println(Math.pow(10,15));
		
		System.out.println(l >= Math.pow(10,15));
		System.out.println(i >= Math.pow(10,15));
	}
}
