package org.example;

import java.util.HashMap;

public class DecodeString {
    static HashMap<Integer, Character> map = new HashMap<>();

    public static void main(String[] args) {
        String s = "123";

        for(int i = 1;i<=26;i++)
        {
            map.put(i, (char)('a' + i - 1));
        }

        printEncoding(s , "");
    }
    public static void printEncoding(String que, String ans)
    {
        // 0 length que
        if(que.length() == 0)
        {
            System.out.println(ans);
            return;
        }
        else if(que.length()  == 1)
        {
            char ch = que.charAt(0);
            ans = ans + map.get(ch-'0');
            System.out.println(ans);
            return;
        }
        else if(que.length() >=2)
        {
            // first Character process
            char ch = que.charAt(0);
            String ros = que.substring(1);
            if(ch != '0')
            {
                char value = map.get(ch-'0');
                printEncoding(ros, ans + value);

            }

            // first 2 character process

            String first2character = que.substring(0,2);
            String rosQues = que.substring(2);

            if(Integer.parseInt(first2character) <= 26)
            {
                char valueOfFirst2Character = map.get(Integer.parseInt(first2character));
                printEncoding(rosQues, ans + valueOfFirst2Character);
            }
        }

    }
}
