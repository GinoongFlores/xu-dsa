import java.util.Arrays;

/**
 * Bubble Sort Activity: High Score Leaderboard
 *
 * REAL-WORLD CONTEXT:
 * A game has a list of player scores that are all jumbled up.
 * To display a proper leaderboard, we need to sort them from
 * lowest to highest. Bubble Sort is a simple algorithm that
 * "bubbles" the largest values to the end.
 *
 * HOW BUBBLE SORT WORKS:
 * - Compare adjacent elements
 * - Swap if they're in wrong order
 * - Repeat until no more swaps are needed
 * - Largest values "bubble" to the end in each pass
 *
 * YOUR TASK:
 * Implement the bubbleSort method to make all test cases pass.
 */

public class BubbleSortStarter {
    
    /**
     * Sorts an array of scores in ascending order using bubble sort.
     * Used by: Test Case 1, Test Case 2, Test Case 3
     * 
     * @param scores The array of scores to sort
     * @return A new sorted array (or modify the original array)
     */
    public int[] bubbleSort(int[] scores) {
        // TODO: Implement bubble sort algorithm
        // Hint: Create a copy of the array first (don't modify original)
        // Use nested loops:
        //   - Outer loop: number of passes (scores.length - 1)
        //   - Inner loop: compare adjacent elements (scores.length - 1 - i)
        //   - If scores[j] > scores[j+1], swap them
        // Return the sorted array
        
        // Create a copy to avoid modifying the original
        int[] sorted = Arrays.copyOf(scores, scores.length);
        
        // TODO: Your bubble sort implementation here
        // Example structure:
        // for (int i = 0; i < sorted.length - 1; i++) {
        //     for (int j = 0; j < sorted.length - 1 - i; j++) {
        //         if (sorted[j] > sorted[j + 1]) {
        //             // Swap sorted[j] and sorted[j + 1]
        //         }
        //     }
        // }
        
        return sorted; // Return the sorted array
    }
    
    // ============================================
    // TEST CASES - Already implemented below
    // Just run this file to test your implementation
    // 
    //  IMPORTANT: DO NOT MODIFY OR TOUCH THE TEST CASE CODE BELOW 
    // The test cases are already complete and should remain unchanged.
    // Only modify the TODO sections in the class methods above.
    // ============================================
    
    public static boolean testCase1() {
        System.out.println("=".repeat(50));
        System.out.println("TEST CASE 1: Two Elements (Easy)");
        System.out.println("=".repeat(50));
        
        BubbleSortStarter sorter = new BubbleSortStarter();
        
        int[] input = {30, 10};
        System.out.println("Input: " + Arrays.toString(input));
        
        int[] result = sorter.bubbleSort(input);
        int[] expected = {10, 30};
        
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Got: " + Arrays.toString(result));
        
        boolean passed;
        if (Arrays.equals(result, expected)) {
            System.out.println("[PASS] - Test Case 1");
            passed = true;
        } else {
            System.out.println("[FAIL] - Test Case 1");
            passed = false;
        }
        System.out.println();
        return passed;
    }
    
    public static boolean testCase2() {
        System.out.println("=".repeat(50));
        System.out.println("TEST CASE 2: Jumbled List (Moderate)");
        System.out.println("=".repeat(50));
        
        BubbleSortStarter sorter = new BubbleSortStarter();
        
        int[] input = {45, 10, 90, 25};
        System.out.println("Input: " + Arrays.toString(input));
        
        int[] result = sorter.bubbleSort(input);
        int[] expected = {10, 25, 45, 90};
        
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Got: " + Arrays.toString(result));
        
        boolean passed;
        if (Arrays.equals(result, expected)) {
            System.out.println("[PASS] - Test Case 2");
            passed = true;
        } else {
            System.out.println("[FAIL] - Test Case 2");
            passed = false;
        }
        System.out.println();
        return passed;
    }
    
    public static boolean testCase3() {
        System.out.println("=".repeat(50));
        System.out.println("TEST CASE 3: Reverse Sorted (Harder)");
        System.out.println("=".repeat(50));
        
        BubbleSortStarter sorter = new BubbleSortStarter();
        
        int[] input = {40, 30, 20, 10};
        System.out.println("Input: " + Arrays.toString(input));
        
        int[] result = sorter.bubbleSort(input);
        int[] expected = {10, 20, 30, 40};
        
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Got: " + Arrays.toString(result));
        
        boolean passed;
        if (Arrays.equals(result, expected)) {
            System.out.println("[PASS] - Test Case 3 (correctly sorted reverse-ordered data)");
            passed = true;
        } else {
            System.out.println("[FAIL] - Test Case 3 (should sort from highest to lowest)");
            passed = false;
        }
        System.out.println();
        return passed;
    }
    
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("BUBBLE SORT TEST CASES - High Score Leaderboard");
        System.out.println("=".repeat(50) + "\n");
        
        boolean result1 = testCase1();
        boolean result2 = testCase2();
        boolean result3 = testCase3();
        
        System.out.println("=".repeat(50));
        System.out.println("TEST SUMMARY");
        System.out.println("=".repeat(50));
        System.out.println("Test Case 1: " + (result1 ? "[PASS]" : "[FAIL]"));
        System.out.println("Test Case 2: " + (result2 ? "[PASS]" : "[FAIL]"));
        System.out.println("Test Case 3: " + (result3 ? "[PASS]" : "[FAIL]"));
        System.out.println("=".repeat(50));
        
        if (result1 && result2 && result3) {
            System.out.println("All test cases PASSED!");
        } else {
            System.out.println("Some test cases FAILED. Complete the TODO sections to fix them.");
        }
        System.out.println("=".repeat(50));
    }
}

/*
============================================
TODO: EXPLANATION
============================================

Write a brief explanation of how you solved the problem.
What was your thought process? What data structures did you use and why?

1. Bubble Sort Logic: [Your explanation here]

*/

