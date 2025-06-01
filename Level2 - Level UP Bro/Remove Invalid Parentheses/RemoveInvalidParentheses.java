package RemovalInvalidParentheses;

import java.util.Stack;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        String s = "(a)())()";
        int count = getInvalidParenthesesCount(s);
        generateValidParentheses(s, count);
        System.out.println(count);
    }
    public static void generateValidParentheses(String s, int minimumRemovalAllowed)
    {

        if(minimumRemovalAllowed == 0)
        {
            if(isValidParentheses(s))
             System.out.println(s);
            return;
        }

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i+1);
            String roq = left + right;
            generateValidParentheses(roq, minimumRemovalAllowed - 1);
        }
    }
    public static boolean isValidParentheses(String s)
    {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c >= 'a' && c <='z') continue ;
            if(c == '(') st.push(c);
            if(c == ')')
            {
                if(!st.isEmpty() && st.peek() =='(')
                {
                    st.pop();
                }
                else {
                    st.push(c);
                }
            }
        }
        return st.isEmpty();
    }
    public static int getInvalidParenthesesCount(String s)
    {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray())
        {
            if(c >='a' && c <= 'z')
            {
                continue;
            }
            else if(c == '(')
            {
                st.push(c);
            }
            else if(c ==')')
            {
                if(!st.isEmpty() && st.peek() == '(')
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
