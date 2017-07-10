package sample.fb.interview;

import java.util.*;

public class AddBinary {
	
	public String add(String s1, String s2) {
		if ((s1==null || s1.equals("")) && 
			(s2 == null || s2.equals(""))
			)
			return "";

		int len1=s1.length() - 1;
		int len2=s2.length() - 1;
		int sum = 0;
		int carry = 0;
		StringBuilder strBuilder = new StringBuilder();
		while (len1 != -1 || len2 != -1) {
			int sum1 = (len1!=-1?s1.charAt(len1--) -'0':0);
			int sum2 = (len2!=-1?s2.charAt(len2--) -'0':0);
			sum = (carry+sum1+sum2)%2;
			carry = (carry+sum1+sum2)/2;
			sum = 0;
			strBuilder.append(sum);
		}
	
		if (carry > 0)
			strBuilder.append(carry);
			return strBuilder.reverse().toString();
		
	}
	public static void main(String[] argv) {

		AddBinary addBinary = new AddBinary();
		String s1="11";
		String s2="1";
		System.out.println(addBinary.add(s1,s2));

	}
}