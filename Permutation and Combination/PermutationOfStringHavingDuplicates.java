package PnC;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfStringHavingDuplicates {
    public static void main(String[] args) {
        String str = "aabb";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray())
        {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        solve(map, str,"" );
    }
    public static void solve(HashMap<Character, Integer> map , String targetString, String asf)
    {
        if(asf.length() == targetString.length())
        {
            System.out.println(asf);
            return;
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            char ch = entry.getKey();
            int value = entry.getValue();
            if(value > 0)
            {
                map.put(ch, value - 1);
                solve(map, targetString, asf + ch);
                map.put(ch, value);
            }
        }
    }
}
