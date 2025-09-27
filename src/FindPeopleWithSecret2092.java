import java.util.*;

public class FindPeopleWithSecret2092 {
    private static class Solution {
        private final List<int[]> EMPTY = new ArrayList<>();
        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            HashMap<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] meeting : meetings) {
                int start = meeting[0];
                int end = meeting[1];
                int time = meeting[2];

                graph.computeIfAbsent(start, key -> new ArrayList<>()).add(new int[]{end, time});
                graph.computeIfAbsent(end, key -> new ArrayList<>()).add(new int[]{start, time});
            }

            int[] minTimeToKnowSecret = new int[n];
            Arrays.fill(minTimeToKnowSecret, Integer.MAX_VALUE);
            minTimeToKnowSecret[0] = minTimeToKnowSecret[firstPerson] = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(val -> minTimeToKnowSecret[val]));
            pq.offer(firstPerson);
            pq.offer(0);

            while (!pq.isEmpty()) {
                int curr = pq.poll();
                for (int[] next: graph.getOrDefault(curr, EMPTY)) {
                    int nextPerson = next[0];
                    int meetTime = next[1];

                    if (minTimeToKnowSecret[curr] <= meetTime && minTimeToKnowSecret[nextPerson] > meetTime) {
                        minTimeToKnowSecret[nextPerson] = meetTime;
                        pq.offer(nextPerson);
                    }
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (minTimeToKnowSecret[i] == Integer.MAX_VALUE) continue;
                res.add(i);
            }
            return res;
        }
    }
}
