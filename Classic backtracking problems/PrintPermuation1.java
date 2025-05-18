package org.example;

public class PrintPermuation1 {
    public static void main(String[] args) {
        String s = "abc";
        printpermuation(s,"");
    }
    public static void printpermuation(String ques, String ans)
    {
        if(ques.length() == 0)
        {
            System.out.println(ans);
            return;
        }

        for(char c : ques.toCharArray())
        {
            int index = ques.indexOf(c);
            String roq = ques.substring(0, index) + ques.substring(index +1);

            printpermuation(roq,ans+c);
        }
    }
}
