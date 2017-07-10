package sample.amazon.interview;

import java.util.*;

// Given a digit string, return all possible letter combinations 
//that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.

// 2 - abc
// 3 - def
// 4 - ghi
// 5 - jkl
// 6 - mno
// 7 - pqrs
// 8 - tuv
// 9 - wxyz

// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
public class PhoneNumberLetterCombinations {

	public LinkedList<String> comb(String digits) {
		String[] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		if (digits == null || digits.length()==0)
			return null;

		LinkedList<String> result = new LinkedList<>();
		result.add("");
		char[] charArr = digits.toCharArray();
		for (int i=0;i<charArr.length;i++) {

			if (Character.isDigit(charArr[i])) {
				int j = charArr[i]-'0';
				char[] comboChar = mapping[j].toCharArray();
				while (result.peek().length()==i) {
					String s = result.remove();
					for (int k=0;k<comboChar.length;k++) {
						result.add(s+comboChar[k]);
					}
				}
			}
		}


		return result;

	}

	public static void main(String[] argv) {
		PhoneNumberLetterCombinations p = new PhoneNumberLetterCombinations();
		LinkedList<String> result = p.comb("23");
		for (String str:result) {
			System.out.println(str);
		}

	}
}