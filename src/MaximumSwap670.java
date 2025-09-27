import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSwap670 {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumSwap(98368));
    }
    private static class Solution {
        public int maximumSwap(int num) {
            int[] numIndex = new int[10];
            Arrays.fill(numIndex, -1);
            List<Integer> numList = new ArrayList<>();

            for (int i = 0; num > 0; i++) {
                int digit = num % 10;
                numList.add(digit);
                if (numIndex[digit] == -1) numIndex[digit] = i;
                num /= 10;
            }

            List<Integer> leftMax = new ArrayList<>();
            for (int digit: numList) {
                if (leftMax.isEmpty()) leftMax.add(digit);
                else leftMax.add(Integer.max(digit, leftMax.getLast()));
            }

            for (int i = numList.size() - 1; i >= 0; i--) {
                if (numList.get(i) < leftMax.get(i)) {
                    swap(numList, i, numIndex[leftMax.get(i)]);
                    break;
                }
            }

            return listToInt(numList);
        }

        private static void swap(List<Integer> arr, int i, int j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }

        private static int listToInt(List<Integer> list) {
            int res = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                res *= 10;
                res += list.get(i);
            }
            return res;
        }
    }
}
