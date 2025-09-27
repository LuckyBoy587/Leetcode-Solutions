import java.util.*;

public class ReplaceNonCoPrimeNumbers2197 {
    public static void main(String[] args) {
        int[] nums = {6, 4, 3, 2, 7, 6, 2};
        System.out.println(new Solution().replaceNonCoprimes(nums));
    }

    private static class Solution {
        public List<Integer> replaceNonCoprimes(int[] nums) {
            Stack<FactorMap> stack = new Stack<>();
            for (int num : nums) {
                FactorMap curr = new FactorMap(num);
                while (!stack.isEmpty() && stack.peek().isNotCoPrime(curr)) {
                    curr.merge(stack.pop());
                }
                stack.push(curr);
            }

            List<Integer> result = new ArrayList<>();
            while (!stack.isEmpty()) {
                result.add(stack.pop().toNumber());
            }

            Collections.reverse(result);
            return result;
        }

        private static class FactorMap {
            private final Map<Integer, Integer> factors;

            public FactorMap(int n) {
                factors = new HashMap<>();
                for (int i = 2; i * i <= n; i++) {
                    while (n % i == 0) {
                        factors.merge(i, 1, Integer::sum);
                        n /= i;
                    }
                }
                if (n > 1) {
                    factors.put(n, 1);
                }
            }

            public boolean isNotCoPrime(FactorMap other) {
                for (int prime : factors.keySet()) {
                    if (other.factors.containsKey(prime)) {
                        return true;
                    }
                }
                return false;
            }

            public void merge(FactorMap other) {
                for (Map.Entry<Integer, Integer> entry : other.factors.entrySet()) {
                    factors.merge(entry.getKey(), entry.getValue(), Integer::max);
                }
            }

            public int toNumber() {
                int result = 1;
                for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
                    result *= (int) Math.pow(entry.getKey(), entry.getValue());
                }
                return result;
            }

            @Override
            public String toString() {
                return String.valueOf(toNumber());
            }
        }
    }
}
