package dsa.bigO;

public class oN {

    /*
     * Understanding O(n) Time Complexity
     *
     * Key Characteristics:
     * ? - Linear Time: The time taken grows linearly with input size
     * ? - Iteration: Typically involves iterating through the entire input
     * ? - Scale Factor: If input size doubles, execution time roughly doubles
     *
     * Common Example: Linear Search
     * ? - Must check each element one by one
     * ? - Time complexity directly proportional to array size (n)
     */

    public static void main(String[] args) {
        // Create arrays of different sizes to demonstrate scaling
        int[] smallArray = new int[1000];
        int[] mediumArray = new int[5000];
        int[] largeArray = new int[10000];

        // Fill arrays with values and place search target
        fillArray(smallArray);
        fillArray(mediumArray);
        fillArray(largeArray);

        System.out.println("Demonstrating O(n) Time Complexity with Linear Search:");
        System.out.println("----------------------------------------------------");

        // The value we're searching for
        int target = 42;

        // Search in small array
        long startTime = System.nanoTime();
        int positionSmall = linearSearch(smallArray, target);
        long endTime = System.nanoTime();
        System.out.println("Small array (n=" + smallArray.length + "):");
        System.out.println("- Search result: " +
                (positionSmall != -1 ? "Found at position " + positionSmall : "Not found"));
        System.out.println("- Time taken: " + (endTime - startTime) + " nanoseconds");

        // Search in medium array
        startTime = System.nanoTime();
        int positionMedium = linearSearch(mediumArray, target);
        endTime = System.nanoTime();
        System.out.println("\nMedium array (n=" + mediumArray.length + "):");
        System.out.println("- Search result: " +
                (positionMedium != -1 ? "Found at position " + positionMedium : "Not found"));
        System.out.println("- Time taken: " + (endTime - startTime) + " nanoseconds");

        // Search in large array
        startTime = System.nanoTime();
        int positionLarge = linearSearch(largeArray, target);
        endTime = System.nanoTime();
        System.out.println("\nLarge array (n=" + largeArray.length + "):");
        System.out.println("- Search result: " +
                (positionLarge != -1 ? "Found at position " + positionLarge : "Not found"));
        System.out.println("- Time taken: " + (endTime - startTime) + " nanoseconds");

        System.out.println("\nNotice how the time increases proportionally with array size.");
        System.out.println("This is the defining characteristic of O(n) algorithms.");
    }

    /**
     * Linear search algorithm - O(n) time complexity
     * This method demonstrates why it's O(n):
     * - We must check elements one by one
     * - In the worst case, we examine all n elements
     * - The time taken grows linearly with input size
     */
    public static int linearSearch(int[] array, int target) {
        // Need to check elements one by one - O(n)
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Found the target
            }
        }

        return -1; // Target not found
    }

    /**
     * Helper method to fill array with random values
     * Places target value (42) in the middle of each array
     */
    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // Fill with random values between 0 and 999
            array[i] = (int) (Math.random() * 1000);

            // Place our search target in the middle of the array
            if (i == array.length / 2) {
                array[i] = 42;
            }
        }
    }
}
