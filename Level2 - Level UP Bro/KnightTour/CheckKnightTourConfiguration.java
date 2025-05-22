package classicProblms;

public class CheckKnightTourConfiguration {

    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;

        boolean[] res = {false};
        dsf(grid,n, 0 , 0 , 0,res);
        return res[0];
    }
    public void dsf(int[][] grid, int n, int r ,int c , int count, boolean[] res)
    {
        // last parameter hi  h important
        // it verifies that jis position m hum next move chahte h vo vha h ya nhi
        // agar nhi h to return , go for next possible direction 
        if( r<0 || c<0 || r>=n || c>=n || grid[r][c] != count  )
        {
            return ;
        }
        if(grid[r][c] == n*n - 1)
        {
            res[0] =  true;
        }

        dsf(grid, n, r - 2, c + 1, count + 1,res);
        dsf(grid, n, r - 1, c + 2, count + 1,res);
        dsf(grid, n, r - 2, c - 1, count + 1,res);
        dsf(grid, n, r - 1, c - 2, count + 1,res);
        dsf(grid, n, r + 2, c + 1, count + 1,res);
        dsf(grid, n, r + 1, c + 2, count + 1,res);
        dsf(grid, n, r + 2, c - 1, count + 1,res);
        dsf(grid, n, r + 1, c - 2, count + 1,res);

        return ;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
        CheckKnightTourConfiguration obj  = new CheckKnightTourConfiguration();
        boolean b = obj.checkValidGrid(grid);
        System.out.println(b);
    }
}
