package org.example;

public class PrintMazePath {

    public static void main(String[] args) {
        int sr =0 , sc =0, dr = 2, dc = 2;
        String ans ="";
        printMazePath(sr, sc, dr, dc, ans);
    }

    public static void printMazePath(int sr, int sc, int dr, int dc, String ans)
    {
        if(sr == dr && sc == dc)
        {
            System.out.println(ans);
            return;
        }

        if(sc + 1 <= dc)
        {
            printMazePath(sr, sc+1, dr, dc, ans+"h");
        }

        if(sr+1 <= dc)
        {
            printMazePath(sr+1, sc, dr, dc, ans+"v");
        }
    }
}
