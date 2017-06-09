package test.javasamples;

public class SubStringTests {
	
	public static void main(String[] argv) {
		String s1="abcd";
		int start = 0;
		int end = s1.length();
		while (start != end){
			System.out.print(s1.substring(0, start));
			System.out.print(" "+s1.substring(start+1,end));
			System.out.println();
			start+=1;
		}
				
	}

}
