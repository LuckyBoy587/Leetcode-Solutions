import java.util.*;

public class NumberOfWaysToArriveAtDestination1976 {
    private static class Solution {
        int MOD = 1000000007;
        List<int[]> EMPTY = new ArrayList<>();

        public int countPaths(int n, int[][] roads) {
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int[] road : roads) {
                int start = road[0], end = road[1], time = road[2];
                map.computeIfAbsent(start, _ -> new ArrayList<>()).add(new int[]{end, time});
                map.computeIfAbsent(end, _ -> new ArrayList<>()).add(new int[]{start, time});
            }

            long[] dist = new long[n];
            long[] ways = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[0] = 0;
            ways[0] = 1;
            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
            pq.offer(new long[]{0, 0});

            while (!pq.isEmpty()) {
                long[] currPair = pq.poll();
                int curr = (int) currPair[0];
                long currDist = currPair[1];
                if (currDist > dist[curr]) continue;
                for (int[] dest : map.getOrDefault(curr, EMPTY)) {
                    long nextDist = dist[curr] + dest[1];
                    if (nextDist < dist[dest[0]]) {
                        dist[dest[0]] = nextDist;
                        ways[dest[0]] = ways[curr];
                        pq.offer(new long[]{dest[0], dist[dest[0]]});
                    } else if (nextDist == dist[dest[0]]) {
                        ways[dest[0]] = (ways[curr] + ways[dest[0]] % MOD);
                    }
                }
            }
            return (int) (ways[n - 1] % MOD);
        }
    }
}
