package org.example;

import java.util.ArrayList;

public class GetMazePathWithJump {
    public static ArrayList<String> getMazePAthWithJump(int sr, int sc, int dr, int dc , int row, int col)
    {
        if(sr == dr && sc == dc)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }


        ArrayList<String> paths = new ArrayList<>();
        int hstepsPosible = col - sc;
        for (int i = 1; i <=hstepsPosible ; i++) {
            ArrayList<String> hpaths = getMazePAthWithJump(sr,sc + i ,dr,dc,row,col);
            for(String hpath : hpaths)
            {
                paths.add("h"+i+hpath);
            }
        }
        int vstepsPossible = row - sr;
        for (int i = 1; i <= vstepsPossible ; i++) {

           ArrayList<String> vpaths = getMazePAthWithJump(sr + i, sc, dr,dc,row,col);
           for(String  vpath : vpaths)
           {
               paths.add("v"+i+vpath);
           }
        }

        return paths;


    }
    public static void main(String[] args) {

        int sr = 0, sc = 0, dr = 2, dc = 2;
        int row = 2 , col =2;
        ArrayList<String> res = getMazePAthWithJump(sr,sc, dr, dc, row, col);
        System.out.println(res);


    }
}
