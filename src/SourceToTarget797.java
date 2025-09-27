import java.util.ArrayList;
import java.util.List;

public class SourceToTarget797 {
    private static class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            search(graph, 0, new ArrayList<>());
            return res;
        }

        public void search(int[][] graph, int source, List<Integer> currPath) {
            currPath.add(source);
            if (source == graph.length - 1) {
                res.add(new ArrayList<>(currPath));
            } else {
                for (int dest: graph[source]) {
                        search(graph, dest, currPath);

                }
            }
            currPath.removeLast();
        }
    }
}
