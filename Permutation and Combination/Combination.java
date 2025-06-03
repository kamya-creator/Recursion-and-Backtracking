package PnC;

import java.util.Arrays;

public class Combination {
    public static void main(String[] args) {
        int[] boxes = new int[5];
        int item = 2;
        solve(boxes, 0, 0,item);
    }
    public static void solve(int[] boxes, int level, int item, int totalItem)
    {

        if(level >= boxes.length)
        {
                if(item == totalItem)
                    System.out.println(Arrays.toString(boxes));
            return;
        }

        // no ki call
        solve(boxes, level + 1, item, totalItem);
        
        // yes ki call
        boxes[level] = 1;
        solve(boxes, level + 1, item +1 , totalItem );
        boxes[level] = 0;
    }
}
