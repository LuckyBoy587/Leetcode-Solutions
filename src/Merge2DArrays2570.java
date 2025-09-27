import java.util.ArrayList;
import java.util.List;

public class Merge2DArrays2570 {
    private static class Solution {
        public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
            int i = 0, j = 0;
            int m = nums1.length, n = nums2.length;
            List<int[]> resList = new ArrayList<>();

            while (i < m && j < n) {
                if (nums1[i][0] == nums2[j][0]) {
                    resList.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                    i++;
                    j++;
                } else if (nums1[i][0] < nums2[j][0]) {
                    resList.add(nums1[i++]);
                } else {
                    resList.add(nums2[j++]);
                }
            }

            while (i < m) {
                resList.add(nums1[i++]);
            }

            while (j < n) {
                resList.add(nums2[j++]);
            }

            return resList.toArray(new int[resList.size()][2]);
        }
    }
}
