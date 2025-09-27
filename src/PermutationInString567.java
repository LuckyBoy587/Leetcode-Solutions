public class PermutationInString567 {
    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("ab", "eidbaooo"));
    }
    private static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) return false;
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];

            for (char letter: s1.toCharArray()) {
                arr1[letter - 'a']++;
            }

            int m = s1.length();
            int n = s2.length();

            for (int i = 0; i < n; i++) {
                arr2[s2.charAt(i) - 'a']++;
                if (i + 1 >= m) {
                    if (isSame(arr1, arr2)) {
                        return true;
                    }
                    arr2[s2.charAt(i - m + 1) - 'a']--;
                }
            }

            return false;
        }

        private boolean isSame(int[] arr1, int[] arr2) {
            for (int i = 0; i < 26; i++) {
                if (arr1[i] != arr2[i]) return false;
            }
            return true;
        }
    }
}
