package dsa.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Binary Search Activity (Real-world example)
 *
 * Scenario:
 * - Imagine a phone/contacts list that is already sorted alphabetically.
 * - We want to find a person's name quickly by checking the middle first,
 *   then deciding to look left or right.
 *
 * Important:
 * - The list MUST be sorted (A to Z) for binary search to work correctly.
 *
 * What happens in each step:
 * - Check the middle name.
 * - If the name we want comes after the middle name (alphabetically),
 *   we look in the right half.
 * - If it comes before, we look in the left half.
 * - Repeat until we find it or there is nothing left to check.
 */
public class BinarySearchAct {

    /**
     * Look for a name in a sorted list of names (A to Z).
     * This prints the pointers (left, mid, right) at each step so students can
     * see how the search space gets smaller.
     *
     * @param names  sorted array of names (A to Z)
     * @param target the name we are looking for
     * @return index where the name is found, or -1 if not found
     */
    public static int binarySearchName(String[] names, String target) {
        int left = 0;
        int right = names.length - 1;

        // Work with case-insensitive compare so "alex" and "Alex" match
        String goal = target.trim();

        while (left <= right) {
            int mid = (left + right) / 2; // middle position

            // Show what we are checking right now
            System.out.println("left=" + left + ", mid=" + mid + ", right=" + right
                    + " | checking '" + names[mid] + "'");

            int cmp = goal.compareToIgnoreCase(names[mid]);

            if (cmp == 0) {
                // Found an exact match (ignoring case)
                return mid;
            } else if (cmp > 0) {
                // Target name comes AFTER the middle name → look in the RIGHT half
                left = mid + 1;
            } else {
                // Target name comes BEFORE the middle name → look in the LEFT half
                right = mid - 1;
            }
        }

        // Not found anywhere
        return -1;
    }

    public static void main(String[] args) {
        // A small contacts list (already sorted A → Z)
        String[] contacts = {
                "Aiden", "Bella", "Caleb", "Diana", "Ethan",
                "Fiona", "Grace", "Henry", "Isla", "Jack",
                "Katie", "Liam", "Maya", "Noah", "Olivia",
                "Piper", "Quinn", "Riley", "Sophia", "Tyler"
        };

        System.out.println("Contacts (sorted): " + Arrays.toString(contacts));

        // Demo 1: A name that exists
        System.out.println("\nDemo 1: Find 'Riley'");
        int r1 = binarySearchName(contacts, "Riley");
        System.out.println(r1 != -1 ? "Result: Found at index " + r1 : "Result: Not found");

        // Demo 2: A name that does not exist
        System.out.println("\nDemo 2: Find 'Zara'");
        int r2 = binarySearchName(contacts, "Zara");
        System.out.println(r2 != -1 ? "Result: Found at index " + r2 : "Result: Not found");

        // Demo 3: First and last items (edge cases)
        System.out.println("\nDemo 3: Find first ('Aiden') and last ('Tyler')");
        int r3 = binarySearchName(contacts, "Aiden");
        int r4 = binarySearchName(contacts, "Tyler");
        System.out.println("Aiden → " + (r3 != -1 ? "index " + r3 : "not found"));
        System.out.println("Tyler → " + (r4 != -1 ? "index " + r4 : "not found"));

        // Optional: Let students try their own name
        System.out.println("\nTry it: Type a name to search (or just press Enter to skip)");
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();
            if (!input.trim().isEmpty()) {
                int idx = binarySearchName(contacts, input);
                System.out.println(idx != -1 ?
                        ("Result: '" + input + "' found at index " + idx) :
                        ("Result: '" + input + "' not found"));
            } else {
                System.out.println("Skipped interactive search.");
            }
        }

        // Quick recap to support the lesson
        System.out.println("\nWhy this is fast:");
        System.out.println("- We check the middle and skip half of the list each time.");
        System.out.println("- This is why binary search is much faster than checking every name.");
        System.out.println("- Remember: it only works correctly if the list is sorted A to Z.");
    }
}


