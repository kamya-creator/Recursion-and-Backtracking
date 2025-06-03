package PnC;

import java.util.Arrays;

public class PermutationUsingCombination {
    public static void main(String[] args) {
        int[] boxes = new int[3];
        int[] item = new int[2];
        solve(boxes, 0, 1,1,item);
    }
    public static void solve(int[] boxes, int level, int currItem, int item, int[] totalItem)
    {


        if(level >= boxes.length)
        {
            if(item > totalItem.length)
            {
                System.out.println(Arrays.toString(boxes));
            }
            return;
        }

        // no ki call
        solve(boxes, level + 1, currItem, item, totalItem);

        // yes ki call with arrangement
        for(int i = 0;i<totalItem.length;i++)
        {
            if(totalItem[i] == 0) {
                boxes[level] = i+1;
                totalItem[i] = i+1;
                solve(boxes, level +1, currItem , item + 1, totalItem);
                boxes[level] = 0;
                totalItem[i] =0;
            }
        }

    }
}
