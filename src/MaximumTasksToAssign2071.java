import java.util.Arrays;
import java.util.TreeMap;

public class MaximumTasksToAssign2071 {
    private static class Solution {
        public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
            Arrays.sort(workers);
            Arrays.sort(tasks);
            int res = 0;
            int left = 1, right = Math.min(tasks.length, workers.length);
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isPossible(tasks, workers, pills, strength, mid)) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return res;
        }

        private boolean isPossible(int[] tasks, int[] workers, int pills, int strength, int k) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = workers.length - k; i < workers.length; i++) {
                map.put(workers[i], map.getOrDefault(workers[i], 0) + 1);
            }

            for (int taskIndex = k; taskIndex >= 0; taskIndex--) {
                int currTask = tasks[taskIndex];
                Integer workerKey = map.ceilingKey(currTask);
                decreaseKey(map, workerKey);
                if (workerKey != null) continue;

                if (pills == 0) return false;
                pills--;

                Integer strengthKey = map.ceilingKey(currTask - strength);
                if (strengthKey == null) return false;
                decreaseKey(map, strengthKey);
            }
            return true;
        }

        private void decreaseKey(TreeMap<Integer, Integer> map, Integer key) {
            if (key == null) return;
            int freq = map.get(key);
            if (freq == 1) map.remove(key);
            map.put(key, freq - 1);
        }
    }
}
