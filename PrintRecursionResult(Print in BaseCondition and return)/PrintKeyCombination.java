package org.example;

import java.util.HashMap;

public class PrintKeyCombination {
    static HashMap<Character, String> map = new HashMap<>();
    public static void main(String[] args) {
        map.put('0', ".;");
        map.put('1',"abc");
        map.put('2',"def");
        map.put('3',"ghi");
        map.put('4',"jkl");
        map.put('5',"mno");
        map.put('6',"pqrs");
        map.put('7',"tu");
        map.put('8',"vwx");
        map.put('9',"yz");

        String keyTyped = "678";
        String ans = "";
        printKeyCombination(keyTyped, ans);
    }
    public static void printKeyCombination(String s , String ans)
    {
        if(s.length() == 0)
        {
            System.out.println(ans);
            return;
        }

        char ch = s.charAt(0);
        String ros = s.substring(1);
        String values = map.get(ch);
        for(char value : values.toCharArray())
        {
            printKeyCombination(ros, ans + value);
        }
    }
}
