package PalindromicPermutation;

import java.util.HashMap;
import java.util.Map;

public class PalindromicPermuation {
    public static void main(String[] args) {
        /*
        Prerequisites 1> CheckForPermutation Shortcut
                      2> Permutation For Duplicate

          You can check both files in this package
         */

        String str = "aabbc";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0)  +1);
        }
        int oddCount = 0;
        char[] oddCharacter = new char[1];
        oddCharacter[0] = '0';
        int halfLen = 0;
        for(Map.Entry<Character, Integer> entry  : map.entrySet())
        {
            char ch = entry.getKey();
            int value = entry.getValue();

            if(value % 2 != 0)
            {
                oddCount++;
                oddCharacter[0] = ch;
            }

            map.put(ch , value/2);
            halfLen = halfLen + value/2;
        }
        if(oddCount > 1) System.out.println("No Palindromic Permutation Possible");
        else{
            String permutationSoFar = "";
            solve(map, halfLen, permutationSoFar, oddCharacter);
        }
    }
    public static void solve(HashMap<Character, Integer> map , int targetLen , String permutationSOFar, char[] oddCharacater)
    {


        if(permutationSOFar.length() == targetLen)
        {
            StringBuilder ans = new StringBuilder(permutationSOFar);
            if(oddCharacater[0] != '0')
            {
                ans.append(oddCharacater[0]);
            }
            StringBuilder reverse = new StringBuilder(permutationSOFar);
            reverse.reverse();
            ans.append(reverse);
            System.out.println(ans);
            return;
        }
        for(Map.Entry<Character, Integer> entry :  map.entrySet())
        {
            char key = entry.getKey();
            int value = entry.getValue();

            if(value > 0)
            {
                map.put(key, value -1);
                solve(map, targetLen, permutationSOFar + key, oddCharacater);
                map.put(key, value);
            }
        }
    }
}
