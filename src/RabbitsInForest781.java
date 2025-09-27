public class RabbitsInForest781 {
    public static void main(String[] args) {
        int[] answers = {1,1,2};
        System.out.println(new Solution().numRabbits(answers));
    }
    private static class Solution {
        public int numRabbits(int[] answers) {
            int[] freq = new int[1001];
            for (int ans: answers) {
                freq[ans]++;
            }

            int res = freq[0];
            for (int i = 1; i <= 1000; i++) {
                if (freq[i] == 0) continue;
                res += (int) Math.ceil((double) freq[i] / (i + 1)) * (i + 1);
            }
            return res;
        }
    }
}
