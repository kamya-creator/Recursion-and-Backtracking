package PnC;

import java.util.Arrays;

public class CombinationUsingPermutation {
    public static void main(String[] args) {
        int[] item = new int[2];
        int[] boxes = new int[4];
        solve(boxes, 0, item, -1);
    }
    public static void solve(int[] boxes, int currItem, int[] item, int lastAccessedIndex)
    {
        if(currItem == item.length)
        {
            System.out.println(Arrays.toString(boxes));
            return;
        }

        for(int i = lastAccessedIndex + 1;i<boxes.length;i++)
        {
            if(boxes[i] == 0)
            {
                boxes[i] = currItem + 1;
                solve(boxes, currItem + 1,item, i);
                boxes[i] = 0;

            }
        }
    }
}
