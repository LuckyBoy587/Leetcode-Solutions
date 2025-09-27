import java.util.PriorityQueue;

public class MiceAndCheese2611 {
    public static void main(String[] args) {
        int[] reward1 = {1, 4, 4, 6, 4};
        int[] reward2 = {6, 5, 3, 6, 1};

        System.out.println(new Solution().miceAndCheese(reward1, reward2, 1));
    }
    private static class Solution {
        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
                boolean isEdible1 = reward1[i1] > reward2[i1];
                boolean isEdible2 = reward1[i2] > reward2[i2];
                if (isEdible1 && isEdible2) {
                    return Integer.compare(reward1[i2] - reward2[i2], reward1[i1] - reward2[i1]);
                }
                if (isEdible1) return -1;
                if (isEdible2) return 1;
                return reward2[i2] - reward1[i1];
            });

            for (int i = 0; i < reward1.length; i++) {
                pq.add(i);
            }

            int res = 0;
            while (k-- > 0) {
                int eatIndex = pq.poll();
                res += reward1[eatIndex];
                reward2[eatIndex] = 0;
            }

            for (int reward : reward2) {
                res += reward;
            }

            return res;
        }
    }
}
