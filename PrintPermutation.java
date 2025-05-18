package org.example;

public class PrintPermutation {
    public static void main(String[] args) {
        String s ="abcde";
        printPermutation(s,"");
    }
    public static void printPermutation(String ques , String ans)
    {
        if(ques.length() == 0)
        {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String ros = ques.substring(0,i);
            ros += ques.substring(i+1);

            printPermutation(ros, ans + ch);
          //  System.out.println(ros);
        }
    }
}
