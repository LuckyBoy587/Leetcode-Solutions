import java.util.Arrays;

public class DefuseTheBomb1652 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().decrypt(new int[]{5, 7, 1, 4}, 3)));
    }
    private static class Solution {
        public int[] decrypt(int[] code, int k) {
            if (k == 0) return new int[code.length];
            int windowLength = Math.abs(k);
            int[] windowSum = new int[code.length];
            int count = 0;
            int currWindowSum = 0;
            for (int i = 0; count < code.length; i++) {
                currWindowSum += code[i % code.length];
                if (i + 1 >= windowLength) {
                    windowSum[count++] = currWindowSum;
                    currWindowSum -= code[i + 1 - windowLength];
                }
            }

            for (int i = 0; i < code.length; i++) {
                if (k > 0) {
                    code[i] = windowSum[(i + 1) % code.length];
                } else {
                    code[i] = windowSum[(code.length + i + k) % code.length];
                }
            }
            return code;
        }
    }
}
