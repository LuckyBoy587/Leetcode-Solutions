import java.util.PriorityQueue;

public class LargestNumber179 {
    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{3,30,34,5,9}));
    }
    static private class Solution {
        public String largestNumber(int[] nums) {
            PriorityQueue<String> pq = new PriorityQueue<>((n1, n2) -> (n2 + n1).compareTo(n1 + n2));
            for (int num : nums) {
                pq.offer(String.valueOf(num));
            }

            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                sb.append(pq.poll());
            }
            return sb.toString();
        }
    }
}
