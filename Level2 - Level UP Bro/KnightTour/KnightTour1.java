package classicProblms;

import java.util.Arrays;
import java.util.Scanner;

public class KnightTour1 {


        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[][] mat = new int[n][n];
            solve(mat,0,0, 1);
            System.out.println("radhe");
        }
        public static void solve(int[][] mat , int row, int col, int count)
        {
            //System.out.println("Krishna-------------");
            if(row < 0 || col < 0 || row >= mat.length || col >= mat[row].length || mat[row][col] != 0)
            {
                return;
            }
            if(count == mat.length*mat.length )
            {
                mat[row][col] = count;
                System.out.println("reached ----------");
                display(mat);
                mat[row][col] = 0;
                System.exit(0);
            }
            mat[row][col] = count;
            //System.out.println(count);
            solve(mat, row - 2, col + 1, count + 1);
            solve(mat, row - 1, col + 2, count + 1);
            solve(mat, row + 1, col + 2, count + 1);
            solve(mat, row  + 2, col +1, count + 1);


            solve(mat, row - 2, col - 1, count + 1);
            solve(mat, row - 1 , col -2 , count +1);
            solve(mat, row + 1, col - 2, count + 1);
            solve(mat, row + 2, col - 1, count + 1);
            mat[row][col] = 0;
           // display(mat);

        }

        public static void display(int[][] mat)
        {
            for(int i =0;i<mat.length;i++)
            {

                System.out.print(Arrays.toString(mat[i]));
                System.out.println();
            }
        }


}
