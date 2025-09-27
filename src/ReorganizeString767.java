import java.util.PriorityQueue;

public class ReorganizeString767 {
    public static void main(String[] args) {
        System.out.println(new Solution().reorganizeString("aaabc"));
    }
    private static class Solution {
        public String reorganizeString(String s) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> freq[b - 'a'] - freq[a - 'a']);
            for (char c = 'a'; c <= 'z'; c++) {
                if (freq[c - 'a'] > 0) {
                    pq.offer(c);
                }
            }

            while (!pq.isEmpty()) {
                char curr = pq.poll();
                if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == curr) {
                    if (pq.isEmpty()) return ""; // Not possible to reorganize
                    char next = pq.poll();
                    sb.append(next);
                    if (--freq[next - 'a'] > 0) {
                        pq.offer(next);
                    }
                    pq.offer(curr);
                } else {
                    sb.append(curr);
                    if (--freq[curr - 'a'] > 0) {
                        pq.offer(curr);
                    }
                }
            }

            return sb.toString();
        }
    }
}
