package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrintDecoding {

    static HashMap<Integer, Character> map = new HashMap<>();
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {

        for(int i =1;i<=26;i++)
        {
            map.put(i , (char) ('a' + i -1));
        }
        System.out.println(map);
        String[] s = {"226","103","993","103","013"};
        for (int i = 0; i < s.length; i++) {
            printEncoding(s[i], "");
            System.out.println("encoding for " + s[i]);
            System.out.println(list);
            list.clear();

        }
    }

    public static void printEncoding(String ques, String ans)
    {
        if(ques.length() == 0) {
            System.out.println(ans);
            list.add(ans);
            return;
        }

        if(ques.length() == 1)
        {
            char c = ques.charAt(0);
            String roq = ques.substring(1);
            printEncoding(roq, ans + map.get(c-'0'));
        }

        else if(ques.length() >= 2)
        {
            // 1-digit number
            char c = ques.charAt(0);
            if(c != '0')
            {
                String roq1 = ques.substring(1);
                printEncoding(roq1, ans + map.get(c-'0'));

            }

            //  2-digit number

            String twoDigits = ques.substring(0, 2);
            if(twoDigits.charAt(0) == '0') return;
            int digit = Integer.parseInt(twoDigits);
            if(digit <= 26)
            {
                char value = map.get(digit);
              //  System.out.println(value + " " + digit);
                String roqfor2digit = ques.substring(2);
                printEncoding(roqfor2digit, ans + value);

            }
        }
    }
}
