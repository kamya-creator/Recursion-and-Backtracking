package WordBacktracking;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreakProblem {
    public static void main(String[] args) {
        String sentence = "microsofthiring";
        String[] dictionary = {"micro", "soft","hi","ring","hiring","microsoft"};

        ArrayList<String> allowedWords = new ArrayList<>(Arrays.asList(dictionary));
        String asf = "";
        wordBreakUsingBacktracking(sentence, allowedWords, asf);
    }
    public static void wordBreakUsingBacktracking(String ques, ArrayList<String> dictonary, String ans)
    {
        if(ques.length() == 0)
        {
            System.out.println(ans);
            return;
        }

        for(int i = 0;i<ques.length();i++)
        {
            String prefix = ques.substring(0, i + 1);
            String roq = ques.substring(i + 1);

            if(dictonary.contains(prefix)) {
//                System.out.println("Found correct prefix " + prefix);
                wordBreakUsingBacktracking(roq, dictonary, ans + " " + prefix );
            }
        }
    }

}
