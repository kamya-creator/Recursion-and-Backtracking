package org.example;

public class GetMazePath {
    public static int getMazePath(int sr, int sc, int dr, int dc)
    {
        if(sr > dr || sc > dc) return 0;
        if(sr == dr && sc == dc) return 1;

        int way1 = getMazePath(sr,sc+1, dr, dc);
        int way2 = getMazePath(sr+1, sc , dr, dc);

        return way1 + way2;
    }
    public static void main(String[] args) {
        int m =3;
        int n =3;
        int sr = 0, sc =0;
        int dr = m-1, dc = n-1;
        int paths = getMazePath(sr, sc, dr, dc);
        System.out.println(paths);
    }

}
