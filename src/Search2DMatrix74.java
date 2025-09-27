public class Search2DMatrix74 {
    public static void main(String[] args) {
        int[][] myArray = {
                {1}
        };
        System.out.println(new Solution().searchMatrix(myArray, 13));
    }

    private static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int startI = 0, endI = matrix.length - 1;
            while (startI < endI) {
                int midI = startI + (endI - startI + 1) / 2;
                if (matrix[midI][0] > target) {
                    endI = midI - 1;
                } else {
                    startI = midI;
                }
            }

            return search(matrix[startI], target);
        }

        private boolean search(int[] arr, int target) {
            int startI = 0, endI = arr.length - 1;
            while (startI < endI) {
                int midI = startI + (endI - startI + 1) / 2;
                if (arr[midI] == target) {
                    return true;
                } else if (arr[midI] > target) {
                    endI = midI - 1;
                } else {
                    startI = midI;
                }
            }
            return arr[startI] == target;
        }
    }
}
