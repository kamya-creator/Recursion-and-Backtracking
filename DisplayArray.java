package org.example;

public class DisplayArray {

    static void printArray(int[] arr, int index)
    {
        if(index == -1)
        {
            return;
        }

        System.out.println(arr[index]);
        printArray(arr, index-1);
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        printArray(arr, 4);
    }
}
