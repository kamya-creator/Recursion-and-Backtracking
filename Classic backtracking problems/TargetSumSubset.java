package org.example;

public class TargetSumSubset {
    public static void main(String[] args) {

        int target = 9;
        int[] arr = {3 ,34 ,4 ,12 ,5 ,2};

        int index = 0;
        String subset ="";
        int currSum = 0;
        printSubset(arr, index, subset, target, currSum);

        System.out.println(isSubsetSum(arr, target));
    }

    public static void printSubset(int[] arr, int index , String subset, int target, int currSum)
    {
        if(index == arr.length)
        {
            System.out.println(subset);

            if(target == currSum)
            {

                System.out.println("===========================================");
                System.out.println("Found Subset");
                System.out.println(subset);
                System.out.println("===========================================");
            }
            return;
        }

        printSubset(arr, index + 1, subset + " "+arr[index], target , currSum + arr[index]);
        printSubset(arr, index +1 , subset, target, currSum);
    }

    static void targetSum(int[] arr, int currIndex, int n ,
                          int target, int currSum, String subset, int[] found)
    {

        // System.out.println("Curr Subset " + subset);
        if(found[0]> 0) return;
        if(currSum > target) return;
        if(currIndex == n)
        {
            if(currSum == target)
            {
                found[0]++;
                // System.out.println("Curr Subset " + subset);
                return;
            }
        }

        if(currIndex < n)
            targetSum(arr, currIndex + 1, n, target, currSum + arr[currIndex], subset + " " + arr[currIndex], found);

        if(currIndex < n)
            targetSum(arr, currIndex + 1, n, target, currSum, subset, found);
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        int target = sum;
        int currSum = 0;
        String subset = "";
        int currIndex = 0;
        int[] found = {0};
        targetSum(arr, currIndex, n , target, currSum, subset,found);

        return found[0]>0;
    }
}
