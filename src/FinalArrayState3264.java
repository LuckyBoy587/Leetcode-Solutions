import java.util.Arrays;
import java.util.PriorityQueue;

public class FinalArrayState3264 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 6};
        System.out.println(Arrays.toString(new Solution().getFinalState(arr, 5, 2)));
    }

    private static class Solution {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
                if (nums[i1] != nums[i2]) return nums[i1] - nums[i2];
                return i1 - i2;
            });
            for (int i = 0; i < nums.length; i++) {
                pq.offer(i);
            }

            while (k-- > 0 && !pq.isEmpty()) {
                int index = pq.poll();
                nums[index] *= multiplier;
                pq.offer(index);
            }

            return nums;
        }
    }
}
