package EqualSumSubset;

import java.util.ArrayList;

public class MinimumSumDifference {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1000};//{3,9,7,3};
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        int leftSum = 0, rightSUm = 0;
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        solve(nums, 0 , left ,right, leftSum, rightSUm, min);
        System.out.println(min[0]);

    }
    public static void solve(int[] nums, int index, ArrayList<Integer> left, ArrayList<Integer> right, int leftSum, int rightSum, int[] min)
    {

        if(index == nums.length)
        {
            if(leftSum > 0 && rightSum > 0)
            {
                int diff = Math.abs(leftSum - rightSum);
                min[0] = Math.min(min[0], diff);

            }
            return;
        }


            left.add(nums[index]);
            solve(nums, index + 1, left, right, leftSum + nums[index], rightSum, min);
            left.remove(left.size() - 1);



            right.add(nums[index]);
            solve(nums, index + 1, left, right, leftSum, rightSum + nums[index], min);
            right.remove(right.size()-1);


    }
}
