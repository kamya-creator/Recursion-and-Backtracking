package LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> asf = new ArrayList<>();
        int index = 0;
        solve(candidates, index, target,asf,  res);
        return res;
    }
    public static void solve(int[] candidates, int index, int target,  List<Integer> asf , List<List<Integer>> res)
    {
        if(target == 0)
        {
            res.add(new ArrayList<>(asf));
            return;
        }
        if(index >=candidates.length) return;

        int possible = target/candidates[index];

        for(int i = 1;i<=possible;i++)
        {
            int remaining = target - candidates[index] * i;
            for(int k = 1;k<=i;k++)
            {
                asf.add(candidates[index]);
            }
            // System.out.println(asf + "----------");
            solve(candidates, index +1, remaining, asf, res);
            for(int k = 1;k<=i;k++)
            {
                asf.remove(asf.size() -1);
            }
        }

        solve(candidates, index +1, target, asf, res);
    }

    public static void main(String[] args) {

        int[] candidates = {2,3,5} ;
        int target =8;
        combinationSum(candidates, target);
    }
}
