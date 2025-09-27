import java.util.*;

public class SkyLineProblem {
    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.getSkyline(buildings);
        System.out.println(result);
    }

    private static class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> res = new ArrayList<>();
            PriorityQueue<Building> pq = new PriorityQueue<>((b1, b2) -> {
                if (b1.height != b2.height) return b2.height - b1.height;
                return b1.left - b2.left;
            });

            pq.offer(new Building(0, Integer.MAX_VALUE, 0));

            Set<Integer> criticalXPoints = new TreeSet<>();
            for (int[] building : buildings) {
                criticalXPoints.add(building[0]);
                criticalXPoints.add(building[1]);
            }
            Iterator<Integer> xPointsIterator = criticalXPoints.iterator();
            int buildingIndex = 0;
            int currX = xPointsIterator.next();
            int prevHeight = 0;
            while (xPointsIterator.hasNext()) {
                while (buildingIndex < buildings.length && buildings[buildingIndex][0] == currX) {
                    pq.offer(new Building(buildings[buildingIndex++]));
                }

                if (!pq.isEmpty() && prevHeight != pq.peek().height) {
                    prevHeight = pq.peek().height;
                    res.add(List.of(currX, prevHeight));
                }
                currX = xPointsIterator.next();

                while (!pq.isEmpty() && pq.peek().right <= currX) pq.poll();
            }
            res.add(List.of(currX, 0));
            return res;
        }

        static class Building {
            int left, right, height;

            public Building(int left, int right, int height) {
                this.height = height;
                this.left = left;
                this.right = right;
            }

            public Building(int[] building) {
                this(building[0], building[1], building[2]);
            }
        }
    }
}
