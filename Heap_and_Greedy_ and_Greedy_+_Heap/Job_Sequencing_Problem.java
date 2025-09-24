
import java.util.Arrays;

class Solution {
    public int[] JobScheduling(int[][] Jobs) {

      Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

      int maxDeadline = 0;
        for (int[] Job : Jobs) {
            maxDeadline = Math.max(maxDeadline, Job[1]);
        }

      boolean[] schedule = new boolean[maxDeadline + 1];
      
      int profit = 0, job = 0;

        for (int[] Job : Jobs) {
            for (int slot = Job[1]; slot > 0; slot--) {
                if (!schedule[slot]) {
                    schedule[slot] = true;
                    profit += Job[2];
                    job++;
                    break;
                }
            }
        }
       return new int[] {job, profit};
    }
}