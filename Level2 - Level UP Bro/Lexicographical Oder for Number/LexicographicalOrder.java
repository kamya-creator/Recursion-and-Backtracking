package classicProblms;

import java.util.ArrayList;

public class LexicographicalOrder {
    public static void main(String[] args) {
        int n = 500;
        ArrayList<Integer> list = new ArrayList<>();
        // koi bhi number 1 - 9 se hi shuru hota h , to ye starting point hua
        for (int i = 1; i <= 9  ; i++) {
            solve(i, n , list);
        }
    }
    public static void solve(int currMember , int n ,ArrayList<Integer> list)
    {

        if(currMember > n)
        {
            return;
        }

        // har element ka kaam h pehle khud ko print karaye phir apne next family maember ke liye call laga de
        System.out.print(currMember + " ");

        // har member ke pass 9 immediate family member ho sakte h, for ex
        // 1 ->
        // 10  11 12  13 14 15 16 17 18 19
        // ab 10 ke immediate family member honge
        // 100 101 102 103 104 105 106 107 108 109
        /*
                -
             1   2  3 4 5 6 7 8 9
         11 12 13 14...19
    110 111 112 113 .. 119
    1100 1101 1102 1103
         */

        for (int i = 0; i < 10 ; i++) {
            solve(currMember * 10 + i, n , list);
        }
    }

}
