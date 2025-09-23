
class Main {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,1}, {1,1,1,1}, {0,1,1,1} };
        System.out.println(rowWithMax1sbrutelinearsearch(matrix));
        System.out.println( rowwithMax1sbinarysearch(matrix));
        System.out.println(optimizedapproach(matrix));
    }
    public static int rowWithMax1sbrutelinearsearch(int[][] matrix) {
        int count = 0, maxcount = 0, index = -1;
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j< matrix[0].length ; j++) {
                if(matrix[i][j] == 1) count++;
            }
            if(count > maxcount) {
                maxcount = count;
                index = i;
            }
            count = 0;
        }
        return index;
    }
    
    public static int rowwithMax1sbinarysearch(int[][] matrix) {
        int maxcount = 0, index = -1;
        for(int i = 0 ; i< matrix.length ; i++) {
            int firstOneIndex = firstOccurrenceof1(matrix[i]);
            int count = firstOneIndex == -1 ? 0 : matrix[i].length - firstOneIndex;
            if(count > maxcount) {
                maxcount = count;
                index = i;
            }
        }
        return index;
    }
    
    public static int optimizedapproach(int[][] matrix) {
        int row = 0, col = matrix[0].length - 1, index = -1;
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == 1) {
                index = row;
                col--;
            }
            else row++;
            
        }
        return index;
    }
    
    public static int firstOccurrenceof1(int[] row) {
        int left = 0, right = row.length - 1, result = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(row[mid] == 1) {
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;
    }
}