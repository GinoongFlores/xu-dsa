package dsa.algorithm;

/**
 * Binary Search
 *
 * What it does:
 * - Look at the middle item and compare it to what we want.
 * - If it's too big, look at the left half.
 * - If it's too small, look at the right half.
 * - Keep cutting the list in half until we find it or run out of items.
 *
 * When to use:
 * - The list MUST be sorted (this is very important!).
 * - The list is large (faster than linear search).
 *
 * Time idea:
 * - Best case: found right in the middle.
 * - Worst case: keep cutting in half until we find it or it's not there.
 * - Much faster than linear search for big lists!
 */

public class BinarySearch {

    /**
     * Search for a number in a sorted list by cutting it in half each time.
     *
     * @param arr    the sorted array we search
     * @param target the number we are looking for
     * @return the index where target is found, or -1 if it is not there
     */
    public static int binarySearch(int[] arr, int target) {
        // Start with the whole list
        int left = 0;
        int right = arr.length - 1;

        // Keep searching while there are still items to check
        while (left <= right) {
            // Find the middle position (same formula from the image)
            int mid = (left + right) / 2;

            // Is the middle item what we want?
            if (arr[mid] == target) {
                // Yes! Found it at this position
                return mid;
            }
            // Is what we want bigger than the middle item?
            else if (target > arr[mid]) {
                // Yes → look in the right half (target is bigger)
                left = mid + 1;
            }
            // What we want is smaller than the middle item
            else {
                // Look in the left half (target is smaller)
                right = mid - 1;
            }
        }

        // We checked everything and didn't find it
        return -1;
    }

    public static void main(String[] args) {
        // The exact array from the image (must be sorted!)
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

        // Search for 70 (matches the image example)
        System.out.println("Searching for 70 (from the image):");
        int result1 = binarySearch(arr, 70);
        System.out.println("Result: " + (result1 != -1 ? "Found at index " + result1 : "Not found"));

        // Search for a number not in the list
        System.out.println("\nSearching for 25 (not in the list):");
        int result2 = binarySearch(arr, 25);
        System.out.println("Result: " + (result2 != -1 ? "Found at index " + result2 : "Not found"));

        // Search for first item (edge case)
        System.out.println("\nSearching for 10 (first item):");
        int result3 = binarySearch(arr, 10);
        System.out.println("Result: " + (result3 != -1 ? "Found at index " + result3 : "Not found"));

        // Search for last item (edge case)
        System.out.println("\nSearching for 100 (last item):");
        int result4 = binarySearch(arr, 100);
        System.out.println("Result: " + (result4 != -1 ? "Found at index " + result4 : "Not found"));

        // Quick recap
        System.out.println("\nWhy is binary search faster than linear search?");
        System.out.println("- Linear search: check each item one by one");
        System.out.println("- Binary search: cut the list in half each time");
        System.out.println("- For 1000 items: linear might check 1000, binary checks ~10!");
        System.out.println("- But remember: the list MUST be sorted first!");
    }
}
