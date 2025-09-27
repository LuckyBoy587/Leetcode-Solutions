import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumEmployeeForAMeeting2127 {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumInvitations(new int[]{2, 2, 1, 2}));
    }

    private static class Solution {
        public int maximumInvitations(int[] favorite) {
            int n = favorite.length;
            int[] depthCycle = new int[n];
            Arrays.fill(depthCycle, -1);
            int cycleRes = 0;
            boolean[] visitedCycle = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visitedCycle[i]) {
                    cycleRes = Math.max(cycleRes, dfsCycle(favorite, depthCycle, visitedCycle, i, 0));
                }
            }

            int pathRes = 0;
            boolean[] visitedPath = new boolean[n];
            List<List<Integer>> favGraph = getFavGraph(favorite);
            for (int i = 0; i < n; i++) {
                int j = favorite[i];
                if (i < j && favorite[j] == i) {
                    visitedPath[i] = visitedPath[j] = true;
                    int leftPath = dfsPath(favGraph, i, visitedPath);
                    int rightPath = dfsPath(favGraph, j, visitedPath);
                    pathRes += 2 + leftPath + rightPath;
                }
            }

            return Math.max(pathRes, cycleRes);
        }

        private List<List<Integer>> getFavGraph(int[] favorite) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < favorite.length; i++) {
                res.add(new ArrayList<>());
            }
            for (int i = 0; i < favorite.length; i++) {
                res.get(favorite[i]).add(i);
            }
            return res;
        }

        private int dfsCycle(int[] favorite, int[] depth, boolean[] visited, int curr, int currDepth) {
            if (visited[curr]) {
                return depth[curr] == -1 ? 0 : currDepth - depth[curr];
            }
            visited[curr] = true;
            depth[curr] = currDepth;
            int result = dfsCycle(favorite, depth, visited, favorite[curr], currDepth + 1);
            depth[curr] = -1;
            return result;
        }

        private int dfsPath(List<List<Integer>> favGraph, int currPerson, boolean[] visited) {
            int res = 0;
            for (int favParent: favGraph.get(currPerson)) {
                if (!visited[favParent]) {
                    visited[favParent] = true;
                    res = Math.max(res, 1 + dfsPath(favGraph, favParent, visited));
                }
            }
            return res;
        }
    }
}
