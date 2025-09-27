import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {
    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
    }
    private static class Solution {
        public List<Integer> partitionLabels(String s) {
            int n = s.length();
            char[] letters = s.toCharArray();
            int[] rightMost = new int[26];
            for (int i = 0; i < n; i++) {
                rightMost[letters[i] - 'a'] = i;
            }

            List<Integer> res = new ArrayList<>();
            int prevEnd = -1, maxRight = 0;
            for (int i = 0; i < n; i++) {
                maxRight = Math.max(maxRight, rightMost[letters[i] - 'a']);
                if (i == maxRight) {
                    res.add(i - prevEnd);
                    prevEnd = i;
                }
            }

            return res;
        }
    }
}
