public class DigitGame3232 {
    private static class Solution {
        public boolean canAliceWin(int[] nums) {
            int total = 0;
            for (int num : nums) {
                if (num < 10) total += num;
                else total -= num;
            }

            return total != 0;
        }
    }
}
