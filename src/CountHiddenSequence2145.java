public class CountHiddenSequence2145 {
    public static void main(String[] args) {
        int[] differences = {83702,-5216};
        System.out.println(new Solution().numberOfArrays(differences, -82788, 14602));
    }
    private static class Solution {
        public int numberOfArrays(int[] differences, int lower, int upper) {
            long min = 0, max = 0;
            long curr = 0;
            for (int diff : differences) {
                curr += diff;
                min = Math.min(min, curr);
                max = Math.max(max, curr);
            }
//            System.out.println("min = " + min);
//            System.out.println("max = " + max);
            long low = lower - min;
            long high = upper - max;
            return (int) Math.max(0, high - low + 1);
        }
    }
}
