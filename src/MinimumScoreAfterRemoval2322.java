import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumScoreAfterRemoval2322 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 5, 4, 11};
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        Solution solution = new Solution();
        System.out.println(solution.minimumScore(nums, edges));
    }

    private static class Solution {
        int[] xorScores;
        int[] depthArr;
        int[] inTime;
        int[] outTime;
        int[] parent;
        int time = 0;

        public int minimumScore(int[] nums, int[][] edges) {
            xorScores = new int[nums.length];
            depthArr = new int[nums.length];
            inTime = new int[nums.length];
            outTime = new int[nums.length];
            parent = new int[nums.length];

            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], _ -> new ArrayList<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], _ -> new ArrayList<>()).add(edge[0]);
            }
            findXOR(graph, 0, -1, 0, nums);
            int totalXOR = xorScores[0];
            int res = Integer.MAX_VALUE;


            for (int i = 0; i < edges.length; i++) {
                int u1 = edges[i][0], v1 = edges[i][1];
                int child1 = parent[v1] == u1 ? v1 : u1;

                for (int j = 0; j < edges.length; j++) {
                    if (i == j) continue;
                    int u2 = edges[j][0], v2 = edges[j][1];
                    int child2 = parent[v2] == u2 ? v2 : u2;

                    int xor1, xor2, xor3;
                    if (isAncestor(child1, child2)) {
                        xor1 = xorScores[child2];
                        xor2 = xorScores[child1] ^ xor1;
                        xor3 = totalXOR ^ xorScores[child1];
                    } else if (isAncestor(child2, child1)) {
                        xor1 = xorScores[child1];
                        xor2 = xorScores[child2] ^ xor1;
                        xor3 = totalXOR ^ xorScores[child2];
                    } else {
                        xor1 = xorScores[child1];
                        xor2 = xorScores[child2];
                        xor3 = totalXOR ^ xor1 ^ xor2;
                    }

                    int big = Math.max(xor1, Math.max(xor2, xor3));
                    int small = Math.min(xor1, Math.min(xor2, xor3));
                    res = Math.min(res, big - small);
                }
            }
            return res;
        }

        public int findXOR(HashMap<Integer, List<Integer>> graph, int curr, int prev, int depth, int[] values) {
            depthArr[curr] = depth;
            parent[curr] = prev;
            inTime[curr] = time++;
            int res = values[curr];
            for (int next : graph.get(curr)) {
                if (next != prev) {
                    res ^= findXOR(graph, next, curr, depth + 1, values);
                }
            }
            outTime[curr] = time++;
            return xorScores[curr] = res;
        }

        private boolean isAncestor(int parent, int child) {
            return inTime[parent] <= inTime[child] && outTime[child] <= outTime[parent];
        }
    }
}
