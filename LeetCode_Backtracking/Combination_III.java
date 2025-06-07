package LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Combination_III {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] arr = new int[k];
        boolean[] used = new boolean[10];
        solve(arr, 0, 0,k, n,used, 0, res);
        return res;
    }
    public static void solve(int[] arr, int index, int currSum, int targetIndex, int targetSum, boolean[] visited,
                      int lastIndex, List<List<Integer>> res)
    {
        if(index >= targetIndex)
        {
            if(currSum == targetSum)
            {
                List<Integer> temp = new ArrayList<>();
                for(int i =0;i<arr.length;i++)
                {
                    temp.add(arr[i]);
                }
                res.add(temp);
            }
            return;
        }
        for (int i = lastIndex + 1; i <= 9; i++) {
            //System.out.println("Krishna");
            if(visited[i] == false)
            {
                arr[index] = i;
                visited[i] = true;
                solve(arr, index + 1, currSum + arr[index], targetIndex, targetSum , visited, i,res);
                visited[i] = false;
                arr[index] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int n = 9 , k = 3;
        List<List<Integer>> combinationSum3 = combinationSum3(k, n);
        System.out.println(combinationSum3);
    }

}
