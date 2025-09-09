package dsa.bigO;

public class On2 {

    /*
     * Understanding O(n²) Time Complexity
     *
     * Key Characteristics:
     * ? - Squared Growth: Time grows as the square of the input size (n × n)
     * ? - Nested Loops: One loop inside another loop, both processing n elements
     * ? - Multiplying Effect: If input size doubles, execution time increases about
     * 4 times
     *
     * Common Examples:
     * ? - Nested loops iterating through the same array
     * ? - Simple sorting algorithms (Bubble Sort, Selection Sort)
     * ? - Finding all pairs in an array
     */

    public static void main(String[] args) {
        // Create arrays of different sizes to demonstrate quadratic scaling
        int[] smallArray = new int[10];
        int[] mediumArray = new int[50];
        int[] largeArray = new int[100];

        fillArray(smallArray);
        fillArray(mediumArray);
        fillArray(largeArray);

        System.out.println("Demonstrating O(n²) Time Complexity with Nested Loops:");
        System.out.println("-----------------------------------------------------");

        // Test with small array (n=10)
        System.out.println("Small array (n=" + smallArray.length + "):");
        long startTime = System.nanoTime();
        int pairsSmall = countPairs(smallArray);
        long endTime = System.nanoTime();
        System.out.println("- Number of pairs processed: " + pairsSmall);
        System.out.println("- Time taken: " + (endTime - startTime) + " nanoseconds");

        // Test with medium array (n=50, 5x larger)
        System.out.println("\nMedium array (n=" + mediumArray.length + "):");
        startTime = System.nanoTime();
        int pairsMedium = countPairs(mediumArray);
        endTime = System.nanoTime();
        System.out.println("- Number of pairs processed: " + pairsMedium);
        System.out.println("- Time taken: " + (endTime - startTime) + " nanoseconds");

        // Test with large array (n=100, 10x larger than small)
        System.out.println("\nLarge array (n=" + largeArray.length + "):");
        startTime = System.nanoTime();
        int pairsLarge = countPairs(largeArray);
        endTime = System.nanoTime();
        System.out.println("- Number of pairs processed: " + pairsLarge);
        System.out.println("- Time taken: " + (endTime - startTime) + " nanoseconds");

        System.out.println("\nNotice how time increases quadratically with array size:");
        System.out.println("- When size increases 5x (10→50), operations increase ~25x");
        System.out.println("- When size increases 10x (10→100), operations increase ~100x");
        System.out.println("This quadratic growth is the defining characteristic of O(n²) algorithms.");
    }

    /**
     * O(n²) example: Finding and counting all possible pairs in an array
     * Similar to the JavaScript example with nested loops
     */
    public static int countPairs(int[] array) {
        int pairsCount = 0;

        // Nested loops - O(n²)
        // STEP 1: Outer loop runs n times (once for each element)
        for (int i = 0; i < array.length; i++) {
            // STEP 2: For EACH iteration of outer loop, inner loop runs n times
            for (int j = 0; j < array.length; j++) {
                // STEP 3: This code executes n × n = n² times total
                pairsCount++;

                // EXPLANATION:
                // - If array has 10 elements: 10×10 = 100 iterations
                // - If array has 100 elements: 100×100 = 10,000 iterations
                // - This is why O(n²) gets slow quickly with larger inputs

                // In a real application, you might do something with the pairs
                // System.out.println("Pair (" + i + "," + j + "): " + array[i] + "," +
                // array[j]);
            }
        }

        return pairsCount;
    }

    /**
     * Fills array with sequential values (not important for this example)
     */
    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }
}
