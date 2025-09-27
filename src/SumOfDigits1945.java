public class SumOfDigits1945 {
    private static class Solution {
        public int getLucky(String s, int k) {
            int sum = 0;
            for (char letter: s.toCharArray()) {
                int letterSum = getLetterSum(letter);
                sum += letterSum;
            }

            return getNumberSum(sum, k - 1);
        }

        public int getLetterSum(char letter) {
            int val = letter - 'a' + 1;
            int sum = 0;
            while (val > 0) {
                sum += val % 10;
                val /= 10;
            }
            return sum;
        }

        public int getNumberSum(int num, int k) {
            if (k == 0 || num <= 9) return num;

            int res = 0;
            while (num > 0) {
                res += num % 10;
                num /= 10;
            }

            return getNumberSum(res, k - 1);
        }
    }

    public static void main(String[] args) {
        String s = "hvmhoasabaymnmsd";
        int k = 1;
        Solution solution = new Solution();
        System.out.println(solution.getLucky(s, k));
    }
}
