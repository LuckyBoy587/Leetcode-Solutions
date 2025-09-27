import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CheckIfGridCanBeCutIntoSections3394 {
    public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = {
                {0, 0, 1, 4},
                {1, 0, 2, 3},
                {2, 0, 3, 3},
                {3, 0, 4, 3},
                {1, 3, 4, 4}
        };


        System.out.println(new Solution().checkValidCuts(n, rectangles));
    }

    private static class Solution {
        public boolean checkValidCuts(int n, int[][] rectangles) {
            List<Rectangle> rects = new ArrayList<>();
            for (int[] rectangle : rectangles) {
                rects.add(new Rectangle(rectangle[0], rectangle[1], rectangle[2], rectangle[3]));
            }
            return checkHorizontal(rects) || checkVertical(rects);
        }

        private boolean checkVertical(List<Rectangle> rectangles) {
            rectangles.sort(Comparator.comparingInt(r -> r.startY));
            Rectangle low = rectangles.getFirst();
            int lowI;
            for (lowI = 0; lowI + 1 < rectangles.size() && low.isVerticalOverlap(rectangles.get(lowI + 1)); lowI++) {
                low.mergeVertical(rectangles.get(lowI + 1));
            }
            rectangles.sort(Comparator.comparingInt(r -> r.endY));
            Rectangle high = rectangles.getLast();
            int highI;
            for (highI = rectangles.size() - 1; highI - 1 >= lowI && rectangles.get(highI - 1).isVerticalOverlap(high); highI--) {
                high.mergeVertical(rectangles.get(highI - 1));
            }

            return low.endY < high.startY && highI - lowI > 1;
        }

        private boolean checkHorizontal(List<Rectangle> rectangles) {
            rectangles.sort(Comparator.comparingInt(r -> r.startX));
            Rectangle left = rectangles.getFirst();
            int leftJ;
            for (leftJ = 0; leftJ + 1 < rectangles.size() && left.isHorizontalOverlap(rectangles.get(leftJ + 1)); leftJ++) {
                left.mergeHorizontal(rectangles.get(leftJ + 1));
            }

            rectangles.sort(Comparator.comparingInt(r -> r.endX));
            Rectangle right = rectangles.getLast();
            int rightJ;
            for (rightJ = rectangles.size() - 1; rightJ - 1 >= 0 && rectangles.get(rightJ - 1).isHorizontalOverlap(right); rightJ--) {
                right.mergeHorizontal(rectangles.get(rightJ - 1));
            }

            return left.endX < right.startX && rightJ - leftJ > 1;
        }

        private static class Rectangle {
            int startX, startY, endX, endY;

            public Rectangle(int startX, int startY, int endX, int endY) {
                this.endX = endX;
                this.endY = endY;
                this.startX = startX;
                this.startY = startY;
            }

            public boolean isVerticalOverlap(Rectangle other) {
                return this.endY > other.startY;
            }

            public boolean isHorizontalOverlap(Rectangle other) {
                return this.endX > other.startX;
            }

            public void mergeVertical(Rectangle other) {
                this.endY = Math.max(this.endY, other.endY);
                this.startY = Math.min(this.startY, other.startY);
            }

            public void mergeHorizontal(Rectangle other) {
                this.endX = Math.max(this.endX, other.endX);
                this.startX = Math.min(this.startX, other.startX);
            }

            @Override
            public String toString() {
                return "Rectangle{" +
                        "endX=" + endX +
                        ", startX=" + startX +
                        ", startY=" + startY +
                        ", endY=" + endY +
                        '}';
            }
        }
    }
}
