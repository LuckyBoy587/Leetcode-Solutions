import java.util.PriorityQueue;

public class FindScoreAfterMarking2593 {
    public static void main(String[] args) {
        System.out.println(new Solution().findScore(new int[]{2, 5, 6, 6, 10}));
    }

    private static class Solution {
        public long findScore(int[] nums) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
                if (nums[i1] != nums[i2]) {
                    return nums[i1] - nums[i2];
                }
                return i1 - i2;
            });
            for (int i = 0; i < nums.length; i++) {
                pq.offer(i);
            }

            boolean[] visited = new boolean[nums.length];
            long res = 0;
            while (!pq.isEmpty()) {
                int curr = pq.poll();
                if (!visited[curr]) {
                    visited[curr] = true;
                    res += nums[curr];
                    if (curr > 0) visited[curr - 1] = true;
                    if (curr + 1 < nums.length) visited[curr + 1] = true;
                }
            }

            return res;
        }
    }
}
