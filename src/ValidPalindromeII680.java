public class ValidPalindromeII680 {
    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("madam"));
    }
    private static class Solution {
        public boolean validPalindrome(String s) {
            char[] arr = s.toCharArray();
            int i = 0, j = arr.length - 1;
            while (i < j) {
                if (arr[i] != arr[j]) {
                    break;
                }
                i++;
                j--;
            }
            if (i >= j) return true;

            int tempI = i + 1, tempJ = j;
            while (tempI < tempJ) {
                if (arr[tempI] != arr[tempJ]) {
                    break;
                }
                tempI++;
                tempJ--;
            }
            if (tempI >= tempJ) {
                return true;
            }

            tempI = i;
            tempJ = j - 1;

            while (tempI < tempJ) {
                if (arr[tempI] != arr[tempJ]) {
                    break;
                }
                tempI++;
                tempJ--;
            }
            return tempI >= tempJ;
        }
    }
}
