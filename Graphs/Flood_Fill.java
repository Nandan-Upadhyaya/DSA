
import java.util.Arrays;

class Solution {

   // Space optimized
   public int[][] floodFilloptimized(int[][] image, int sr, int sc, int color) {
        
        int startColor = image[sr][sc];
        if(startColor != color)
         dfsoptimized(sr, sc, image, startColor, color);
        return image;
    }
    
    // Space optimized
    public static void dfsoptimized(int i, int j,  int[][] image, int startColor, int color) {

            if(i >= image.length || j >= image[0].length || i < 0 || j < 0) return;

            if(image[i][j] != startColor) return;

            image[i][j] = color;

            dfsoptimized(i, j-1, image, startColor, color);
            dfsoptimized(i - 1, j, image, startColor,  color);
            dfsoptimized(i, j + 1, image, startColor, color);
            dfsoptimized(i + 1, j, image, startColor , color);

    }


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] res = new int[image.length][image[0].length];
        for(int i = 0 ; i<res.length ; i++) res[i] = Arrays.copyOf(image[i], image[i].length);
        int startColor = image[sr][sc];
        if(startColor != color)
         dfs(sr, sc, image, startColor, color, res);
        return res;
    }

    public static void dfs(int i, int j,  int[][] image, int startColor, int color, int[][] res) {
            if(i >= image.length || j >= image[0].length || i < 0 || j < 0) return;
            if(res[i][j] == color) return;
            if(image[i][j] != startColor) return;
            res[i][j] = color;
            dfs(i, j-1, image, startColor, color, res);
            dfs(i - 1, j, image, startColor,  color, res);
            dfs(i, j + 1, image, startColor, color, res);
            dfs(i + 1, j, image, startColor , color, res);
        

    }
}