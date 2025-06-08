package LeetcodeBacktracking;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        int currSum = 0;
        int[] count = new int[1];
        solve(nums,0, currSum,target, count);
        System.out.println(count[0]);
    }
    public static void solve(int[] nums, int index, int currSum, int target, int[] count)
    {
        if(index >= nums.length)
        {
            if(currSum == target)
            {
                count[0]++;
            }
            return;
        }
        solve(nums, index + 1, currSum + nums[index], target, count);
        solve(nums, index + 1, currSum - nums[index], target, count);
    }
}
