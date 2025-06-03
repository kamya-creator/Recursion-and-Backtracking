package PnC;

import java.util.Arrays;

public class PermutationUsingCombination {
    public static void main(String[] args) {
        int[] boxes = new int[3];
        int[] item = new int[2];
        solve(boxes, 0, 0,item);
    }
    public static void solve(int[] boxes, int level, int itemSelectedSoFar, int[] totalItem)
    {


        if(level >= boxes.length)
        {
            if(itemSelectedSoFar == totalItem.length)
            {
                System.out.println(Arrays.toString(boxes));
            }
            return;
        }

        // no ki call
        solve(boxes, level + 1, itemSelectedSoFar, totalItem);

        // yes ki call with arrangement
        for(int i = 0;i<totalItem.length;i++)
        {
            if(totalItem[i] == 0) {
                boxes[level] = i+1;
                totalItem[i] = i+1;
                solve(boxes, level +1 , itemSelectedSoFar + 1, totalItem);
                boxes[level] = 0;
                totalItem[i] =0;
            }
        }

    }
}
