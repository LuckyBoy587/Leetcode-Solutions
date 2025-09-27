import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumOperationToHalfSum2208 {
    public static void main(String[] args) {
        System.out.println(new Solution().halveArray(new int[]{5, 19, 8, 1}));
    }

    private static class Solution {
        public int halveArray(int[] nums) {
            double sum = 0;
            PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int num : nums) {
                sum += num;
                pq.offer((double) num);
            }

            double target = sum / 2;
            int res;
            for (res = 0; sum > target; res++) {
                double curr = pq.poll() / 2;
                System.out.println(sum + " " + target + " " + curr);
                sum -= curr;
                pq.offer(curr);
            }

            return res;
        }
    }
}
