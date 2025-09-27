import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleIV1462 {
    private static class Solution {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            List<List<Integer>> graph = new ArrayList<>();
            boolean[][] isParent = new boolean[numCourses][numCourses];
            int[] indegree = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] prerequisite : prerequisites) {
                graph.get(prerequisite[0]).add(prerequisite[1]);
                indegree[prerequisite[1]]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int neighbor : graph.get(curr)) {
                    for (int currPrerequisite = 0; currPrerequisite < numCourses; currPrerequisite++) {
                        if (isParent[currPrerequisite][curr]) {
                            isParent[currPrerequisite][neighbor] = true;
                        }
                    }
                    isParent[curr][neighbor] = true;
                    if (--indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            List<Boolean> res = new ArrayList<>();
            for (int[] query : queries) {
                res.add(isParent[query[0]][query[1]]);
            }
            return res;
        }
    }
}
