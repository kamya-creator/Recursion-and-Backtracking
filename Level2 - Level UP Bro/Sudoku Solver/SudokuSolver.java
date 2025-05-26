package classicProblms;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] grid = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        solve(0,0,grid);
    }
    public static void solve(int r, int c, int[][] grid )
    {
        if(r == 9 )
        {
            display(grid);
            return;
        }
        int nextI = 0;
        int nextJ = 0;
        if(c == 8)
        {
            nextJ = 0;
            nextI = r + 1;
        }
        else{
            nextJ = c + 1;
            nextI = r;
        }
        if(c == 8)
        {
            solve(nextI, nextJ, grid);
            return;
        }
        if(grid[r][c] != 0)
        {
            solve(nextI, nextJ, grid);
        }
        else{
            for (int value = 1; value < 10; value++) {
                {
                    if(isSafe(r, c, grid, value))
                    {
                        grid[r][c] = value;
                        solve(nextI, nextJ, grid);
                        grid[r][c] = 0;
                    }
                }

            }
        }

    }

    public static boolean isSafe(int r, int c ,int[][] grid, int currValue)
    {
        for(int row = 0; row<9;row++)
        {
            if(grid[row][c] == currValue)
            {
                return false;
            }
        }

        for(int col =0;col<9;col++)
        {
            if(grid[r][col] == currValue)
            {
                return false;
            }
        }


        int sr = 0;
        int sc = 0;
        if(r == 0 || r == 1 || r == 2 )
        {
            sr = 0;
        }
        if(r == 3 || r == 4 || r == 5 )
        {
            sr = 3;
        }
        if(r == 6 || r == 7 || r == 8 )
        {
            sr = 6;
        }
        if(c == 0 || c == 1 ||  c == 2 )
        {
            sc = 0;
        }
        if(c == 3 || c == 4 ||  c == 5 )
        {
            sc = 3;
        }
        if(c == 6 || c == 7 ||  c == 8 )
        {
            sc = 6;
        }

        for (int i = sr; i < sr + 3 ; i++) {
            for (int j = sc; j < sc + 3 ; j++) {
                if(grid[i][j] == currValue)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void display(int[][] grid)
    {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length ; j++) {

                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
