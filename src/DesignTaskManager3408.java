import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class DesignTaskManager3408 {
    public static void main(String[] args) {
        List<List<Integer>> initial = List.of(List.of(1, 101, 8), List.of(2, 102, 20), List.of(3, 103, 5));
        TaskManager tm = new TaskManager(initial);
        java.util.List<Integer> outputs = new java.util.ArrayList<>();
        tm.add(4, 104, 5);
        tm.edit(102, 9);
        outputs.add(tm.execTop());
        tm.rmv(101);
        tm.add(50, 101, 8);
        outputs.add(tm.execTop());
        System.out.println(outputs);
    }

    private static class TaskManager {
        HashMap<Integer, Integer> taskPriorityMap = new HashMap<>();
        HashMap<Integer, Integer> taskUserMap = new HashMap<>();
        PriorityQueue<int[]> taskQueue = new PriorityQueue<>((t1, t2) -> {
            int p1 = t1[1];
            int p2 = t2[1];
            if (p1 != p2) {
                return Integer.compare(p2, p1);
            }
            return Integer.compare(t2[0], t1[0]);
        });

        public TaskManager(List<List<Integer>> tasks) {
            for (List<Integer> task : tasks) {
                int userId = task.get(0);
                int taskId = task.get(1);
                int priority = task.get(2);
                add(userId, taskId, priority);
            }
        }

        public void add(int userId, int taskId, int priority) {
            taskPriorityMap.put(taskId, priority);
            taskUserMap.put(taskId, userId);
            taskQueue.offer(new int[]{taskId, priority});
        }

        public void edit(int taskId, int newPriority) {
            taskPriorityMap.put(taskId, newPriority);
            taskQueue.offer(new int[]{taskId, newPriority});
        }

        public void rmv(int taskId) {
            taskPriorityMap.remove(taskId);
            taskUserMap.remove(taskId);
        }

        public int execTop() {
            while (!taskQueue.isEmpty()) {
                int[] topTask = taskQueue.peek();
                if (!taskPriorityMap.containsKey(topTask[0]) || taskPriorityMap.get(topTask[0]) != topTask[1]) {
                    taskQueue.poll();
                } else {
                    taskPriorityMap.remove(topTask[0]);
                    return taskUserMap.remove(topTask[0]);
                }
            }
            return -1;
        }
    }
}
