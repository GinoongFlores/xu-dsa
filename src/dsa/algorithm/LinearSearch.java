package dsa.search;

public class LinearSearch {

    /**
     * Linear search implementation as shown in the diagram
     *
     * @param A array to search in
     * @param n size of the array
     * @param x value to search for
     * @return index of x if found, -1 otherwise
     */
    public static int linearSearch(int[] A, int n, int x) {
        // Iterate through each element of the array
        for (int i = 0; i < n; i++) {
            // If the current element equals the search value
            if (A[i] == x) {
                // Return the index where found
                return i;
            }
        }
        // Return -1 if the value is not found
        return -1;
    }

    public static void main(String[] args) {
        // Example array from your image
        int[] A = { 2, 6, 13, 21, 36, 47, 63, 81, 97 };
        int n = A.length;

        // Test cases
        int x1 = 81;
        int x2 = 25;
        int x3 = 21;

        // Search for each value and display results
        // Store the result of each search in a variable so we only run the search once
        // and print a stable, easy-to-read message.
        int res1 = linearSearch(A, n, x1);
        System.out.println("Searching for " + x1 + ": " +
                (res1 != -1 ? "Yes (at index " + res1 + ")" : "No"));

        int res2 = linearSearch(A, n, x2);
        System.out.println("Searching for " + x2 + ": " +
                (res2 != -1 ? "Yes (at index " + res2 + ")" : "No"));

        int res3 = linearSearch(A, n, x3);
        System.out.println("Searching for " + x3 + ": " +
                (res3 != -1 ? "Yes (at index " + res3 + ")" : "No"));

        // Performance characteristics
        System.out.println("\nPerformance characteristics:");
        System.out.println("Best case: 1 comparison (when element is at the beginning)");
        System.out.println("Worst case: n comparisons (when element is at the end or not present)");
        System.out.println("Time complexity: O(n)");
    }
}