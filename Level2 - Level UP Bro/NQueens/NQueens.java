package classicProblms;

public class NQueens {
    public static void main(String[] args) {
        int n =4;
        int[][] chess = new int[n][n];
        String qsf = "";
        int row = 0;
        printNQueens(chess, qsf, row);

    }
    public static void printNQueens(int[][] chess, String qsf , int row)
    {
        if(row == chess.length)
        {
            System.out.println(qsf);
            return;
        }

        // level is row
        // option is column number
        for(int col=0;col<chess[row].length;col++)
        {
            if(IsItSafePlaceForQueen(chess, row, col))
            {
                chess[row][col] = 1;
                printNQueens(chess, qsf + " " + row + "-" + col +",", row+1);
                chess[row][col] = 0;
            }

        }

    }

    public static boolean IsItSafePlaceForQueen(int[][] chess, int row, int col)
    {

        /*(d-left)  (UP)     (d-right)
        //     \    |    /
        //      \   |   /
        //       \  |  /
        //        \ | /
        //         \|/

         */
        //up
        boolean upSafe = true;
        // north-east diagonal
        boolean diagonalright = true;

        // north-west diagonal
        boolean diagonalleft = true;

        for(int i = row-1;i>=0;i--)
        {
            if(chess[i][col] == 1)
            {
                upSafe = false;
                break;
            }
        }

        for (int i = row-1, j = col+1; i >= 0 && j < chess.length ; i--, j++) {

            if(chess[i][j] == 1)
            {
                diagonalright = false;
                break;
            }
        }

        for (int i = row-1, j = col-1 ; i >=0 && j>= 0 ; i--, j--) {

            if(chess[i][j] == 1)
            {
                diagonalleft = false;
                break;
            }
        }

        return  upSafe && diagonalright && diagonalleft;
    }
}
