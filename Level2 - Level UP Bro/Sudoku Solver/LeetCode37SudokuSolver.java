package classicProblms;

/*
# Intuition
Tarvese row wise , give chance to every cell to get filled.
Options to fill an empty cell(i.e board[i][j] == '.') are from 1 to 9 i.e 1,2,3,....9.
If u reaches a cell that is already filled then pass control to next ,cell.
#### How to Calculate next cell??
**Case 1:** Happy case, you are at within range of current row - column i.e u have not at extreme of row, then just pass control to next immediate cell ---> nextI = i , nextJ = j + 1
**Case 2:** Edge Case --- U are at last column of current row , ab control next row ek 0th column ko pass krna h so, 
nextI = i + 1, nextJ = 0; 

### How to check for validity???
1> Row validity - Simple traverse current row and check if value is present then return false.
2> Column validity --- Simple traverse current column and check if value is present then return false.
3> SubGrid vailidity --- I have not used mathematical formula for this, I have used my obervation, dry run once u will get initution.
Hint: [0,1,2] rows have sourceRow as 0
    [3,4,5] row have sourceRow as 3
    [6,7,8] row have sourceRow as 6

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
https://leetcode.com/problems/sudoku-solver/solutions/6783679/java-solution-with-explaination-by-kamya-mhcv/
*/
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

