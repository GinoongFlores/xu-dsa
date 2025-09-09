package dsa.bigO;

public class OlogN {

    /*
     * ========== UNDERSTANDING O(log n) TIME COMPLEXITY ==========
     *
     * WHAT IS O(log n)?
     * - O(log n) means the time taken grows very slowly as input size increases
     * - Each time the input size doubles, the algorithm only needs ONE extra step
     * - It's MUCH more efficient than O(n) for large inputs
     *
     * REAL-WORLD ANALOGY:
     * - Think of a phone book: To find "Smith", you don't check every page
     * - You open to the middle, see if "Smith" is before or after, then check only
     * half the book
     * - Then half of that half, and so on - very efficient!
     *
     * COMMON EXAMPLES:
     * - Binary search (shown in this program)
     * - Finding an item in a balanced search tree
     * - Certain divide-and-conquer algorithms
     */

    public static void main(String[] args) {
        // STEP 1: Create three test arrays with increasing sizes
        // We'll see how binary search performs as data grows larger
        int[] smallArray = createSortedArray(1000); // 1,000 elements
        int[] mediumArray = createSortedArray(10000); // 10,000 elements (10x larger)
        int[] largeArray = createSortedArray(100000); // 100,000 elements (100x larger)

        System.out.println("BINARY SEARCH DEMONSTRATION - O(log n) Time Complexity");
        System.out.println("====================================================");

        // STEP 2: Pick a number to search for in our arrays
        int target = 42; // We'll look for the number 42 in each array

        // STEP 3: Search in the SMALL array (1,000 elements)
        System.out.println("\n1. SEARCHING IN SMALL ARRAY (" + smallArray.length + " elements):");

        // Measure how long the search takes
        long startTime = System.nanoTime();
        int positionSmall = binarySearch(smallArray, target);
        long endTime = System.nanoTime();

        // Show results
        System.out.println("   - Result: " +
                (positionSmall != -1 ? "Found at position " + positionSmall : "Not found"));
        System.out.println("   - Time taken: " + (endTime - startTime) + " nanoseconds");

        // STEP 4: Search in the MEDIUM array (10,000 elements - 10x larger)
        System.out.println("\n2. SEARCHING IN MEDIUM ARRAY (" + mediumArray.length + " elements - 10x larger):");

        startTime = System.nanoTime();
        int positionMedium = binarySearch(mediumArray, target);
        endTime = System.nanoTime();

        System.out.println("   - Result: " +
                (positionMedium != -1 ? "Found at position " + positionMedium : "Not found"));
        System.out.println("   - Time taken: " + (endTime - startTime) + " nanoseconds");

        // STEP 5: Search in the LARGE array (100,000 elements - 100x larger)
        System.out.println("\n3. SEARCHING IN LARGE ARRAY (" + largeArray.length + " elements - 100x larger):");

        startTime = System.nanoTime();
        int positionLarge = binarySearch(largeArray, target);
        endTime = System.nanoTime();

        System.out.println("   - Result: " +
                (positionLarge != -1 ? "Found at position " + positionLarge : "Not found"));
        System.out.println("   - Time taken: " + (endTime - startTime) + " nanoseconds");

        // STEP 6: Explain what we observed
        System.out.println("\n------- THE POWER OF O(log n) -------");
        System.out.println("IMPORTANT OBSERVATION:");
        System.out.println("- When array size grew 100 TIMES LARGER (1,000 → 100,000)");
        System.out.println("- The time only increased by a SMALL AMOUNT");
        System.out.println("- This is what makes O(log n) algorithms so efficient!");
        System.out.println("\nCOMPARISON:");
        System.out.println("- If this were an O(n) algorithm, the large array would take");
        System.out.println("  approximately 100 TIMES LONGER than the small array");
        System.out.println("- With O(log n), it only takes about 2-3 TIMES longer");
    }

    /**
     * Binary Search - A classic O(log n) algorithm
     *
     * WHY IS BINARY SEARCH O(log n)?
     * - It cuts the problem size IN HALF with each step
     * - For an array of 8 elements: We need at most 3 steps (log₂(8) = 3)
     * - For an array of 1,000,000 elements: We need only about 20 steps!
     *
     * VISUALIZATION:
     * Array: [0, 1, 2, 3, 4, 5, 6, 7] (8 elements)
     * Step 1: Check middle (4). Is target < 4? Look at left half [0,1,2,3]
     * Step 2: Check middle of left (1). Is target > 1? Look at [2,3]
     * Step 3: Check middle of remainder (2). Found!
     *
     * Each step eliminates HALF of the remaining elements.
     */
    public static int binarySearch(int[] array, int target) {
        // STEP 1: Set up our search boundaries
        int left = 0; // Start at the beginning of the array
        int right = array.length - 1; // End at the last element

        // STEP 2: Keep searching until boundaries cross
        while (left <= right) {
            // STEP 3: Find the middle element (avoiding integer overflow)
            int middle = left + (right - left) / 2;

            // STEP 4: Check if we found the target
            if (array[middle] == target) {
                return middle; // Found it! Return the position
            }

            // STEP 5: Decide which half to search next
            if (array[middle] < target) {
                // Target must be in the RIGHT half
                left = middle + 1; // Look only at the right half next time
            } else {
                // Target must be in the LEFT half
                right = middle - 1; // Look only at the left half next time
            }

            // KEY INSIGHT: Each iteration cuts the search space in HALF!
            // This is why the algorithm is O(log n) and not O(n)
        }

        // STEP 6: If we get here, the target is not in the array
        return -1;
    }

    /**
     * Helper method: Creates a sorted array of specified size
     *
     * NOTE: Binary search ONLY works on sorted arrays!
     * If the array is not sorted, binary search will give incorrect results.
     */
    private static int[] createSortedArray(int size) {
        // Create an array filled with consecutive numbers
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        // Make sure our target value (42) exists in the array
        // This ensures our search will be successful
        if (size > 42) {
            array[42] = 42; // This is redundant since array[42] is already 42,
                            // but it makes the intent clear
        }

        return array;
    }
}
