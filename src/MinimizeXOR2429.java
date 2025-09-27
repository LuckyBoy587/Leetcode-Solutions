public class MinimizeXOR2429 {
    public static void main(String[] args) {
        System.out.println(new Solution().minimizeXor(25, 72));
    }
    private static class Solution {
        public int minimizeXor(int num1, int num2) {
            int requiredBits = Integer.bitCount(num2);
            int currentBits = Integer.bitCount(num1);

            if (currentBits < requiredBits) {
                int pos = findPos(num1, requiredBits - currentBits, 0);
                int mask = (1 << pos) - 1;
                num1 |= mask;
            } else if (currentBits > requiredBits) {
                int pos = findPos(num1, currentBits - requiredBits, 1);
                int mask = -(1 << pos);
                num1 &= mask;
            }

            return num1;
        }

        public int findPos(int num, int count, int val) {
            if (count == 0) return 0;
            if ((num & 1) == val) return 1 + findPos(num >> 1, count - 1, val);
            return 1 + findPos(num >> 1, count, val);
        }
    }
}
