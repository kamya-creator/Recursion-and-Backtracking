package LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_II {

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> asf = new ArrayList<>();

            boolean[] visited = new boolean[nums.length];
            solve(nums, 0, asf, res, visited);
            return res;
        }

        public void solve(int[] nums, int bag, List<Integer> asf, List<List<Integer>> res, boolean[] visited) {

            if (bag == nums.length) {
                System.out.println(asf);
                List<Integer> temp = new ArrayList<>(asf);
                if (!res.contains(temp))
                    res.add(temp);
                return;
            }

            for (int i = 0; i < nums.length; i++) {

                if (visited[i] == false) {
                    visited[i] = true;
                    asf.add(nums[i]);
                    solve(nums, bag + 1, asf, res, visited);
                    asf.remove(asf.size() - 1);
                    visited[i] = false;
                }
            }
        }
}

