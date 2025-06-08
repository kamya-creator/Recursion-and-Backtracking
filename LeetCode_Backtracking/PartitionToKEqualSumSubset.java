package LeetcodeBacktracking;

import java.util.Arrays;

public class PartitionToKEqualSumSubset {

        public static boolean canPartitionKSubsets(int[] nums, int k) {
            int[] sums = new int[k];
            int total = 0;
            for(int i = 0;i<nums.length;i++)
            {
                total += nums[i];
            }
            if(total%k != 0) return false;
            int target = total/k;
            Arrays.sort(nums);
            reverse(nums);
            return solve(nums, 0, sums, target);

        }
        public static boolean solve(int[] nums, int index, int[] sums, int target)
        {
            if(index >= nums.length)
            {
                for(int i = 0;i<sums.length;i++)
                {
                    if(sums[i] != target)
                    {
                        return false;
                    }
                }

                return true;
            }

            for(int i = 0;i<sums.length;i++)
            {
                if(sums[i] + nums[index] > target) continue;

                sums[i] = sums[i] + nums[index];
                if(solve(nums, index + 1, sums, target)) return true;
                sums[i] = sums[i] - nums[index];
            }
            return false;
        }
        public static void reverse(int[] arr)
        {
            int i = 0, j = arr.length-1;
            while(i <= j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++; j--;
            }
        }

    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1}; int k = 4;
        boolean kSubsets = canPartitionKSubsets(nums, k);
        System.out.println(kSubsets);
    }
}

