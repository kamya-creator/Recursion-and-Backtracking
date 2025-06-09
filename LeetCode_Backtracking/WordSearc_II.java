package LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public  class WordSearc_II {
    public  static List<String> findWords(char[][] board, String[] words) {
        HashSet<String> res = new HashSet<>();
        for(String word : words)
        {
            char[][] copy = deepCopy(board);
            for(int i = 0;i<board.length;i++)
            {
                for(int j = 0; j<board[i].length;j++)
                {

                    //display(board);
                    if(dfs(copy, i, j,0, word))
                    {
                        res.add(word);
                        break;
                        //System.out.println(res + "" + word) ;
                    }

                }
            }
        }
        ArrayList<String> list = new ArrayList<>(res);
        return list;
    }
    public static boolean dfs(char[][] board, int r, int c , int index, String word)
    {
        if(index >= word.length()) return true;
        if(r < 0 || c < 0 || r >= board.length || c >= board[r].length || board[r][c] == '-' || board[r][c] != word.charAt(index))
        {
            return false;
        }
        char ch = board[r][c];
        if(ch == word.charAt(index))
        {
            board[r][c] = '-';
            if(dfs(board, r - 1, c, index + 1, word)) return true;
            if(dfs(board, r + 1, c, index + 1, word)) return true;
            if(dfs(board, r, c + 1, index + 1, word)) return true;
            if(dfs(board, r, c - 1, index + 1, word)) return true;
            board[r][c] = ch;
        }
        return false;
    }
    public static char[][] deepCopy(char[][] board)
    {
        char[][] newBoard = new char[board.length][board[0].length];
        for(int i = 0;i<board.length;i++)
        {
            for(int j = 0;j<board[i].length;j++)
            {
                newBoard[i][j] = board[i][j];
            }

        }
        return newBoard;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        List<String>  res = findWords(board, words);
        display(board);
        System.out.println(res);
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
