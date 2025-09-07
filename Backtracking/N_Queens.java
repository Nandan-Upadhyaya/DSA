
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> result;
        result = new ArrayList<>();
       char[][] board = new char[n][n];
       for(char[] row : board) Arrays.fill(row, '.');
       recursivebacktracking(0, board, result, n);
       return result;
    }

    public static void recursivebacktracking(int row, char[][] board, List<List<String>> result, int n) {
        if(row == n) {
            result.add(constructBoard(board));
            return;
        }
        for(int col = 0 ; col < n ; col++) {
            if(isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                recursivebacktracking(row + 1, board, result , n);
                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(int row, int col, char[][] board, int n) {
        for(int i = 0 ; i< row ; i++) {
            if(board[i][col] == 'Q') return false;
        }

        for(int i = row - 1 , j = col - 1 ; j >= 0 && i >= 0 ; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }
        
         for(int i = row - 1 , j = col - 1 ; j >= 0 && i >= 0 ; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }

         for(int i = row - 1 , j = col + 1 ; j < n && i >= 0 ; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }
       return true;
    }

    public static List<String> constructBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for(char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }
}