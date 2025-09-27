public class CheckIfRangeCovered1893 {
    private static class Solution {
        public boolean isCovered(int[][] ranges, int left, int right) {
            boolean[] rangesCovered = new boolean[51];
            for (int[] range : ranges) {
                for (int i = range[0]; i <= range[1]; i++) {
                    rangesCovered[i] = true;
                }
            }

            for (int i = left; i <= right; i++) {
                if (!rangesCovered[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
