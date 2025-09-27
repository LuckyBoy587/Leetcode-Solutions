public class KthHappyString1415 {
    public static void main(String[] args) {
        System.out.println(new Solution().getHappyString(3, 9));
    }

    private static class Solution {
        String res = null;
        int k = 0;

        public String getHappyString(int n, int k) {
            this.k = k;
            find(new StringBuilder(), '$', n);
            return res != null ? res : "";
        }

        private void find(StringBuilder sb, char prev, int maxLen) {
            if (res != null) return;
            if (sb.length() == maxLen) {
                k--;
                if (k == 0) {
                    res = sb.toString();
                }
                return;
            }

            for (char next = 'a'; next <= 'c'; next++) {
                if (next != prev) {
                    find(sb.append(next), next, maxLen);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
