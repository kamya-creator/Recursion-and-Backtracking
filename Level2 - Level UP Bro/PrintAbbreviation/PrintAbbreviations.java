package classicProblms;

public class PrintAbbreviations {
    public static void main(String[] args) {
        String s = "abc";
        String asf = "";
        int count = 0;
        /*
        If ‘STR’ = “abc”,
        Sorted generalized abbreviations of ‘STR’ are: [“1b1”, “1bc”, “2c”, “3”, “a1c”, “a2”, “ab1”, “abc”].
         */
        printSubSequence(s, asf, count);
    }

    public static void printSubSequence(String ques, String ans, int count)
    {
        if(ques.length() == 0)
        {
            if(count == 0)
             System.out.println(ans);
            else
                System.out.println(ans + count);
            System.out.println("---------------");
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        if(count > 0)
            printSubSequence(roq, ans + count + ch, 0 );
        else
            printSubSequence(roq, ans + ch , count);

        printSubSequence(roq, ans , count +  1);
    }
}
