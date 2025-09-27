import java.util.Collections;
import java.util.PriorityQueue;

public class LongestHappyString1405 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestDiverseString(7,1,0));
    }

    private static class Solution {
        public String longestDiverseString(int a, int b, int c) {
            PriorityQueue<Counter> pq = new PriorityQueue<>(Collections.reverseOrder());
            if (a > 0) pq.add(new Counter('a', a));
            if (b > 0) pq.add(new Counter('b', b));
            if (c > 0) pq.add(new Counter('c', c));
            StringBuilder sb = new StringBuilder();

            while (!pq.isEmpty()) {
                Counter curr = pq.poll();
                if (sb.length() < 2 || (sb.charAt(sb.length() - 2) != curr.letter || sb.charAt(sb.length() - 1) != curr.letter)) {
                    sb.append(curr.letter);
                    if (--curr.count > 0) pq.add(curr);
                } else if (!pq.isEmpty()) {
                    Counter next = pq.poll();
                    sb.append(next.letter);
                    if (--next.count > 0) pq.add(next);
                    pq.add(curr);
                }
            }
            return sb.toString();
        }
    }

    static class Counter implements Comparable<Counter> {
        char letter;
        int count;

        public Counter(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }

        @Override
        public int compareTo(Counter o) {
            return Integer.compare(count, o.count);
        }
    }
}
