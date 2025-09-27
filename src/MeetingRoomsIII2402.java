import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsIII2402 {
    public static void main(String[] args) {
        int n = 4;
        int[][] meetings = {{18, 19}, {3, 12}, {17, 19}, {2, 13}, {7, 10}};
        Solution solution = new Solution();
        System.out.println("Most booked room: " + solution.mostBooked(n, meetings));
    }

    private static class Solution {
        public int mostBooked(int n, int[][] meetings) {
            Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));
            SegmentTree segmentTree = new SegmentTree(n);
            int[] freq = new int[n];
            for (int[] meeting : meetings) {
                int start = meeting[0];
                int end = meeting[1];

                int chosenRoomIndex = segmentTree.query(start);
                long delay = Math.max(0, segmentTree.getEndingTimeAt(chosenRoomIndex) - start);
                segmentTree.update(chosenRoomIndex, end + delay);
                freq[chosenRoomIndex]++;
                segmentTree.displayRoomValues();
            }

            int res = 0;
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > freq[res]) res = i;
            }
            System.out.println(Arrays.toString(freq));
            return res;
        }

        static class SegmentTree {
            long[] tree;
            int n;

            public SegmentTree(int n) {
                this.n = n;
                tree = new long[4 * n];
            }

            public void displayRoomValues() {
                for (int i = 0; i < n; i++) {
                    System.out.print(i + ": " + getEndingTimeAt(i) + ", ");
                }
                System.out.println();
            }

            public long getEndingTimeAt(int index) {
                return getValueUtil(0, 0, n - 1, index);
            }

            public int query(int target) {
                int index = queryUtil(0, 0, n - 1, target);
                return index != -1 ? index : queryMinIndex();
            }

            public void update(int index, long value) {
                updateUtil(0, 0, n - 1, index, value);
            }

            private int queryMinIndex() {
                return queryMinUtil(0, 0, n - 1);
            }

            private int queryUtil(int node, int start, int end, int target) {
                if (tree[node] > target) return -1;
                if (start == end) return start;
                int mid = start + (end - start) / 2;
                int leftValue = queryUtil(2 * node + 1, start, mid, target);
                if (leftValue != -1) return leftValue;
                return queryUtil(2 * node + 2, mid + 1, end, target);
            }

            private void updateUtil(int node, int start, int end, int idx, long val) {
                if (start == end) {
                    tree[node] = val;
                    return;
                }
                int mid = (start + end) / 2;
                if (idx <= mid) {
                    updateUtil(2 * node + 1, start, mid, idx, val);
                } else {
                    updateUtil(2 * node + 2, mid + 1, end, idx, val);
                }
                tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
            }

            private long getValueUtil(int node, int start, int end, int idx) {
                if (start == end) {
                    return tree[node];
                }
                int mid = (start + end) / 2;
                if (idx <= mid) {
                    return getValueUtil(2 * node + 1, start, mid, idx);
                } else {
                    return getValueUtil(2 * node + 2, mid + 1, end, idx);
                }
            }

            private int queryMinUtil(int node, int start, int end) {
                if (start == end) {
                    return start; // found the leaf with the min value
                }
                int left = 2 * node + 1;
                int right = 2 * node + 2;

                if (tree[left] <= tree[right]) {
                    return queryMinUtil(left, start, (start + end) / 2);
                } else {
                    return queryMinUtil(right, (start + end) / 2 + 1, end);
                }
            }
        }
    }
}
