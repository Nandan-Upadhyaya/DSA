class Solution {
    public boolean searchMatrixbsoneveryrow(int[][] matrix, int target) {
        for(int i = 0 ; i<matrix.length ; i++) {
            if(bsonrow(matrix[i], target)) return true;
        }
        return false;
    }

     public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];
            if(midVal == target) return true;
            else if(midVal < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static boolean bsonrow(int[] row, int target) {
        int left = 0, right = row.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(row[mid] == target) return true;
            else if(row[mid] < target) left = mid + 1;
            else right = mid - 1;
         }
         return false;
    }
}