package org.example;

import java.util.Scanner;

public class PrintIncreasing {
    static void printIncreasing(int n)
    {
        if(n == 0)
        {    return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printIncreasing(n);
    }
}
