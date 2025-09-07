
import java.util.Arrays;

class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row : board) Arrays.fill(row, '.');
        return recursivehelper(board, 0, n);
    }

    public static int recursivehelper(char[][] board, int row, int n) {
        if(row == n) return 1;
        int result = 0;
        for(int col = 0 ; col < n ; col++) {
            if(isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                result += recursivehelper(board, row + 1, n);
                board[row][col] = '.';
            }
        }
        return result;
    }

    public static boolean isSafe(char[][] board, int row, int col, int n) {
        
        for(int i = 0 ; i< row ; i++)  {
            if(board[i][col] == 'Q') return false;
        }

        for(int i = row -1 , j = col - 1 ; j>= 0 && i >= 0 ; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }

        for(int i = row -1 , j = col + 1 ; j < n && i >= 0 ; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}