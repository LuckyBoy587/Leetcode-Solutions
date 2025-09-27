import java.util.Arrays;

public class PushDominos838 {
    public static void main(String[] args) {
        System.out.println(new Solution().pushDominoes(".L.R...LR..L.."));
    }

    private static class Solution {
        public String pushDominoes(String dominoes) {
            int n = dominoes.length();
            int[] leftFallDistance = new int[n];
            int[] rightFallDistance = new int[n];

            Arrays.fill(leftFallDistance, Integer.MAX_VALUE);
            Arrays.fill(rightFallDistance, Integer.MAX_VALUE);

            int index = n - 1;
            while (index >= 0) {
                while (index >= 0 && dominoes.charAt(index) != 'L') index--;
                if (index >= 0) leftFallDistance[index--] = 1;
                while (index >= 0 && dominoes.charAt(index) == '.') {
                    leftFallDistance[index] = leftFallDistance[index + 1] + 1;
                    index--;
                }
            }

            index = 0;
            while (index < n) {
                while (index < n && dominoes.charAt(index) != 'R') index++;
                if (index < n) rightFallDistance[index++] = 1;
                while (index < n && dominoes.charAt(index) == '.') {
                    rightFallDistance[index] = rightFallDistance[index - 1] + 1;
                    index++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (leftFallDistance[i] < rightFallDistance[i]) {
                    sb.append('L');
                } else if (rightFallDistance[i] < leftFallDistance[i]) {
                    sb.append('R');
                } else {
                    sb.append('.');
                }
            }

            return sb.toString();
        }
    }
}
