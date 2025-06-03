package PnC;

import java.util.HashSet;

public class KDistinctWordSelection {
    public static void main(String[] args) {
        String str = "aabbccdde";
        HashSet<Character> set = new HashSet<>();
        String unique = new String();
        for(char c : str.toCharArray())
        {
            if(!set.contains(c))
            {
                set.add(c);
                unique+=c;
            }
        }
        solve(unique, 0,"");
    }
    public static void solve(String unique, int index, String asf)
    {

        if(index >= unique.length())
        {
            if(asf.length() == 3)
            {
                System.out.println(asf);
            }
            return;
        }

        char curr = unique.charAt(index);

        solve(unique, index + 1, asf + curr);

        solve(unique, index + 1, asf);

    }
}
