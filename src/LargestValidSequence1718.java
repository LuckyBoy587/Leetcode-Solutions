import java.util.Arrays;

public class LargestValidSequence1718 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructDistancedSequence(5)));
    }

    private static class Solution {
        public int[] constructDistancedSequence(int n) {
            int[] res = new int[2 * n - 1];
            create(res, 0, new boolean[n + 1], n);
            return res;
        }

        public boolean create(int[] arr, int index, boolean[] visited, int num) {
            if (index == arr.length) return true;
            if (arr[index] != 0) return create(arr, index + 1, visited, num);
            for (int i = num; i >= 1; i--) {
                if (visited[i]) continue;
                if (arr[index] == 0) {
                    if (i > 1 && (index + i >= arr.length || arr[index + i] != 0)) continue;
                    visited[i] = true;
                    if (i > 1) arr[index] = arr[index + i] = i;
                    else arr[index] = i;
                    if (create(arr, index + 1, visited, num)) return true;
                    if (i > 1) arr[index] = arr[index + i] = 0;
                    else arr[index] = 0;
                    visited[i] = false;
                }
            }
            return false;
        }
    }
}
