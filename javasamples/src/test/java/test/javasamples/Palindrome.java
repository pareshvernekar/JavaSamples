package test.javasamples;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Palindrome {
	
	static boolean isPalindrome(String word) {
		
		Queue<Character> wordQueue = new LinkedBlockingQueue<>();
		Stack<Character> wordStack = new Stack<>();
		boolean isPalindrome = Boolean.TRUE;
		int len = word.length();
		for (int i=0;i<len;i++) {
			wordQueue.add(word.charAt(i));
			wordStack.push(word.charAt(i));
		}
		Character ch1, ch2;
		while (!wordStack.isEmpty()) {
			ch1 = wordStack.pop();
			ch2 = wordQueue.poll();
			if (ch1 != ch2) {
				isPalindrome = Boolean.FALSE;
				return isPalindrome;
			}
		}
		
		return isPalindrome;
		
	}
	
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		String word = scanner.next();
		System.out.println("Is Palindrome:"+isPalindrome(word));
		scanner.close();
	}

}
