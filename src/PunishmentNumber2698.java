public class PunishmentNumber2698 {
    public static void main(String[] args) {
        System.out.println(new Solution().punishmentNumber(37));
    }
    private static class Solution {
        public int punishmentNumber(int n) {
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (isPunishing(String.valueOf(i * i).toCharArray(), 0, i, 0)) {
                    res += i * i;
                }
            }
            return res;
        }

        private boolean isPunishing(char[] num, int index, int target, int currSum) {
            if (index == num.length) {
                return currSum == target;
            }
            int curr = 0;
            for (int i = index; i < num.length; i++) {
                curr = curr * 10 + num[i] - '0';
                if (isPunishing(num, i + 1, target, currSum + curr)) {
                    return true;
                }
            }
            return false;
        }
    }
}
