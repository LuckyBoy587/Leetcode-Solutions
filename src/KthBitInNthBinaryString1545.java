public class KthBitInNthBinaryString1545 {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthBit(3, 1));
    }
    private static class Solution {
        public char findKthBit(int n, int k) {
            StringBuilder prev = new StringBuilder("0");
            // Si = Si - 1 + "1" + invert(reverse(Si - 1))
            for (int i = 0; i < n; i++) {
                StringBuilder curr = new StringBuilder(prev);
                curr.append('1');
                invert(prev.reverse());
                curr.append(prev);
                prev = curr;
            }
            System.out.println(prev);
            return prev.charAt(k - 1);
        }

        public void invert(StringBuilder sb) {
            for (int i = 0; i < sb.length(); i++) {
                sb.setCharAt(i, (char) ('1' - sb.charAt(i) + '0'));
            }
        }
    }
}
