package PnC;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation1 {
    public static void main(String[] args) {
        int n = 4;
        int r = 2;
//        ArrayList<ArrayList<Integer>> bag = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            bag.add(new ArrayList<>());
//        }
        int[] bag = new int[n];
        solve(bag, 1, r);
    }
    public static void solve(int[] bag, int currItem, int totalItem)
    {
        if(currItem > totalItem)
        {
            System.out.println(Arrays.toString(bag));
            return;
        }

        for (int i = 0; i < bag.length; i++) {
            if(bag[i] == 0)
            {
                bag[i] = currItem;
                solve(bag, currItem + 1, totalItem);
                bag[i] = 0;
            }
        }
    }
}
