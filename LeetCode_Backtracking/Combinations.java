package LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

        public static List<List<Integer>> combine(int n, int k) {
            int[] boxes = new int[k];
            List<List<Integer>> res = new ArrayList<>();

            solve(boxes, 0, 0,n, res);
            return res;
        }
        public static void solve(int[] boxes, int curr, int lastIndex, int n, List<List<Integer>> res)
        {

            if(curr >= boxes.length)
            {
                List<Integer> temp = new ArrayList<>();
                for(int i = 0;i<boxes.length;i++)
                {
                    temp.add(boxes[i]);
                }
                res.add(temp);
                return;
            }

            for(int i = lastIndex + 1;i<=n;i++)
            {
                boxes[curr] = i;
                solve(boxes, curr + 1, i, n, res);
                boxes[curr] = 0;
            }
        }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }
}
