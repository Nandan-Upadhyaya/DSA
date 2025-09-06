
import java.util.stream.IntStream;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = IntStream.of(weights).max().orElseThrow();
        int right = IntStream.of(weights).sum();

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(canShip(weights, mid, days)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static boolean canShip(int[] weights, int maxCapacity, int D) {
        int days = 1;
        int load = 0;
        for(int i = 0 ; i<weights.length ; i++) {
            if(load + weights[i] <= maxCapacity) load += weights[i];
            else {
                days++;
                load = weights[i];
            }
        }
        return days <= D;
    }
}