import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindSubsequence2099 {
    public static void main(String[] args) {
        int[] nums = {-76, -694, 44, 197, 357, -833, -277, 358, 724, -585, -960, 214, 465, -593, -431, 625, -83, 58, -889, 31, 765, 8, -17, 476, 992, 803, 863, 242, 379, 561, 673, 526, -447};
        int k = 14;

        Solution solution = new Solution();
        int[] result = solution.maxSubsequence(nums, k);

        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static class Solution {
        public int[] maxSubsequence(int[] nums, int k) {
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
            for (int i = 0; i < nums.length; i++) {
                if (pq.size() < k) {
                    pq.offer(new Node(i, nums[i]));
                } else if (pq.peek().val < nums[i]) {
                    pq.poll();
                    pq.offer(new Node(i, nums[i]));
                }
            }

            List<Node> list = new ArrayList<>(pq);
            list.sort(Comparator.comparingInt(n -> n.index));

            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = list.get(i).val;
            }

            return res;
        }

        static class Node {
            int val;
            int index;

            public Node(int index, int val) {
                this.index = index;
                this.val = val;
            }
        }
    }
}
