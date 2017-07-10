// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".
package sample.amazon.interview;

import java.util.*;

public class WordDict {

	public boolean wordbreak(String input, String[] dict) {
		Map<Character,Set<String>> dictionary = buildDictionary(dict);
		int i = 0;
		int len = input.length();
		boolean found = false;
		int startPos = 0;
		while (i < len) {
			Set<String> dataset = dictionary.get(input.charAt(i));
			if (dataset == null || dataset.isEmpty()) return Boolean.FALSE;
			while (!found && i < len) {
				i++;
				found=dataset.contains(input.substring(startPos,i));
			}
			if (found && i < len) {
				found = false;
				startPos=i;
			}
		}
		return found;
	}

	public Map<Character,Set<String>> buildDictionary(String[] dict) {
		Map<Character,Set<String>> dictionary = new HashMap<>();

		for (int i=0;i<dict.length;i++) {
			if (!dictionary.containsKey(dict[i].charAt(0))) {
				dictionary.put(dict[i].charAt(0),new HashSet());
			}
			dictionary.get(dict[i].charAt(0)).add(dict[i]);
		}
		return dictionary;
	}

	public static void main(String[] argv) {

		String[] dict = new String[] {"leet","code"};
		String input ="leetcode";
		WordDict wd = new WordDict();
		System.out.println("leetcode::"+wd.wordbreak(input,dict));
		input="latecode";
		System.out.println("latecode::"+wd.wordbreak(input,dict));
		input="wordbreak";
		System.out.println("wordbreak::"+wd.wordbreak(input,dict));
	}
}