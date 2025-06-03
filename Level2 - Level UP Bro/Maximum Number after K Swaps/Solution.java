package MaximumNumberAfterKSwap;


class Solution {
    // Function to find the largest number after k swaps.
    public static String findMaximumNum(String s, int k) {

        char[] number = s.toCharArray();
        String[] max = new String[1];
        max[0] ="0";
        solve(number, k, max);
        System.out.println(max[0]);
        return max[0];
    }
    public static void solve(char[] number, int k, String[] max)
    {
        String curr = new String(number);
        if((curr.compareTo(max[0]) > 0))
            max[0] = curr;

        if(k <= 0)
        {

            return;
        }

        for(int i =0;i<number.length-1;i++)
        {
            char ith = number[i];
            for(int j = i + 1; j<number.length;j++)
            {
                char jth = number[j];

                if(jth > ith){
                    number[i] = jth;
                    number[j] = ith;
                    solve(number, k-1 , max);
                    number[i] = ith;
                    number[j] = jth;
                }

            }
        }
    }


    public static void main(String[] args) {
        findMaximumNum("42431636", 3);
    }
}
