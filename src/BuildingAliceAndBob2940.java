import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BuildingAliceAndBob2940 {
    public static void main(String[] args) {
        int[] heights = {6, 4, 8, 5, 2, 7};
        int[][] queries = {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};
        System.out.println(Arrays.toString(new Solution().leftmostBuildingQueries(heights, queries)));
    }

    private static class Solution {
        public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
            int n = queries.length;
            int[] res = new int[n];

            for (int[] query : queries) {
                if (query[0] > query[1]) {
                    int temp = query[0];
                    query[0] = query[1];
                    query[1] = temp;
                }
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> (queries[i2][1] - queries[i1][1]));
            for (int i = 0; i < n; i++) {
                pq.add(i);
            }
            int queryIndex = pq.poll();
            int leftIndex = queries[queryIndex][0];
            int rightIndex = queries[queryIndex][1];
            List<Building> buildings = new ArrayList<>();
            for (int i = heights.length - 1; i >= 0; i--) {
                while (!buildings.isEmpty() && buildings.getLast().height < heights[i]) {
                    buildings.removeLast();
                }
                buildings.add(new Building(i, heights[i]));

                while (rightIndex == i) {
                    if (leftIndex == i || heights[leftIndex] < heights[rightIndex]) {
                        res[queryIndex] = i;
                    } else {
                        res[queryIndex] = getMinIndex(buildings, heights[leftIndex]);
                    }
                    if (pq.isEmpty()) return res;
                    queryIndex = pq.poll();
                    leftIndex = queries[queryIndex][0];
                    rightIndex = queries[queryIndex][1];
                }
            }
            return res;
        }

        private int getMinIndex(List<Building> buildingList, int target) {
            if (target > buildingList.getFirst().height) return -1;
            int resultIndex = -1;
            int left = 0, right = buildingList.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (buildingList.get(mid).height > target) {
                    resultIndex = buildingList.get(mid).index;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return resultIndex;
        }

        static class Building {
            int index, height;

            public Building(int index, int height) {
                this.index = index;
                this.height = height;
            }
        }
    }
}
