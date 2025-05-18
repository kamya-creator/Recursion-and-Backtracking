package org.example;

public class PrintSubSequence {
    public static void printSubSequence(String s, String ans)
    {
        if(s.length() == 0)
        {
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        String ros = s.substring(1);

        printSubSequence(ros, ans+ch);
        printSubSequence(ros,ans);
    }
    public static void main(String[] args) {
        String s = "abc";
        printSubSequence(s,"");
    }
}
