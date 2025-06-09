package LeetcodeBacktracking;


public class WordSearch {
    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(dsf(board, i, j, 0,word))
                    return true;
            }
        }
        return false;
    }
    public static boolean dsf(char[][] board, int row , int col, int index, String word)
    {
            if(index >= word.length())
            {
                return true;

            }
            if(row < 0 || col < 0 || row >= board.length || col >= board[row].length
                    || board[row][col] != word.charAt(index) || board[row][col] == '$')
            {
                return false;
            }

            char ch = board[row][col];

            if(board[row][col] == word.charAt(index))
            {
                board[row][col] = '$';
                if(dsf(board, row - 1, col, index + 1, word)) return true;
                if(dsf(board, row + 1, col, index + 1, word)) return true;
                if(dsf(board, row, col + 1, index + 1, word )) return true;
                if(dsf(board, row, col - 1, index + 1, word)) return true;
                board[row][col] = ch;
            }
            return false;

    }
    public static void main(String[] args) {
        char[][] boards = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        boolean exist = exist(boards, word);
        System.out.println(exist);
        display(boards);

    }
    public static void display(char[][] boards)
    {
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[i].length; j++) {
                System.out.print(boards[i][j]);
            }
            System.out.println();
        }
    }
}
