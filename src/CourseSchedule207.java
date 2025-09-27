import java.util.*;

public class CourseSchedule207 {
    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2, new int[][]{{1, 0}}));
    }

    private static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] frequencies = new int[numCourses];
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < numCourses; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                frequencies[prerequisite[0]]++;
                int key = prerequisite[1];
                int value = prerequisite[0];
                map.get(key).add(value);
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (frequencies[i] == 0) {
                    queue.add(i);
                }
            }

            int completed = 0;
            while (!queue.isEmpty()) {
                int course = queue.poll();
                completed++;
                for (int dependencies : map.get(course)) {
                    frequencies[dependencies]--;
                    if (frequencies[dependencies] == 0) {
                        queue.offer(dependencies);
                    }
                }
            }

            return completed == numCourses;
        }
    }
}
