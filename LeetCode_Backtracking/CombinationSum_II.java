package LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum_II {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res1 = new ArrayList<>();
        List<Integer> asf = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates,  asf ,0, set,target, -1);
        for(List<Integer> temp : set)
        {
            res1.add(temp);
        }
        return res1;
    }
    public static void solve(int[] candidates,  List<Integer> asf ,int currSum,HashSet<List<Integer>> set, int target, int lastIndex)
    {

        if(currSum == target)
        {
            ArrayList<Integer> temp = new ArrayList<>(asf);
            set.add(temp);
            return;
        }
        if(lastIndex >= candidates.length) return;
        for(int i = lastIndex +1;i<candidates.length;i++)
        {
            if (currSum + candidates[i] > target) break;

            asf.add(candidates[i]);
            //System.out.println(asf);
            solve(candidates, asf, currSum + candidates[i], set, target, i);
            asf.remove(asf.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5}; int target=8;

        List<List<Integer>> combinationSum2 = combinationSum2(candidates, target);
        System.out.println(combinationSum2);
    }
}


