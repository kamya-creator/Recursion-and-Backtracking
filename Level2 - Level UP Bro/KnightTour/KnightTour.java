package classicProblms;

import java.util.Arrays;

/*
Don't forget to do leetcode 2596. Check Knight Tour Configuration
 */
public class KnightTour {
    public static void main(String[] args) {
        int n =5;
        int[][] maze = new int[n][n];
        for(int[] a : maze)
        {
            Arrays.fill(a, -1);
        }
        int move = 1;
        printKnightTour(maze,0, 0 , 0);
    }

    public static void printKnightTour(int[][] maze, int row, int col , int move)
    {
        if(row < 0 || col < 0 || row >= maze.length || col >= maze.length || maze[row][col]  != -1)
        {

            return;
        }
        else if(move == maze.length*maze.length-1 )
        {
            maze[row][col] = move;
            System.out.println("==========BASE===========");

            display(maze);

            System.out.println("==========BASE===========");
           // maze[row][col] = -1; // Uncomment this if u want to get all possible paths
            return;
        }
        maze[row][col] = move;
       // display(maze);

        int[] dr = {-2, -1, 1, 2, 2, 1, -1,2};
        int[] dy = {1,2,2,1,-1 , -2, -2,-1};
        for (int i = 0; i < 8 ; i++) {
            printKnightTour(maze, row + dr[i], col + dy[i] , move + 1);
        }
        maze[row][col] = -1;

    }
    public static void display(int[][] maze)
    {
        for (int i = 0; i < maze.length; i++) {

            for (int j = 0; j < maze[i].length; j++) {

                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Solution {

}