package test.javasamples;

public class NthNumber2BitsSet {

	public static void main(String[] argv) {
		
		String str = null;
		
		int i = 1;
		
		while (i < 100) {
			str = Integer.toBinaryString(i);
			if (str.indexOf('1') != -1 ) {
				str = str.substring(str.indexOf('1')+1);
			if (str.indexOf('1') != -1 ) {
				str = str.substring(str.indexOf('1')+1);
				if (str.indexOf('1') == -1)
					System.out.println(i);
			}
				i+=1;
				
			}
		}
	}
	
}
