package sample.amazon.interview;
import java.util.*;

// Given an array of strings, group anagrams together.

// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:

// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note: All inputs will be in lower-case.

public class GroupAnagrams {
	
	public List<List<String>> modAnagram(String[] data) {

		Arrays.sort(data);
		Map<String,List<String>> anagramMap = new HashMap<>();
		int len = data.length;
		int i = 0;
		while (i < len) {
			String str = data[i];
			char[] charArr = str.toCharArray();
			Arrays.sort(charArr);
			String temp = String.valueOf(charArr);
			if (!anagramMap.containsKey(temp)) {
				List<String> result = new ArrayList<>();
				result.add(data[i]);
				anagramMap.put(temp,result);
			} else {
				anagramMap.get(temp).add(data[i]);
			}
			i++;
		}
		return new ArrayList(anagramMap.values());
	}

	private boolean isAnagram(String input1, String input2) {
		if (input1==null || input2==null || 
			"".equals(input1) || "".equals(input2)
			|| input1.length() != input2.length())
			return Boolean.FALSE;

		char[] inputChar1 = input1.toCharArray();

		char[] inputChar2 = input2.toCharArray();
		if (String.valueOf(inputChar1).equals(String.valueOf(inputChar2)))
			return Boolean.TRUE;
		else
			return Boolean.FALSE;
	}

	public static void main(String[] argv) {
		String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		GroupAnagrams ga = new GroupAnagrams();
		
		System.out.println("**********************************");
		List<List<String>> result2 = ga.modAnagram(input);
		for (List<String> result:result2) {
			for (String str:result) {
				System.out.print(str);System.out.print("\t");
			}
			System.out.println();
		}
	}
}