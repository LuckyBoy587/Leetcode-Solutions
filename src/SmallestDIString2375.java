public class SmallestDIString2375 {
    public static void main(String[] args) {
        System.out.println(new Solution().smallestNumber("IIIDIDDD"));
    }
    private static class Solution {
        public String smallestNumber(String pattern) {
            int n = pattern.length();
            char[] arr = new char[n + 1];
            arr[0] = '1';
            for (int i = 1; i <= n; i++) {
                if (pattern.charAt(i - 1) == 'I') {
                    arr[i] = (char) ('0' + i + 1);
                } else {
                    arr[i] = arr[i - 1];
                    int x = i;
                    while (x > 0 && arr[x] == arr[x - 1]) {
                        arr[--x]++;
                    }
                }
            }
            return new String(arr);
        }
    }
}
