void main() {
    IO.println(new Solution().countAndSay(8));
}

private static class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String word = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char prev = word.charAt(0);
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (curr == prev) {
                count++;
            } else {
                sb.append(count).append(prev);
                count = 1;
            }
            prev = curr;
        }

        return sb.append(count).append(prev).toString();
    }
}
