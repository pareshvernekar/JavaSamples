package sample.fb.interview;

import java.util.*;

public class Dictionary {

        Map<Character,Map<Integer,Set<String>>> dictionary = new HashMap<>();


         void addWord(String word) {

                Character ch = new Character(word.charAt(0));
                if (!dictionary.containsKey(ch)) {
                        dictionary.put(ch,new HashMap<>(100));
                }
                int len = word.length();
                Map<Integer,Set<String>> tempMap = dictionary.get(ch);
                if (tempMap.size()==0 || tempMap.get(len)==null) {
                        tempMap.put(len,new HashSet<>());
                }
                tempMap.get(len).add(word);
        }

        boolean searchWord(String word) {

                Character ch = new Character(word.charAt(0));
                Map<Integer,Set<String>> wordMap = null;
                if (Character.isLetter(word.charAt(0)) 
                    && !dictionary.containsKey(ch)) {
                        return Boolean.FALSE;
                }
                if (Character.isLetter(word.charAt(0))) {
                    wordMap=dictionary.get(ch);
                  
                    if (word.indexOf(".") == -1)  {  //full word
                        int len = word.length();
                        Set<String> wordSet = wordMap.get(len);
                        return wordSet.contains(word);
                    } else  { //reg exp
                        int pos = 0;
                        int dotCount = 0;
                        while ((pos=word.indexOf(".",pos)) != -1) {
                            pos+=1;
                            dotCount+=1;
                        }
                        System.out.println("Number of dots:"+dotCount);
                        int len = word.length();
                        Set<String> wordSet = wordMap.get(len);
                        if (wordSet==null || wordSet.isEmpty()) return Boolean.FALSE;
                        for (String str:wordSet) {
                            int i = 0, j = 0;
                            boolean found = Boolean.TRUE;
                            while (found) {
                                if (word.charAt(j++)=='.') {i++;continue;} 
                                if (word.charAt(j++) != str.charAt(i++)) found = Boolean.FALSE;
                            }
                            if (found)
                                return found;
                        }
                    } 
                } else {
                        int pos = 0;
                        int dotCount = 0;
                        System.out.println(word.indexOf(".",pos));
                        while ((pos=word.indexOf(".",pos)) != -1) {
                           // System.out.println("POS:"+pos);
                            pos+=1;
                            dotCount+=1;
                        }
                        System.out.println("Number of dots:"+dotCount);
                        int len = word.length();
                        for ( Map<Integer,Set<String>> tempMap:dictionary.values()) {
                            Set<String> wordSet = tempMap.get(len);
                            if (wordSet==null || wordSet.isEmpty()) return Boolean.FALSE;
                            for (String str:wordSet) {
                                int i = 0, j = 0;
                                boolean found = Boolean.TRUE;
                                System.out.println("word:"+word+"::STR::"+str);    
                                while (found && j < len && i < len) {
                                    if (word.charAt(j)=='.') {i++;j++;continue;} 
                                    if (word.charAt(j++) != str.charAt(i++)) found = Boolean.FALSE;
                                }
                                if (found)
                                    return found;
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