package classicProblms;

public class HanumanJi {
    public static void main(String[] args) {
        int n = 4;
        String qsf = "";
        int row = 0;
        int[][] chessboard = new int[n][n];
        printNQueen(chessboard , row, qsf );
    }
    public static void printNQueen(int[][] chess , int row ,String qsf)
    {
        if(row == chess.length)
        {
            System.out.println(qsf);
            return;
        }
        for(int col = 0;col<chess[row].length;col++)
        {
            if(isSafe(chess , row ,col)) {
                chess[row][col] = 1;
                printNQueen(chess, row + 1, qsf + " " + row + "-" + col);
                chess[row][col] = 0;
            }
        }
    }
    public  static  boolean isSafe(int[][] chess, int row , int col)
    {
        for (int r  = row -1 ; r  >=0  ; r --) {
            if(chess[r][col] == 1)
            {
                return false;
            }
        }

        for (int r = row - 1 , c = col + 1; r >= 0 && c < chess.length ; r-- , c++) {
            if(chess[r][c] == 1)
            {
                return  false;
            }
        }

        for (int r  = row - 1 , c = col -1 ; r  >=0 && c >= 0 ; r-- ,c--) {
            if(chess[r][c] == 1)
            {
                return false;
            }

        }
        return true;
    }
}
