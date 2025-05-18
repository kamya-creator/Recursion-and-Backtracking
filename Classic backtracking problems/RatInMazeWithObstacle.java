package org.example;

import java.util.ArrayList;

public class RatInMazeWithObstacle {

    public static ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length; // dc
        int m = maze[0].length; // dr
        ArrayList<String> ans = new ArrayList<>();
        int sr = 0, sc= 0, dc =n-1, dr = m-1;
        int[][] visited = new int[n][m];
        String psf ="";
        RatInMazeWithObstacle(sr, sc, dr, dc, ans,psf, visited, maze);
        return ans;
    }
    public static void RatInMazeWithObstacle(int sr, int sc, int dr, int dc, ArrayList<String> ans,
                                String psf, int[][] visited, int[][] maze) {

        System.out.println("Current Status " + psf);
        System.out.println("Current coordinates " + sr + " " + sc);
        if (sr == dr && sc == dc) {
            ans.add(psf);
            return;
        } else if (sr < 0 || sc < 0 || sr > dr || sc > dc || visited[sr][sc] == 1
                || maze[sr][sc] == 0) {
            return;
        }
        // top call
        visited[sr][sc] = 1;

            System.out.println("Top Call");
        RatInMazeWithObstacle(sr - 1, sc, dr, dc, ans, psf + "U", visited, maze);


        // down call

            System.out.println("Down Call");
        RatInMazeWithObstacle(sr + 1, sc, dr, dc, ans, psf + "D", visited, maze);



        // right call

            System.out.println("Right Call");
        RatInMazeWithObstacle(sr, sc + 1, dr, dc, ans, psf + "R", visited, maze);


        // left call

            System.out.println("Left Call");
        RatInMazeWithObstacle(sr, sc - 1, dr, dc, ans, psf + "L", visited, maze);

        visited[sr][sc] = 0;

    }
    public static void main(String[] args) {

       // int[][] maze = {{1,0,0,0}, {1,1,0,1},{1,1,0,0},{0,1,1,1}};
        int[][] maze = {{1,1,1,0,1},{1,0,1,1,1},{0,0,1,1,1},{1,0,0,1,1},{1,0,0,0,1}};
        ArrayList<String> ans = ratInMaze(maze);
        System.out.println(ans);
    }
}
