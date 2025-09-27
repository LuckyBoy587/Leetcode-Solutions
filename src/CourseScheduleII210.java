import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII210 {
    private static class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> graph = new ArrayList<>();
            boolean[][] isParent = new boolean[numCourses][numCourses];
            int[] indegree = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] prerequisite : prerequisites) {
                graph.get(prerequisite[1]).add(prerequisite[0]);
                indegree[prerequisite[0]]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            int[] res = new int[numCourses];
            int i;
            for (i = 0; !queue.isEmpty(); i++) {
                int curr = queue.poll();
                for (int neighbor : graph.get(curr)) {
                    if (--indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }

                res[i] = curr;
            }
            return i == numCourses ? res : new int[0];
        }
    }
}
