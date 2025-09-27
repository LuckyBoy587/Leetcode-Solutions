import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialArrayII3152 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        int[][] queries = new int[][]{{0, 1}};
        System.out.println(Arrays.toString(new Solution().isArraySpecial(nums, queries)));
    }

    private static class Solution {
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            boolean[] res = new boolean[queries.length];
            List<Integer> indexList = new ArrayList<>();
            indexList.add(-1);
            for (int i = 0; i < nums.length - 1; i++) {
                if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                    indexList.add(i);
                }
            }
            indexList.add(nums.length - 1);
            for (int i = 0; i < queries.length; i++) {
                int start = queries[i][0];
                int end = queries[i][1];

                int index = findLastSplitEnd(indexList, end);
                res[i] = indexList.get(index) < start;
            }
            return res;
        }

        private int findLastSplitEnd(List<Integer> indexList, int end) {
            int left = 0, right = indexList.size() - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (indexList.get(mid) >= end) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return left;
        }
    }
}
