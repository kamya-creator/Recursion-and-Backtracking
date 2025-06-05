package Practice;

import java.util.HashSet;

public class KLengthWordOfDistictCharacter {
    public static void main(String[] args) {
        String str = "abbccddeeffgg";
        int r = 2;
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray())
        {
            if(!set.contains(c))
            {
                set.add(c);
                sb.append(c);
            }
        }
        String unique = sb.toString();
       // solve(unique,0,r,"");
        solve2(unique, 0, "", r, -1);
    }
    public static void solve2(String str, int boxLevel, String asf, int totalBoxSelection, int lastIndex)
    {

        if(boxLevel >= totalBoxSelection )
        {
            if(asf.length() == totalBoxSelection)
                System.out.println(asf );
            return;
        }

        for (int i = lastIndex + 1; i < str.length();i++)
        {
            char ch  = str.charAt(i);
           // System.out.println(ch +"------------");
            solve2(str, boxLevel + 1, asf + ch, totalBoxSelection, i);
        }
    }
    public static void solve(String unique, int index, int toalSelection, String asf)
    {
        if(index >= unique.length()) {
            if (toalSelection == asf.length()) {
                System.out.println(asf);

            }   return;
        }

        solve(unique, index+1, toalSelection, asf);
        solve(unique, index + 1, toalSelection , asf + unique.charAt(index));
    }
}
