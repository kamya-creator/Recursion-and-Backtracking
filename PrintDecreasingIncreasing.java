package org.example;

public class PrintDecreasingIncreasing {
    static void printIncreasingDecreasing(int n)
    {
        if(n == 0)
        {
            return;
        }
        System.out.println(n);
        printIncreasingDecreasing(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {

        printIncreasingDecreasing(5);
    }
}
