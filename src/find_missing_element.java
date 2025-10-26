void main() {
    int[] arr1 = {1, 2, 3, 5};
    IO.println("Test Case 1:");
    IO.println("Array: " + Arrays.toString(arr1));
    IO.println("Expected: 4, Got: " + missingElement(arr1));
    IO.println();

    int[] arr2 = {8, 2, 4, 5, 3, 7, 1};
    IO.println("Test Case 2:");
    IO.println("Array: " + Arrays.toString(arr2));
    IO.println("Expected: 6, Got: " + missingElement(arr2));
    IO.println();

    int[] arr3 = {1};
    IO.println("Test Case 3:");
    IO.println("Array: " + Arrays.toString(arr3));
    IO.println("Expected: 2, Got: " + missingElement(arr3));
}

int missingElement(int[] arr) {
    Arrays.sort(arr);
    int missing = 1;
    while (missing - 1 < arr.length && arr[missing - 1] == missing) missing++;
    return missing;
}