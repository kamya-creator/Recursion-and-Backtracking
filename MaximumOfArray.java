package org.example;

public class MaximumOfArray {
    static int maximum(int[] arr, int n)
    {
        if(n==0)
        {
            return arr[0];
        }
        int findMax = maximum(arr, n-1);
        int curr = arr[n];
        return Math.max(findMax, curr);
    }

    static int maximum2(int[] arr, int index)
    {
        if(index == arr.length)
        {
            return Integer.MIN_VALUE;
        }

        int maxofn_1 = maximum2(arr, index +1);
        int mymax = Math.max(maxofn_1, arr[index]);
        return mymax;
    }
    public static void main(String[] args) {
        int[] arr = {9,2,10,5, 20, -1};
        System.out.println( maximum(arr, arr.length-1));

        System.out.println(maximum2(arr, 0));
    }
}
