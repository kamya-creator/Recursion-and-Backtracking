package classicProblms;

import java.util.HashMap;

public class CryptarithmeticProblem {
    public static void main(String[] args) {
        String s1 = "send";
        String s2 = "more";
        String s3 = "money";
        HashMap<Character, Integer> map = new HashMap<>();
        String uniqueStr = "";
        boolean[] unique = new boolean[26];
        for (int i = 0; i < s1.length(); i++) {

            char ch = s1.charAt(i);
            map.put(ch , -1);
            if(unique[ch - 'a'] == false)
            {
                uniqueStr +=ch;
                unique[ch - 'a'] = true;
            }
        }
        for (int i = 0; i < s2.length(); i++) {

            char ch = s2.charAt(i);
            map.put(ch , -1);
            if(unique[ch - 'a'] == false)
            {
                uniqueStr +=ch;
                unique[ch - 'a'] = true;
            }
        }
        for (int i = 0; i < s3.length(); i++) {

            char ch = s3.charAt(i);
            map.put(ch , -1);
            if(unique[ch - 'a'] == false)
            {
                uniqueStr +=ch;
                unique[ch - 'a'] = true;
            }
        }

        boolean[] usedNumber = new boolean[10];
        System.out.println("Unique Characters " + uniqueStr);
        System.out.println(map);

        int index  =0;
        solveforCryptarithmetic(index, map,usedNumber, uniqueStr, s1, s2, s3 );
    }
    public static void solveforCryptarithmetic(int index, HashMap<Character, Integer> map , boolean[] usedNumber, String uniqueStr, String s1,
                                               String s2, String s3)
    {

        if(index == uniqueStr.length())
        {
            int num1 = convertToNumber(s1, map);
          //  System.out.println("Number 1----- " +num1 );
            int num2 = convertToNumber(s2, map);
          //  System.out.println("Number 2-----" + num2);
            int num3 = convertToNumber(s3, map);
          //  System.out.println("Number 3---------" + num3);

            if((num1 + num2) == num3)
            {

                System.out.println("Number 1---------" + num1);
                System.out.println("Number 2---------" + num2);
                System.out.println("Number 3---------" + num3);

                for(int i = 0 ;i < 26;i++)
                {
                    char c = (char) ('a' + i);
                    if(map.containsKey(c))
                    {
                        System.out.print(c + "-" + map.get(c) + " ");
                    }
                }
                System.out.println();
            }
            return;
        }

        char curr = uniqueStr.charAt(index);
        for(int i =0; i<10; i++)
        {
            if(usedNumber[i] == false)
            {
                map.put(curr, i);
                usedNumber[i] = true;
                solveforCryptarithmetic(index+1, map, usedNumber, uniqueStr, s1, s2, s3);
                map.put(curr, -1);
                usedNumber[i] = false;
            }
        }

    }

    public static int convertToNumber(String s , HashMap<Character, Integer> map)
    {
        int number = 0;
        for(int i = 0;i<s.length();i++)
        {
            char c = s.charAt(i);
            Integer num = map.get(c);
            number = number*10 + num;
        }

        return number;
    }
}
