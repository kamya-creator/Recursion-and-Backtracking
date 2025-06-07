package LeetcodeBacktracking;

import java.util.ArrayList;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "abaaba";
        solve(s,new ArrayList<>());
    }
    public static void solve(String ques, ArrayList<String> asf)
    {

        if(ques.length()==0)
        {

            System.out.println(asf);
            return;
        }

        for(int i = 0;i<ques.length();i++)
        {
            String substring = ques.substring(0, i+1);
            String roq = ques.substring(i+1);
            if(isPalindrome(substring))
            {
                asf.add(substring);
                solve(roq, asf);
                asf.remove(asf.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s)
    {
        int i = 0, j = s.length() -1;
        while (i <= j)
        {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
