import java.util.*;

public class ValidArrangmentOfPairs2097 {
    public static void main(String[] args) {
        int[][] array = {{5, 1}, {4, 5}, {11, 9}, {9, 4}};
        int[][] twoDArray = {{8, 5}, {8, 7}, {0, 8}, {0, 5}, {7, 0}, {5, 0}, {0, 7}, {8, 0}, {7, 8}};
        System.out.println(Arrays.deepToString(new Solution().validArrangement(array)));
    }
    private static class Solution {
        public int[][] validArrangement(int[][] pairs) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Map<Integer, Integer> inDegree = new HashMap<>();
            Map<Integer, Integer> outDegree = new HashMap<>();
            for (int[] pair : pairs) {
                if (!graph.containsKey(pair[0])) {
                    graph.put(pair[0], new ArrayList<>());
                }
                graph.get(pair[0]).add(pair[1]);
                inDegree.put(pair[1], inDegree.getOrDefault(pair[1], 0) + 1);
                outDegree.put(pair[0], outDegree.getOrDefault(pair[0], 0) + 1);
            }

            Stack<Integer> stack = new Stack<>();
            List<Integer> resultList = new ArrayList<>();
            int startNode = pairs[0][0];
            for (int i = 1; i < pairs.length; i++) {
                int node = pairs[i][0];
                int inDegreeCount = inDegree.getOrDefault(node, 0);
                int outDegreeCount = outDegree.getOrDefault(node, 0);
                if (outDegreeCount - inDegreeCount == 1) {
                    startNode = node;
                    break;
                }
            }
            stack.push(startNode);

            while (!stack.isEmpty()) {
                int start = stack.peek();
                if (graph.containsKey(start) && !graph.get(start).isEmpty()) {
                    stack.push(graph.get(start).removeLast());
                } else {
                    resultList.add(stack.pop());
                }
            }
            int[][] result = new int[resultList.size() - 1][2];
            for (int i = resultList.size() - 1; i > 0; i--) {
                result[result.length - i] = new int[]{resultList.get(i), resultList.get(i - 1)};
            }
            return result;
        }
    }
}
