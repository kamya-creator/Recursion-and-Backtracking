package org.example;

import java.util.ArrayList;

public class GetSubSequence {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ArrayList<String> res =new ArrayList<>();
        printSubsequence(arr,0,res, "");
        printSubsequence2("abc","");
        System.out.println(res);
        res.clear();
        ArrayList<String> getAllSubsequence= getAllSubsequenceFuncForString("abc");
        System.out.println(getAllSubsequence);

        ArrayList<ArrayList<Integer>> allSubsequenceFuncForArray = getAllSubsequenceFuncForArray(arr, 0);
        System.out.println(allSubsequenceFuncForArray);
    }

    public static void printSubsequence(int[] arr, int level,  ArrayList<String> res, String currSubsequence)
    {

        if(level == arr.length)
        {
           res.add(currSubsequence);
            return ;
        }


        printSubsequence(arr, level+ 1, res, currSubsequence + " " + arr[level]);
        printSubsequence(arr, level + 1, res, currSubsequence);

    }

    public static void printSubsequence2(String ques , String ans)
    {
        if(ques.isEmpty())
        {
            System.out.println(ans);
            return;
        }
        char curr = ques.charAt(0);
        String roq = ques.substring(1);

        printSubsequence2(roq, ans + " "+ curr);
        printSubsequence2(roq, ans );

    }

    static ArrayList<String> getAllSubsequenceFuncForString(String ques){

        if(ques.isEmpty())
        {
            ArrayList<String > base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        ArrayList<String> result = getAllSubsequenceFuncForString(roq);
        ArrayList<String> myResult = new ArrayList<>();

        for (String s : result) {

            myResult.add(ch + s);
            myResult.add(s);
        }
        return myResult;

    }

    public static ArrayList<ArrayList<Integer>> getAllSubsequenceFuncForArray(int[] arr, int index)
    {
        if(index == arr.length)
        {
            ArrayList<ArrayList<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<Integer>());
            return base;
        }

        ArrayList<ArrayList<Integer>> list = getAllSubsequenceFuncForArray(arr, index + 1);
        ArrayList<ArrayList<Integer>> myresult = new ArrayList<>();
        for(ArrayList<Integer> curr: list)
        {
            // Exclude arr[index] ele from subsequence
            myresult.add(curr);


            // Include arr[index] element in subsequence
            ArrayList<Integer> temp = new ArrayList<>(curr);
            temp.add(arr[index]);
            myresult.add(temp);

        }


        return myresult;
    }
}
