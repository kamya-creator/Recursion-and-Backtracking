package LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_II {
        public  static List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> asf = new ArrayList<>();
            Arrays.sort(nums);
            solve(nums, 0, asf, res);
            return res;
        }
        public static void solve(int[] nums, int index, List<Integer> asf, List<List<Integer>> res)
        {

            if(index >= nums.length)
            {
                if(!res.contains(asf))
                    res.add(new ArrayList<>(asf));
                return;
            }

            solve(nums, index +1, asf, res);
            asf.add(nums[index]);
            solve(nums, index +1, asf, res);
            asf.remove(asf.size() -1);

        }

    public static void main(String[] args) {

        int[] nums = {1,2,2};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        System.out.println(subsets);
    }
}