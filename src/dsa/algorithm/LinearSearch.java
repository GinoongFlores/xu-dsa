package dsa.search;

public class LinearSearch {

    /**
     * Linear Search
     *
     * What it does:
     * - Look at each item from left to right until we find the number.
     *
     * When to use:
     * - The list is small, or it is not sorted.
     *
     * Time idea:
     * - Best case: found at the start.
     * - Worst case: check all items.
     */
    public static int linearSearch(int[] A, int n, int x) {
        // Check each position one by one
        for (int i = 0; i < n; i++) {
            // Is this the number we want?
            if (A[i] == x) {
                // Yes → return this index (the first match)
                return i;
            }
        }
        // Not found anywhere
        return -1;
    }

    public static void main(String[] args) {
        // Example list (does not have to be sorted for linear search)
        int[] A = { 2, 6, 13, 21, 36, 47, 63, 81, 97 };
        int n = A.length;

        // Numbers to look for
        int x1 = 81;  // present near the end
        int x2 = 25;  // not present
        int x3 = 21;  // present near the middle

        // Run the search once per number and print a clear message
        int res1 = linearSearch(A, n, x1);
        System.out.println("Searching for " + x1 + ": " +
                (res1 != -1 ? "Yes (at index " + res1 + ")" : "No"));

        int res2 = linearSearch(A, n, x2);
        System.out.println("Searching for " + x2 + ": " +
                (res2 != -1 ? "Yes (at index " + res2 + ")" : "No"));

        int res3 = linearSearch(A, n, x3);
        System.out.println("Searching for " + x3 + ": " +
                (res3 != -1 ? "Yes (at index " + res3 + ")" : "No"));

        // Quick recap while the program runs
        System.out.println("\nHow many items might we check?");
        System.out.println("- Best case: 1 item (found right away)");
        System.out.println("- Worst case: all items (or not found at all)");
    }
}