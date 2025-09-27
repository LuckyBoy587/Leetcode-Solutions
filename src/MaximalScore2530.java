import java.util.PriorityQueue;

public class MaximalScore2530 {
    private static class Solution {
        public long maxKelements(int[] nums, int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int num : nums) {
                priorityQueue.add(num);
            }
            long res = 0;
            while (k-- > 0 && !priorityQueue.isEmpty()) {
                int curr = priorityQueue.poll();
                res += curr;
                priorityQueue.offer((curr + 2) / 3);
            }
            return res;
        }
    }
}
