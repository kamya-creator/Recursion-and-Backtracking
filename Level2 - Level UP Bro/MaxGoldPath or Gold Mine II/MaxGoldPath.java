package classicProblms;

class Solution1 {
    public int getMaximumGold(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    System.out.println("i and j" + i + " " + j);
                    int ans = calculateGold(i, j, grid, visited);
                    if (max < ans) {
                        max = ans;
                    }
                }
            }
        }
        return max;
    }

    public int calculateGold(int r, int c, int[][] grid, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] == true || grid[r][c] == 0) {
            return 0;
        }
        visited[r][c] = true;
        // System.out.println("-----" + r + " " + c);
        int up = calculateGold(r - 1, c, grid, visited);
        // System.out.println("Up " + " " + up);
        int down = calculateGold(r + 1, c, grid, visited);
        // System.out.println("Down "  + down);
        int left = calculateGold(r, c - 1, grid, visited);
        // System.out.println("Left " + left);
        int right = calculateGold(r, c + 1, grid, visited);
        // System.out.println("Right "+ right);

        visited[r][c] = false;
        int myScore = grid[r][c] + Math.max(up, Math.max(down, Math.max(left, right)));
        return myScore;
    }
}
public class MaxGoldPath {
    

    public static void main(String[] args) {

        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        Solution1 s = new Solution1();
        int maximumGold = s.getMaximumGold(grid);
        System.out.println(maximumGold);
    }
}
