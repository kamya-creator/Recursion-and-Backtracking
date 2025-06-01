package RemovalInvalidParentheses;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<String> removeInvalidParentheses(String s) {

        int mini = getInvalidParCount(s);
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        solve(s, mini, res, set);
        System.out.println(res);
        return res;
    }
    public void  solve(String s, int mini, List<String> res, HashSet<String> set)
    {
        if(mini == 0)
        {
            if(isValid(s))
            {
                if(!set.contains(s))
                {
                    set.add(s);
                    res.add(s);
                }
            }
            return;
        }

        for(int i = 0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c >= 'a' && c <='z') continue;
            String left = s.substring(0, i);
            String right  = s.substring(i + 1);
            String roq = left + right;
            // System.out.println("Ques---" + roq + " " + i);
            solve(roq, mini -1, res, set);

            //System.out.println("I m backtracked " + s);
        }
    }
    public boolean isValid(String s)
    {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c >='a' && c <='z') continue;
            if(c == '(') st.push(c);
            else if(c ==')')
            {
                if(st.size() > 0 && st.peek() == '(')
                {
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
        }
        return st.size()==0;
    }
    public int getInvalidParCount(String s)
    {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c >= 'a' && c <='z') continue;
            if(c == '(') st.push(c);
            if(c == ')')
            {
                if(st.size() > 0 && st.peek() == '(')
                {
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
        }
        return st.size();
    }
}
public class Leetcode301 {

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "(a)(()()";
        s.removeInvalidParentheses(str);
    }

}
