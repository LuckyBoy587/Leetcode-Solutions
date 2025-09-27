public class PatternRepeat1566 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1, 3};
        System.out.println(new Solution().containsPattern(arr, 2, 3));
    }

    private static class Solution {
        public boolean containsPattern(int[] arr, int m, int k) {
            for (int i = 0; i < arr.length - m; i++) {
                if (check(arr, i, k, m)) return true;
            }
            return false;
        }

        private boolean check(int[] arr, int patternStart, int repeat, int length) {
            int checkStart = patternStart + length;
            while (--repeat > 0) {
                if (!patternMatches(arr, patternStart, checkStart, length)) {
                    return false;
                }
                checkStart += length;
            }
            return true;
        }

        private boolean patternMatches(int[] arr, int patternStart, int checkStart, int length) {
            while (length-- > 0) {
                if (arr[patternStart++] != arr[checkStart++]) {
                    return false;
                }
            }
            return true;
        }
    }
}
