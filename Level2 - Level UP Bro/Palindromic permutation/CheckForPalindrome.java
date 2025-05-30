package PalindromicPermutation;

import java.util.HashMap;
import java.util.Map;

public class CheckForPalindrome {
    public static void main(String[] args) {
        // "racecar";
        String s = "malyalam";
        int oddCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0 ) + 1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            int value = entry.getValue();
            if(value % 2 != 0)
            {
                oddCount++;
            }
        }
        System.out.println(oddCount > 1 ? "No Palindrome Possible" : "Yes Palindrome Possible");
    }
}
