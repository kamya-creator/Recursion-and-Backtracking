package classicProblms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

class VerbalArithmetic {

        public static boolean isSolvable(String[] words, String result) {

            boolean[] visited = new boolean[26];
            StringBuilder uniqueCharacters = new StringBuilder();
            HashSet<Character> set = new HashSet<>();
            for(int i = 0;i<words.length;i++)
            {
                char ch =  words[i].charAt(0);
                set.add(ch);
            }
            set.add(result.charAt(0));
            for(int i  =0 ;i< words.length ;i++)
                uniqueCharacters.append( getAllUniqueCharacters(words[i], visited));

            uniqueCharacters.append( getAllUniqueCharacters(result, visited));
            // System.out.println(uniqueCharacters);
            String uniqueCharacterss =  uniqueCharacters.toString();
            if(uniqueCharacterss.length() > 10) return false;

            boolean[] visitedNumber = new boolean[10];
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i =0;i < uniqueCharacterss.length() ;i++)
            {
                char ch  = uniqueCharacterss.charAt(i);
                map.put(ch , -1);
            }
            return solve(uniqueCharacterss, 0,  map, visitedNumber, words, result, set);

        }
        public  static  boolean solve(String uniqueCharacters,int index, HashMap<Character, Integer> map, boolean[] visitedNumber, String[] words, String result, HashSet<Character> set)
        {

            if(index >= uniqueCharacters.length())
            {

                String[] numbersFromWords = new String[words.length];
                for(int i = 0 ; i< words.length ;i++) {
                    numbersFromWords[i] = extractNumbers(words[i], map);
                    if(numbersFromWords[i].charAt(0) == '0')
                    {
                        return false;
                    }
                }

                String numberFromResult = extractNumbers(result, map);
                if(numberFromResult == null || numberFromResult.charAt(0) == '0' ) return false;

                long SumOfNumbers = 0;
                for(int i = 0 ; i< numbersFromWords.length ;i++)
                {
                    long number = Long.parseLong(numbersFromWords[i]);
                    SumOfNumbers += number;
                    if (SumOfNumbers > Long.parseLong(numberFromResult)) return false;
                }

                if(SumOfNumbers == Long.parseLong(numberFromResult))
                    return true;

                else{
                    return false;
                }

            }


            for(int digit = 0; digit < 10; digit++)
            {
                if(visitedNumber[digit] == false)
                {
                    char key = uniqueCharacters.charAt(index);
                    if(set.contains(key) && digit == 0) continue;
                    map.put(key, digit);
                    visitedNumber[digit] = true;
                    if(solve(uniqueCharacters, index + 1 , map, visitedNumber, words, result, set)== true) return true;
                    map.put(key ,  -1);
                    visitedNumber[digit] = false;
                }
            }

            return false;
        }

        public  static String extractNumbers(String str, HashMap<Character, Integer> map)
        {
            StringBuilder number = new StringBuilder();
            for(int i =0;i<str.length();i++)
            {
                char ch = str.charAt(i);
                int value = map.get(ch);
                if (value == -1) return null;
                number.append(value);
            }
            //System.out.println("I am Number " + number );
            return number.toString();
        }

        public static StringBuilder getAllUniqueCharacters(String str, boolean[] visited)
        {
            StringBuilder result = new StringBuilder();
            for(int i = 0;i< str.length();i++)
            {
                char ch = str.charAt(i);
                if(visited[ch - 'A'] == false)
                {
                    result.append(ch);
                    visited[ch - 'A'] = true;
                }
            }
            return result;
        }


    public static void main(String[] args) {
        // {"SEND", "MORE"};
        // {"SIX","SEVEN","SEVEN"}
        // "LEET", "CODE"
        String[] words =  {"SIX","SEVEN","SEVEN"};
        //  "MONEY";
        //  "TWENTY"
        // "POINTS"
        String result = "TWENTY";
        long currentTimeMillis = System.currentTimeMillis();
        isSolvable(words, result);
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }
}
