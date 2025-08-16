class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int left = 0, right = n-1, top = 0, bottom = n-1;
            while(left <= right && top <= bottom){

               for(int j = left ; j<= right ; j++){
                   result[top][j] = num;
                   num++;
               }
               top++;

               for(int i = top ; i<= bottom ; i++){
                result[i][right] = num;
                num++;
               }
               right--;
               
               if(top <= bottom){
               for(int j = right ; j >= left ; j--){
                result[bottom][j] = num;
                num++;
               }
               bottom--;
               }

               if(left <= right){
               for(int i = bottom ; i >= top ; i--){
                result[i][left] = num;
                num++;
               }
               left++;
               }

        }
        return result;
    }
}