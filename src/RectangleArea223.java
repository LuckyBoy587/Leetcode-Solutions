public class RectangleArea223 {
    private static class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            Rectangle r1 = new Rectangle(ax1, ay1, ax2, ay2);
            Rectangle r2 = new Rectangle(bx1, by1, bx2, by2);
            return r1.getArea() + r2.getArea() - Rectangle.getIntersectionArea(r1, r2);
        }

        private record Rectangle(int x1, int y1, int x2, int y2) {

            private static boolean intersects(Rectangle r1, Rectangle r2) {
                return Math.max(r1.x1, r2.x1) < Math.min(r1.x2, r2.x2) &&
                        Math.max(r1.y1, r2.y1) < Math.min(r1.y2, r2.y2);
            }

            public static int getIntersectionArea(Rectangle r1, Rectangle r2) {
                if (intersects(r1, r2)) {
                    int width = Math.min(r1.x2, r2.x2) - Math.max(r1.x1, r2.x1);
                    int height = Math.min(r1.y2, r2.y2) - Math.max(r1.y1, r2.y1);
                    return width * height;
                }
                return 0;
            }

            public int getArea() {
                return (x2 - x1) * (y2 - y1);
            }
        }
    }
}
