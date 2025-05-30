package PalindromicPermutation;

import java.util.HashMap;
import java.util.Map;

public class PermutationForDuplicates {
    public static void main(String[] args) {
        String str = "aabb";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0 ) + 1);
        }
        String permutationSOFar = "";

        printPermutationDuplicates(map, permutationSOFar, str);
    }
    public static void printPermutationDuplicates(HashMap<Character, Integer> map , String permutationSoFar, String origin)
    {
        if(permutationSoFar.length() == origin.length())
        {
            System.out.println(permutationSoFar);
            return;
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            char key = entry.getKey();
            int value = entry.getValue();
            if(value > 0)
            {
                map.put(key, value -1);
                printPermutationDuplicates(map, permutationSoFar + key , origin);
                map.put(key, value);
            }

        }
    }
}
