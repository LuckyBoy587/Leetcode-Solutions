public class CheckIfDigitsAreEqualInStringAfterOperationsI3461 {
    // LeetCode 3461: Check If Digits Are Equal in String After Operations I
    // Simulate the process: repeatedly replace s with pairwise sums modulo 10
    // until length == 2, then check equality.

    public boolean hasSameDigits(String s) {
        if (s == null) return false;
        // Use a char array of digits for in-place style simulation
        char[] cur = s.toCharArray();
        while (cur.length > 2) {
            char[] next = new char[cur.length - 1];
            for (int i = 0; i < next.length; i++) {
                int a = cur[i] - '0';
                int b = cur[i + 1] - '0';
                int sum = (a + b) % 10;
                next[i] = (char) (sum + '0');
            }
            cur = next;
        }
        return cur.length == 2 && cur[0] == cur[1];
    }

    // Simple main to demonstrate provided examples
    public static void main(String[] args) {
        CheckIfDigitsAreEqualInStringAfterOperationsI3461 sol = new CheckIfDigitsAreEqualInStringAfterOperationsI3461();
        String ex1 = "3902";
        String ex2 = "34789";
        System.out.println("Input: " + ex1 + " -> " + sol.hasSameDigits(ex1)); // true
        System.out.println("Input: " + ex2 + " -> " + sol.hasSameDigits(ex2)); // false
    }
}
