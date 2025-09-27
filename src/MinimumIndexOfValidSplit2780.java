import java.util.List;

public class MinimumIndexOfValidSplit2780 {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumIndex(List.of(1, 1, 1, 2)));
    }

    private static class Solution {
        public int minimumIndex(List<Integer> nums) {
            int dominant = findDominant(nums);
            int domFreq = 0;
            for (int num : nums) {
                if (num == dominant) domFreq++;
            }
            int leftCount = 0, rightCount = domFreq;
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) == dominant) {
                    leftCount++;
                    rightCount--;
                }

                if (leftCount < (i / 2) && rightCount < ((nums.size() - i) / 2)) {
                    return i;
                }
            }
            return -1;
        }

        private int find(List<Integer> nums, int[] domFreq, int total) {
            int res = -1;
            int left = 0, right = nums.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                boolean leftPossible = isLeftPossible(mid, domFreq, total);
                boolean rightPossible = isRightPossible(mid, domFreq, total);

                if (leftPossible && rightPossible) {
                    res = mid;
                    right = mid - 1;
                } else if (leftPossible) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return res;
        }

        private boolean isLeftPossible(int index, int[] domFreq, int total) {
            int leftLen = index + 1;
            int leftFreq = domFreq[index];
            return leftFreq > (leftLen / 2);
        }

        private boolean isRightPossible(int index, int[] domFreq, int total) {
            int rightLen = domFreq.length - index - 1;
            int rightFreq = total - domFreq[index];
            return rightFreq > (rightLen / 2);
        }

        private int findDominant(List<Integer> nums) {
            int dominant = 0, count = 0;
            for (int num : nums) {
                if (count == 0) {
                    dominant = num;
                }

                if (num == dominant) {
                    count++;
                } else {
                    count--;
                }
            }

            return dominant;
        }
    }
}
