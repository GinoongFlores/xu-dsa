package dsa.bigO;

public class SimpleBinarySearch {

    /**
     * This class demonstrates binary search algorithm and explains why it has O(log
     * n) time complexity.
     *
     * WHAT IS BINARY SEARCH?
     * - A divide-and-conquer searching algorithm that works on sorted collections
     * - Instead of checking each element (like linear search), it repeatedly
     * divides the search space in half
     * - Always compares with the middle element and eliminates half the remaining
     * elements with each step
     *
     * WHY BINARY SEARCH IS O(log n):
     * - Each step divides the problem size by 2 (eliminates half the remaining
     * items)
     * - The maximum number of steps needed is log₂(n)
     * - Example: For 1,000 words, we need at most 10 steps (because 2^10 = 1024)
     * - Example: For 1,000,000 words, we need at most 20 steps (because 2^20 =
     * 1,048,576)
     *
     * COMPARISON WITH LINEAR SEARCH [O(n)]:
     * - Linear search: Check each element one by one
     * - Binary search: Eliminate half of remaining elements with each step
     * - For 1 million words: Linear search → up to 1,000,000 steps, Binary search →
     * up to 20 steps
     */

    public static void main(String[] args) {
        // Our simplified dictionary - MUST BE SORTED!
        String[] dictionary = {
                "apple", "banana", "cat", "dog", "elephant",
                "frog", "goat", "horse", "iguana", "jaguar",
                "kangaroo", "lion", "monkey", "newt", "octopus"
        };

        System.out.println("SIMPLE BINARY SEARCH DEMONSTRATION");
        System.out.println("=================================");
        System.out.println("Dictionary has 15 words:\n");

        // Print the dictionary with indexes
        for (int i = 0; i < dictionary.length; i++) {
            System.out.println(i + ": " + dictionary[i]);
        }

        // Three simple search examples
        System.out.println("\n--- SEARCH #1: 'cat' ---");
        findWord(dictionary, "cat");

        System.out.println("\n--- SEARCH #2: 'octopus' ---");
        findWord(dictionary, "octopus");

        System.out.println("\n--- SEARCH #3: 'zebra' ---");
        findWord(dictionary, "zebra");

        // Explain why O(log n) is so powerful
        System.out.println("\nWHY IS O(log n) SO EFFICIENT?");
        System.out.println("-------------------------");
        System.out.println("Dictionary size    | Max steps needed");
        System.out.println("------------------|-----------------");
        System.out.println("15 words          | 4 steps");
        System.out.println("1,000 words       | 10 steps");
        System.out.println("1,000,000 words   | 20 steps");
        System.out.println("\nEach time you DOUBLE the dictionary size,");
        System.out.println("you only need ONE more step!");
    }

    public static void findWord(String[] dictionary, String target) {
        int left = 0;
        int right = dictionary.length - 1;
        int step = 1;

        System.out.println("Looking for '" + target + "'...");

        while (left <= right) {
            // Find the middle
            int middle = left + (right - left) / 2;

            // Show what we're checking
            System.out.println("\nStep " + step + ": Check middle word '" +
                    dictionary[middle] + "' (index " + middle + ")");

            // Compare our target with the middle word
            if (target.equals(dictionary[middle])) {
                System.out.println("Found '" + target + "' at index " + middle + "!");
                return;
            } else if (target.compareTo(dictionary[middle]) < 0) {
                // Target comes before the middle word
                System.out.println("'" + target + "' comes BEFORE '" +
                        dictionary[middle] + "', so look in the LEFT half");
                right = middle - 1;
                System.out.println("New search range: index " + left + " to " + right);
            } else {
                // Target comes after the middle word
                System.out.println("'" + target + "' comes AFTER '" +
                        dictionary[middle] + "', so look in the RIGHT half");
                left = middle + 1;
                System.out.println("New search range: index " + left + " to " + right);
            }

            step++;
        }

        System.out.println("'" + target + "' is not in the dictionary.");
    }
}
