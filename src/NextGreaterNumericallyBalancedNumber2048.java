import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class NextGreaterNumericallyBalancedNumber2048 {
    private static class Solution {
        static TreeSet<Integer> balancedNumbers = new TreeSet<>();
        static {
            for (int i = 1; i <= 1000000; i++) {
                if (isNumericallyBalanced(i)) {
                    balancedNumbers.add(i);
                }
            }
            balancedNumbers.add(1224444);
        }
        public static int nextBeautifulNumber(int n) {
            Integer higher = balancedNumbers.higher(n);
            return higher != null ? higher : -1;
        }

        private static boolean isNumericallyBalanced(int num) {
            int[] freq = new int[10];
            while (num > 0) {
                int digit = num % 10;
                freq[digit]++;
                num /= 10;
            }
            for (int i = 0; i < 10; i++) {
                if (freq[i] != 0 && freq[i] != i) {
                    return false;
                }
            }
            return true;
        }
    }
}