package org.example;

public class PrintSubSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int index  =0;
        String subset= "";
        printSubset(arr, index, subset);
    }
    public  static void printSubset(int[] arr , int index, String subset)
    {
        if(index == arr.length)
        {
            System.out.println(subset);
            return;
        }

        printSubset(arr, index + 1, subset + " " + arr[index]);
        printSubset(arr, index+1, subset);
    }
}
