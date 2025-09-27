public class MinimumNumberOfOperationsToConvertTime2224 {
    public static void main(String[] args) {
        System.out.println(new Solution().convertTime("02:30", "04:35"));
    }
    private static class Solution {
        public int convertTime(String current, String correct) {
            int currTime = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3, 5));
            int correctTime = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3, 5));
            int res = 0;
            int diff = correctTime - currTime;
            res += diff / 60;
            diff %= 60;
            res += diff / 15;
            diff %= 15;
            res += diff / 5;
            diff %= 5;
            res += diff;
            return res;
        }
    }
}
