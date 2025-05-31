package WordBacktracking;

import java.util.HashMap;

public class WordPatternMatching {
    public static void main(String[] args) {
        String pattern = "abbc";
        String word = "redbluebluegreen";
        HashMap<Character, String> map = new HashMap<>();
        int index = 0;
        wordPatternMatching(pattern, index, word, map);
    }
    public static void wordPatternMatching(String patetrn, int index, String word, HashMap<Character, String> map)
    {


        if(index >= patetrn.length())
        {
            if(word.length() == 0)
            {
                System.out.println(map);
            }
            return;
        }
        char ch = patetrn.charAt(index);
        if(map.containsKey(ch))
        {
            String alreadyMapped = map.get(ch);
            if(word.length() >= alreadyMapped.length())
            {
                String firstCharacters = word.substring(0, alreadyMapped.length());
                if(firstCharacters.equals(alreadyMapped))
                {
                    String row = word.substring(alreadyMapped.length());
                    wordPatternMatching(patetrn , index + 1, row, map);
                }
            }
        }
        else{
            for(int i = 0; i<word.length();i++)
            {
                String prefix = word.substring(0 , i + 1);
                String restOfWord = word.substring(i + 1);
                map.put(ch, prefix);
                wordPatternMatching(patetrn , index + 1, restOfWord, map);
                map.remove(ch);
            }
        }


    }
}
