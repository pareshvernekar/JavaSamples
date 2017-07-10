package sample.fb.interview;

import java.util.*;

public class Dictionary {

        Map<Character,List<Set<String>>> dictionary = new HashMap<>();


         void addWord(String word) {

                Character ch = new Character(word.charAt(0));
                if (!dictionary.containsKey(ch)) {
                        dictionary.put(ch,new ArrayList<>(100));
                }
                int len = word.length();
                List<Set<String>> tempList = dictionary.get(ch);
                System.out.println(tempList.size());
                if (tempList.size()==0 || tempList.get(len)==null) {
                        tempList.set(len,new HashSet<>());
                }
                tempList.get(len).add(word);

        }

        public static void main(String[] argv) {
                Dictionary d = new Dictionary();
                d.addWord("sad");
        }
}