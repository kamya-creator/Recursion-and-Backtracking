package org.example;

public class PrintMazePathWithJump {
    public static void main(String[] args) {
        int sr =0, sc =0, dr = 2, dc =2;
        String ans = "";
        printMazePathWithJump(sr, sc, dr, dc, ans);
    }
    public static void printMazePathWithJump(int sr, int sc, int dr, int dc, String ans)
    {

        if(sr== dr && sc == dc)
        {
            System.out.println(ans);
            return;
        }

        int hpossible = dc - sc;
        for (int i = 1; i <=hpossible ; i++) {
            printMazePathWithJump(sr, sc+i, dr, dc, ans +"h"+i);
        }

        int vpossible = dr - sr;
        for (int i = 1; i <=vpossible ; i++) {
            printMazePathWithJump(sr+i, sc, dr, dc, ans+"v"+i);
        }

        int dpossible = Math.min(dr-sr, dc-sc);
        for (int i = 1; i <=dpossible ; i++) {
            printMazePathWithJump(sr+i, sc+i, dr, dc , ans+"d"+i);
        }
    }
}
