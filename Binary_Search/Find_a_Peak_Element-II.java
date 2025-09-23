class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int left = 0, right = cols - 1;
        while(left <= right) {
            int midCol = left + (right - left) / 2;

            int maxRow = 0;
            for(int r = 0 ; r < rows ; r++) {
                if(mat[r][midCol] > mat[maxRow][midCol]) maxRow = r;
            }

            int leftneighbor = midCol - 1 >= 0 ? mat[maxRow][midCol - 1] : Integer.MIN_VALUE;
            int rightneighbor = midCol + 1 < cols ? mat[maxRow][midCol + 1] : Integer.MIN_VALUE;

            if(mat[maxRow][midCol] >= leftneighbor && mat[maxRow][midCol] >= rightneighbor) 
              return new int [] {maxRow, midCol};
            else if(leftneighbor > mat[maxRow][midCol]) right = midCol - 1;
            else left = midCol + 1;
        }
        return new int[] {-1, -1};
    }
}