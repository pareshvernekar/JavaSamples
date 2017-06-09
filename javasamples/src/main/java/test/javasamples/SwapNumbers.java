package test.javasamples;

/*
 * Use bitwise operators to swap two numbers without using a temporary
 */
public class SwapNumbers {

	
	public static void main(String[] argv) {
		int i = 10;	//expected 6, after swap 10->	1010
		int j = 6;	//expected 10, after swap 6 ->	0110
		
		//1110		14
		i = i ^ j;	//1100
		j=i^j;	//1100  ^ 0110 -> 1010
		System.out.println(j);		
		i=i^j;	//1100 ^ 1010	-> 0110
		System.out.println(i);
		
	}
}
