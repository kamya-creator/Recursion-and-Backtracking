package EqualSumSubset;

import java.util.ArrayList;

public class Krishna {

        public static boolean canPartition(int[] nums) {

            ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
            for(int i =0; i< 2; i++)
            {
                bucket.add(new ArrayList<Integer>());
            }
            int sum = 0;
            for(int i : nums)
            {
                sum = sum + i;
            }
            if(sum %2 != 0) return false;
            int targetSum = sum/2;
            int subsetSofar = 0;

             return solve(nums, 0 ,subsetSofar, targetSum, bucket);
        }
        public  static boolean solve(int[] nums, int index, int subsetSofar,int targetSum, ArrayList<ArrayList<Integer>> bucket )
        {
            if(index >= nums.length)
            {
                if(subsetSofar == 2)
                {
                    for (int i = 0; i < bucket.size(); i++) {
                        ArrayList<Integer> list = bucket.get(i);
                        int sum = 0;
                        for (int j = 0; j < list.size(); j++) {
                            sum+=list.get(j);
                        }
                        if(sum != targetSum)
                        {
                            return false;
                        }
                    }
                    System.out.println(bucket);
                    return true;
                }
                else{
                    return false;
                }

            }
            for(ArrayList<Integer> list : bucket)
            {
                if(list.isEmpty())
                {
                    list.add(nums[index]);
                    if(solve(nums, index + 1, subsetSofar + 1, targetSum, bucket)) return true;
                    list.remove(list.size() - 1);
                    break;
                }
                else{
                    list.add(nums[index]);
                   if(solve(nums, index + 1, subsetSofar, targetSum, bucket)) return true;
                   list.remove(list.size() - 1);
                 }
            }
            return false;
        }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        boolean canPartition = canPartition(nums);
        System.out.println(canPartition);
    }
}
