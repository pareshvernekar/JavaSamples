package sample.fb.interview.solution;

import java.util.*;

public class Dictionary {


        TrieNode root = new TrieNode();

        public void addWord(String word) {

                int len = word.length();

                TrieNode node = root;
                for (int i=0;i<len;i++) {
                        if (node.children[word.charAt(i)-'a'] == null) {
                                        node.children[word.charAt(i)-'a'] = new TrieNode();
                        }
                        node = node.children[word.charAt(i)-'a'];
                }
                node.item=word;

        }

        public boolean searchWord(String word) {

                        if (word == null || word.length()==0)
                                        return Boolean.FALSE;
                        return search(word.toCharArray(),0,root);
        }

                private boolean search(char[] charArr, int start, TrieNode node) {
                        int len = charArr.length;
                        
                        if (start == charArr.length ) {
                                return !node.item.equals("");
                        }
                        
                        if (charArr[start] != '.') {
                               
                                return (node.children[charArr[start]-'a'] != null &&
                                        search(charArr,start+1,node.children[charArr[start]-'a']));
                        } else {
                                for (int i=0;i<node.children.length;i++) {

                                        if (node.children[i] != null) { 
                                              if(  search(charArr,start+1,node.children[i])) {
                                                return true;
                                              }
                                        }
                                }

                        }
                        return Boolean.FALSE;
                }

                public static void main(String[] argv) {

                        Dictionary d = new Dictionary();
                d.addWord("sad");
                d.addWord("mad");
                d.addWord("rad");
                d.addWord("tad");
                d.addWord("eyes");
  
                 System.out.println(d.searchWord("sad"));
                 System.out.println(d.searchWord("bad"));
                  System.out.println(d.searchWord("mad"));
                  System.out.println(d.searchWord("..d"));
                  System.out.println(d.searchWord("e.f"));
                }
}

class TrieNode {

                TrieNode[] children = new TrieNode[26];
                String item="";
}