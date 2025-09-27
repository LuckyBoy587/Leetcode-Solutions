import java.util.PriorityQueue;

public class FurthestBuildingToReach1642 {
    public static void main(String[] args) {
        int[] heights = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        System.out.println(new FurthestBuildingToReach1642.Solution().furthestBuilding(heights, 10, 2));
    }

    private static class Solution {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 1; i < heights.length; i++) {
                int diff = heights[i] - heights[i - 1];
                if (diff > 0) pq.add(diff);

                if (pq.size() > ladders) {
                    bricks -= pq.poll();
                    if (bricks < 0) {
                        return i - 1;
                    }
                }
            }

            return heights.length - 1;
        }
    }
}
