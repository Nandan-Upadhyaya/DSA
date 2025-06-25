public static int trap(int[] height){
        int leftmax = 0, rightmax = 0, l = 0, r = height.length - 1,total = 0;
        while(l < r){
            if(height[l] < height[r]){
                if(leftmax > height[l]) total += leftmax - height[l];
                else leftmax = height[l];
                l++;
            }
            else{
                if(rightmax > height[r]) total += rightmax - height[r];
                else rightmax = height[r];
                r--;
            }
        }
        return total;
    }