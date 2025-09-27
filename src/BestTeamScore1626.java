import java.util.Arrays;

public class BestTeamScore1626 {
    public static void main(String[] args) {
        int[] scores = {4, 5, 6, 5};
        int[] ages = {2, 1, 2, 2};
        System.out.println(new Solution().bestTeamScore(scores, ages));
    }

    private static class Solution {
        public int bestTeamScore(int[] scores, int[] ages) {
            Player[] players = new Player[scores.length];
            for (int i = 0; i < scores.length; i++) {
                players[i] = new Player(scores[i], ages[i]);
            }
            Arrays.sort(players, (p1, p2) -> {
                if (p1.age != p2.age) {
                    return p1.age - p2.age;
                }
                return p1.score - p2.score;
            });
            int[] dp = new int[players.length];
            for (int i = 0; i < players.length; i++) {
                dp[i] = players[i].score;
                for (int j = 0; j < i; j++) {
                    if (players[j].score <= players[i].score) {
                        dp[i] = Math.max(dp[i], players[i].score + dp[j]);
                    }
                }
            }
            return Arrays.stream(dp).max().getAsInt();
        }

        record Player(int score, int age) { }
    }
}
