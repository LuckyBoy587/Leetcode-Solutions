public class TakeKCharacters2516 {
    class Solution {
        public int takeCharacters(String s, int k) {
            int aCount = 0;
            int bCount = 0;
            int cCount = 0;
            char[] word = s.toCharArray();
            for (char c : word) {
                if (c == 'a') {
                    aCount++;
                } else if (c == 'b') {
                    bCount++;
                } else {
                    cCount++;
                }
            }

            if (aCount < k || bCount < k || cCount < k) {
                return -1;
            }

            return 0;
        }
    }
}
