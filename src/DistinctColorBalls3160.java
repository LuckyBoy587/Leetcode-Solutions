import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DistinctColorBalls3160 {
    private static class Solution {
        public int[] queryResults(int limit, int[][] queries) {
            HashMap<Integer, Integer> ballToColorMap = new HashMap<>();
            HashMap<Integer, Integer> colorToBallMap = new HashMap<>();
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int ball = queries[i][0];
                int currColor = queries[i][1] + 1;
                int prevColor = ballToColorMap.getOrDefault(ball, 0);
                if (prevColor == 0) {
                    ballToColorMap.put(ball, currColor);
                } else if (prevColor != currColor) {
                    int freq = colorToBallMap.get(prevColor);
                    if (freq == 1) {
                        colorToBallMap.remove(prevColor);
                    } else {
                        colorToBallMap.put(prevColor, freq - 1);
                    }
                }

                ballToColorMap.put(ball, currColor);
                colorToBallMap.put(currColor, colorToBallMap.getOrDefault(currColor, 0) + 1);
                System.out.println(ballToColorMap);
                System.out.println(colorToBallMap);
                System.out.println();
                res[i] = colorToBallMap.size();
            }

            return res;
        }
    }
}
