package LeetcodeBacktracking;

import java.util.ArrayList;

public class BeautifulSubset {

    public static int beautifulSubsets(int[] nums, int k) {

        int[] count = new int[1];
        int index = 0;
        solve(nums, index, new ArrayList<Integer>(), k, count);
        return count[0];
    }

    public static void solve(int[] nums, int index, ArrayList<Integer> curr, int k, int[] count) {

        if (index >= nums.length) {
            if (curr.size() == 1) {
                count[0]++;
                return;
            }
            if (curr.size() >= 2) {
                boolean found = true;
                for (int i = 0; i < curr.size() - 1; i++) {
                    for (int j = i + 1; j < curr.size(); j++) {
                        int diff = Math.abs(curr.get(i) - curr.get(j));
                        if (diff == k) {
                            found = false;
                            break;
                        }
                    }
                }
                if (found) {
                    count[0]++;
                }
            }
            return;
        }

        solve(nums, index + 1, curr, k, count);

        curr.add(nums[index]);
        solve(nums, index + 1, curr, k, count);
        curr.remove(curr.size() - 1);

    }

    public static void main(String[] args) {
        int[] nums ={2,4,6}; int k = 2;
        int beautifuledSubsets = beautifulSubsets(nums, k);
        System.out.println(beautifuledSubsets);
    }
}

