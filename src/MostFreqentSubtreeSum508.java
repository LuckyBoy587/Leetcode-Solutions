import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MostFreqentSubtreeSum508 {
    private static class Solution {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        List<Integer> sumArr = new ArrayList<>();
        public int[] findFrequentTreeSum(TreeNode root) {
            dfs(root);
            int[] res = new int[sumArr.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = sumArr.get(i);
            }

            return res;
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = dfs(root.left);
            int right = dfs(root.right);

            int currSum = root.val + left + right;
            int currFreq = map.getOrDefault(currSum, 0) + 1;
            map.put(currSum, currFreq);
            if (currFreq > maxFreq) {
                maxFreq = currFreq;
                sumArr.clear();
                sumArr.add(currSum);
            } else if (currFreq == maxFreq) {
                sumArr.add(currSum);
            }

            return currSum;
        }
    }
}
