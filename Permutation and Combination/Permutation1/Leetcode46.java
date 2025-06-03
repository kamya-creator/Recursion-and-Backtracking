package PnC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int[] ans  = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        solve(nums, 0, ans, res);
        return res;
    }
    public void solve(int[] nums,int index,int[] ans, List<List<Integer>> res)
    {

        if(index >= nums.length)
        {
            List<Integer> curr = new ArrayList<>();
            for(int i = 0;i<nums.length;i++)
            {
                curr.add(ans[i]);
            }
            res.add(curr);
            return;
        }

        for(int i = 0;i<ans.length;i++)
        {
            if(ans[i] == Integer.MAX_VALUE)
            {
                ans[i] = nums[index];
                solve(nums, index + 1, ans, res);
                ans[i] = Integer.MAX_VALUE;
            }
        }
    }
}
public class Leetcode46 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        System.out.println(solution.permute(nums));
    }
}
