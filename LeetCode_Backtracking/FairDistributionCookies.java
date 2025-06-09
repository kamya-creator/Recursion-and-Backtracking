package LeetcodeBacktracking;

public class FairDistributionCookies {
    public  static int distributeCookies(int[] cookies, int k) {
        int[] sums = new int[k];
        int[] min = new int[1];
        min[0]  = Integer.MAX_VALUE;
        solve(cookies, 0, sums, min);
        return min[0];
    }
    public static void solve(int[] arr, int index, int[] sums, int[] min)
    {

        if(index >= arr.length)
        {
            int max = 0;
            for(int i = 0;i<sums.length;i++)
            {
                max = Math.max(max, sums[i]);
            }
            min[0] = Math.min(min[0], max);
            return;
        }

        for(int i = 0; i< sums.length;i++)
        {
            sums[i] = sums[i] + arr[index];
            solve(arr, index  + 1, sums,min);
            sums[i] = sums[i] - arr[index];
        }

    }

    public static void main(String[] args) {
        int[] cookies = {8,15,10,20,8};
        int k = 2;
        int distributed = distributeCookies(cookies, k);
        System.out.println(distributed);
    }
}


