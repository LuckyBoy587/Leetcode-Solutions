import java.util.Arrays;

public class NextGreaterElementI496 {
    private static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] map = new int[10001];
            Arrays.fill(map, -1);
            for (int i = nums2.length - 2; i >= 0; i--) {
                for (int j = i + 1; j < nums2.length; j++) {
                    if (nums2[i] < nums2[j]) {
                        map[nums2[i]] = nums2[j];
                        break;
                    }
                }
            }

            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map[nums1[i]];
            }
            return res;
        }
    }
}
