package LeetcodeBacktracking;

import java.util.Arrays;

public class Matchsticks_to_Square {
    public static boolean makesquare(int[] matchsticks) {
        int total = 0;
        int n = matchsticks.length;
        for(int i = 0;i<n;i++)
        {
            total += matchsticks[i];
        }
        if(total % 4 != 0) return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int target = total/4;
        int[] sum = new int[4];
        return solve(matchsticks, 0 , target, sum);
    }
    public  static boolean solve(int[] matchsticks, int index, int target, int[] sum)
    {

        if(index >= matchsticks.length)
        {
            int global = sum[0];
            for(int i  = 1;i<4;i++)
            {
                if(sum[i] != global)
                    return false;

            }
            return true;
        }

        for(int i = 0;i<4;i++)
        {
            if(matchsticks[index] + sum[i] > target) continue;

            sum[i] = sum[i] + matchsticks[index];
            if(solve(matchsticks, index + 1, target, sum)) return true;
            sum[i] = sum[i] - matchsticks[index];
        }
        return false;
    }
    public static void reverse(int[] arr)
    {
        int n = arr.length;
        int i = 0; int j = arr.length - 1;
        while(i <= j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2};
        makesquare(arr);
    }
}