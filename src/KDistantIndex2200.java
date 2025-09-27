import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KDistantIndex2200 {
    public static void main(String[] args) {
        System.out.println(new Solution().findKDistantIndices(new int[]{2,2,2,2,2}, 2, 2));
    }
    private static class Solution {
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            Queue<Integer> keyIndexes = new LinkedList<>();
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == key) {
                    keyIndexes.add(i);
                }
            }

            int i = 0;
            while (!keyIndexes.isEmpty() && i < nums.length) {
                int diff = keyIndexes.peek() - i;
                if (-k <= diff && diff <= k) {
                    res.add(i++);
                } else if (diff < -k) {
                    keyIndexes.poll();
                } else {
                    i++;
                }
            }
            return res;
        }
    }
}
