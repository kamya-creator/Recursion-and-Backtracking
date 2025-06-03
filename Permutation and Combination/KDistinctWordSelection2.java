package PnC;

import java.util.HashSet;

public class KDistinctWordSelection2 {
    public static void main(String[] args) {
        String str = "aabbbcccdddee";
        int k = 3;
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

        /*
        In this case recursion is based on bag
         */
        solve(unique, 0,"", -1, k);
    }
    public static void solve(String str, int index, String asf, int lastIndexAccess, int k)
    {
        if(asf.length() != k)
        {
            System.out.println(asf);
            return;
        }

        for (int i = lastIndexAccess + 1; i < str.length(); i++) {

            char c = str.charAt(i);
            solve(str, index + 1, asf + c, i,k);
        }
    }
}
