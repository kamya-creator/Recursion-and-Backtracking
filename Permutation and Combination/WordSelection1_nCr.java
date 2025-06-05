package Practice;

import java.util.HashSet;

public class WordSelection1_nCr {
    public static void main(String[] args) {
        String str = "abbbbcccdeeaabbde";
        int r = 3;// choose 3 distinct characters
        String asf = "";
        String unique = "";
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if(!set.contains(ch))
            {
                set.add(ch);
                unique+=ch;
            }
        }


        solve(unique, -1,0, asf, r);

        System.out.println("Power Set Approach ----------------");
        //solve2(unique, 0,asf, r);
    }
    public static void solve2(String str, int level,String asf, int r)
    {

        /*
        5 items , 2 boxes
        Each item has 2 choices ya to asf ka part banu ya na banu
        2^5 = 2C0 + 2C1 + 2C2 + 2C3 + 2C4 + 2C5
         */
        if(level >= str.length())
        {
            if(asf.length() == r)
                System.out.println(asf);
            return;
        }

        char curr = str.charAt(level);

        solve2(str, level + 1, asf,r);
        solve2(str, level + 1, asf + curr,r);


    }
    public static void solve(String str, int lastIndex ,int level, String asf, int r)
    {
        if(level == r) {
            if (asf.length() == r) {
                System.out.println(asf);
                return;
            }
        }

        /*
        Level pe boxes ko rakha n har box m lastIndex + 1 se characters dalna shuru kiya
        Base Condition m vahi print karenge jaha box m exactly 3 characters qki 5 m se 3 characters ko choose krna tha
         */
        for (int i = lastIndex + 1; i < str.length(); i++) {

            char ch = str.charAt(i);
            solve(str, i, level+1,asf+ch, r);
        }
    }
}
