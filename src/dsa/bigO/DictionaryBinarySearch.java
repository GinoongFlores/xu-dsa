package dsa.bigO;

public class DictionaryBinarySearch {

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
