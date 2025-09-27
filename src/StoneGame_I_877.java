public class StoneGame_I_877 {
    public static void main(String[] args) {
        int[] piles = {3, 7, 2, 3};
        System.out.println(new Solution().stoneGame(piles));
    }

    private static class Solution {
        int[][][] dp;
        public boolean stoneGame(int[] piles) {
            dp = new int[piles.length][piles.length][2];
            return check(piles, 0, piles.length - 1, 0, 0, 0);
        }

        private boolean check(int[] piles, int i, int j, int score1, int score2, int isAliceTurn) {
            if (i == j) {
                if (isAliceTurn == 0) {
                    return score1 + piles[i] > score2;
                }
                return score2 + piles[j] < score1;
            }

            if (dp[i][j][isAliceTurn] != 0) {
                return dp[i][j][isAliceTurn] == 1;
            }

            while (piles[i] == piles[j]) {
                i++;
                j--;
            }

            if (isAliceTurn == 0) {
                dp[i][j][isAliceTurn] = check(piles, i, j - 1, score1 + piles[j], score2, 1) ||
                        check(piles, i + 1, j, score1 + piles[i], score2, 1) ? 1 : 2;
            }

            dp[i][j][isAliceTurn] = check(piles, i, j - 1, score1, score2 + piles[j], 0) ||
                    check(piles, i + 1, j, score1, score2 + piles[i], 0) ? 1 : 2;
            return dp[i][j][isAliceTurn] == 1;
        }
    }
}
