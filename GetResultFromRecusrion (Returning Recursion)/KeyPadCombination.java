package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class KeyPadCombination {

    static HashMap<Integer, String> map = new HashMap<>();

    static ArrayList<String> letterCombination(String s)
    {
        System.out.println(s);
        if(s.length() == 1)
        {
            ArrayList<String> base = new ArrayList<>();
            for (char c : map.get(s.charAt(0) - '0').toCharArray()) {
                base.add(c+"");
            }
            return  base;
        }

        char curr = s.charAt(0);
        ArrayList<String> res = letterCombination(s.substring(1));
        ArrayList<String> myres = new ArrayList<>();

        for (char c : map.get(curr-'0').toCharArray()) {

            for (String temp : res) {
                myres.add(c + temp);
            }
        }
        return myres;
    }

    public static void main(String[] args) {

        String input = "23";
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        System.out.println(letterCombination(input));


    }
}
