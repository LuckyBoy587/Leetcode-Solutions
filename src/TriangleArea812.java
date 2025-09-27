void main() {

}

private static class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double area = area(
                            points[i][0], points[i][1],
                            points[j][0], points[j][1],
                            points[k][0], points[k][1]
                    );
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private double area(double x1, double y1,
                        double x2, double y2,
                        double x3, double y3) {
        return Math.abs(
                x1 * (y2 - y3) +
                        x2 * (y3 - y1) +
                        x3 * (y1 - y2)
        ) / 2.0;
    }
}