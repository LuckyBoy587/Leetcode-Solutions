void main() {
    int N = 5;
    int M = 6;
    int[][] arr = {
        {1, 2, 3, 4, 5, 6},
        {7, 8, 9, 10, 11, 12},
        {13, 14, 15, 16, 17, 18},
        {19, 20, 21, 22, 23, 24},
        {25, 26, 27, 28, 29, 30}
    };
    int X1 = 3, Y1 = 4, X2 = 4, Y2 = 5;
    int result = subMatrixSum(arr, N, M, X1, Y1, X2, Y2);
    IO.println("Test Case 1:");
    IO.println("Expected: 78, Got: " + result);
    IO.println("Test passed: " + (result == 78));
    IO.println();

    N = 3;
    M = 3;
    int[][] arr2 = {
        {9, 8, 7},
        {4, 2, 1},
        {6, 5, 3}
    };
    X1 = 1;
    Y1 = 2;
    X2 = 3;
    Y2 = 3;
    result = subMatrixSum(arr2, N, M, X1, Y1, X2, Y2);
    IO.println("Test Case 2:");
    IO.println("Expected: 26, Got: " + result);
    IO.println("Test passed: " + (result == 26));
    IO.println();
}

int subMatrixSum(int[][] arr, int n, int m, int x1, int y1, int x2, int y2) {
    int sum = 0;
    for (int i = x1 - 1; i < x2; i++) {
        for (int j = y1 - 1; j < y2; j++) {
            sum += arr[i][j];
        }
    }
    return sum;
}
