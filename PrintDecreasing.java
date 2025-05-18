package org.example;

import java.util.Scanner;

public class PrintDecreasing {

    static void  printDecreasing(int n)
    {
        if(n==0)
            return;
        System.out.println(n);
        printDecreasing(n-1);

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a value :");
        int n = scn.nextInt();
        printDecreasing(n);
    }
}
