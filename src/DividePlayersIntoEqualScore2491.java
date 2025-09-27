import java.util.Arrays;

public class DividePlayersIntoEqualScore2491 {
    private static class Solution {
        public long dividePlayers(int[] skill) {
            int max = skill[0];
            int min = skill[0];
            for (int i = 1; i < skill.length; i++) {
                max = Math.max(max, skill[i]);
                min = Math.min(min, skill[i]);
            }
            int[] arr = new int[max + 1];
            for (int num: skill) arr[num]++;
            int st = min, end = max;
            long res = 0;
            while (st <= end) {
                if (arr[st] != arr[end]) return -1;
                int count = st != end ? arr[st] : arr[st] / 2;
                long currScore = (long) st * end * count;
                res += currScore;
                st++;
                end--;
            }

            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().dividePlayers(new int[]{3, 2, 5, 1, 3, 4}));
    }
}
