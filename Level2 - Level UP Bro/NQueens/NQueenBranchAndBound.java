package classicProblms;

public class NQueenBranchAndBound {
    public static void main(String[] args) {
        int n = 4;
        int[][] chess = new int[n][n];

        int row = 0;
        String asf = "";
        long l = System.currentTimeMillis();
        printNQueens(chess, asf, row);
        long now = System.currentTimeMillis();
        System.out.println(now - l);
        int[] colAllowed = new int[n];
        int[] diagonalAllowed  = new int[2*n - 1];
        int[] reverseDiagonalAllowed = new int[2*n -1];
        l = System.currentTimeMillis();
        printNQueensWithBranchAndBound(chess, row, asf,colAllowed, diagonalAllowed, reverseDiagonalAllowed);
        now = System.currentTimeMillis();
        System.out.println(now - l);
    }

    public static void printNQueensWithBranchAndBound(int[][] chess, int row,String asf , int[] colAllowed, int[] diagonalAllowed,
                                                      int[] reverseDiagonalAllowed)
    {
        if(chess.length == row )
        {
            System.out.println(asf);
            return;
        }
        for(int col = 0;col< chess.length;col++)
        {
            int currCol = col;
            int d1 = row + currCol;
            int d2 = row  - currCol + chess.length - 1;

            if(colAllowed[currCol] != 1 && diagonalAllowed[d1] != 1 && reverseDiagonalAllowed[d2] != 1)
            {
                chess[row][currCol] = 1;
                colAllowed[currCol] = 1;
                diagonalAllowed[d1] = 1;
                reverseDiagonalAllowed[d2] = 1;


                // Recursive
                printNQueensWithBranchAndBound(chess, row + 1, asf + " " + row + "-" +col , colAllowed, diagonalAllowed, reverseDiagonalAllowed);
                // BackTrack
                chess[row][col] = 0;
                colAllowed[currCol] = 0;
                diagonalAllowed[d1] = 0;
                reverseDiagonalAllowed[d2] = 0;
            }
        }
    }



    public static void printNQueens(int[][] chess, String asf, int row)
    {

        if(row == chess.length)
        {
            System.out.println(asf);
            return ;
        }
        for(int col =0;col<chess[row].length;col++)
        {
            if(isSafe(chess, row, col)) {
                chess[row][col] = 1;
                printNQueens(chess, asf + " " + row + "-" + col, row + 1);
                chess[row][col] = 0;
            }
        }
    }
    public static boolean isSafe(int[][] chees, int row, int col)
    {
        // Up safe
        for(int r = row -1; r>=0 ; r--)
        {
            if(chees[r][col] == 1)
            {
                return false;
            }
        }

        // Diagonal Safe
        for(int r = row -1 , c = col +1 ; r >= 0 && c < chees.length ; r--, c++ )
        {
            if(chees[r][c] == 1)
            {
                return false;
            }
        }

        // Reverse Diagonal Safe
        for (int r = row -1 , c = col -1; r >= 0 && c >=0 ; r--, c--) {

            if(chees[r][c] == 1)
            {
                return false;
            }
        }
        return  true;
    }

}
