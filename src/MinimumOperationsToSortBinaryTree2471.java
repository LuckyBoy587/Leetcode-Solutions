import java.util.*;

public class MinimumOperationsToSortBinaryTree2471 {
    private static class Solution {
        public int minimumOperations(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            int res = 0;
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                int[] arr = new int[size];
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    arr[i] = node.val;
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }

                int[] sortedArray = Arrays.copyOf(arr, size);
                boolean[] visited = new boolean[size];
                Arrays.sort(sortedArray);
                Map<Integer, Integer> indexMap = new HashMap<>();
                for (int i = 0; i < size; i++) {
                    indexMap.put(sortedArray[i], i);
                }
                for (int i = 0; i < sortedArray.length; i++) {
                    if (visited[i]) continue;
                    int cycleCount = 0;
                    int curr = i;

                    while (!visited[curr]) {
                        cycleCount++;
                        visited[curr] = true;
                        curr = indexMap.get(arr[curr]);
                    }

                    res += cycleCount - 1;
                }
            }

            return res;
        }
    }
}
