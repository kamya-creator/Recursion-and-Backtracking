package LeetcodeBacktracking;

import java.util.Stack;

public class GenerateParentheses {
    public static  int count = 0;
    public static void main(String[] args) {
        int n = 3;
        solve(0,6, "");
    }
    public static void solve(int curr, int target, String asf)
    {

        if(curr > target)
        {
            return;
        }
        if(target == curr)
        {
            if(isValid(asf))
                System.out.println(asf + count++) ;
        }

        solve(curr+1, target, asf +"(");
        solve(curr+1, target, asf +")");

    }
    public static boolean isValid(String asf)
    {
        Stack<Character> st = new Stack<>();
        for(char c : asf.toCharArray())
        {
            if(c == '(')
            {
                st.push(c);
            }
            else {
                if(st.size()>0)
                {
                    if(st.peek() == '(') st.pop();
                }
                else{
                    return false;
                }
            }
        }
        return st.size()==0;
    }
}
