package classicProblms;

public class LeetCode37SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solve(0 , 0 , board);
    }
    public static boolean solve(int i, int j , char[][] board) {

       // System.out.println("I and j " + i + " " + j);
        if(i == 9) {
            dispaly(board);
            return true;
        }
        int nextI = 0;
        int nextJ = 0;
        if (j == 9) {
            nextI = i + 1;
            nextJ = 0;
            return solve(nextI, nextJ, board);
        } else {
            nextI = i;
            nextJ = j + 1;
        }
        if (board[i][j] != '.') {
            return solve(nextI, nextJ, board);
        } else {
            for(char c = '1'; c<='9';c++) {
                if(isValid(i, j, board, c)) {
                    board[i][j] = c;
                    solve(nextI,nextJ, board);
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    private static void dispaly(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean isValid(int r, int c, char[][] board, char value) {


        for (int row = 0; row < 9; row++) {
            if(board[row][c] == value)
            {
                return false;
            }
        }
        for (int col = 0; col < 9; col++) {
            if(board[r][col] == value)
            {
                return false;
            }
        }
        int sr = 0 , sc = 0;
        if(r == 0 || r == 1 || r == 2)
        {
            sr = 0;
        }
        if(r == 3 || r == 4 || r == 5)
        {
            sr = 3;
        }
        if(r == 6 || r == 7 || r == 8)
        {
            sr = 6;
        }
        if(c == 0 || c == 1 || c == 2)
        {
            sc = 0;
        }
        if(c == 3 || c == 4 || c == 5)
        {
            sc = 3;
        }
        if(c == 6 || c == 7 || c == 8)
        {
            sc = 6;
        }
        for (int i = sr; i < sr + 3 ; i++) {
            for (int j = sc; j < sc + 3 ; j++) {
                if(board[i][j] == value)
                {
                    return false;
                }
            }
        }
        return true;
    }
}

