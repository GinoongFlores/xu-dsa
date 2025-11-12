/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.util.Scanner;

public class Fernandico {

    public static void main(String[] args) {
        String[] words = { "apple", "banana", "cherry", "grape", "mango", "orange", "peach", "strawberry",
                "watermelon" }; // Binary Search

        try (Scanner input = new Scanner(System.in)) { // Dari sya mangutana
            System.out.print("Enter a word to search:");
            String target = input.nextLine().toLowerCase();

            // mag start sya sa first index sa left to last index pa right
            int left = 0;
            int right = words.length - 1;
            boolean found = false;

            while (left <= right) { // E keep syag search until makita
                int mid = (left + right) / 2; // formula para sa mid

                System.out.println("left: " + left + " (" + words[left] + "), " + "Mid: " + mid + " (" + words[mid]
                        + "), " + right + " (" + words[mid] + ") ");
                int comparison = target.compareTo(words[mid]);
                if (comparison == 0) {
                    System.out.println("Found!:" + " (" + target + ") " + "\" at index" + mid + "."); // kani is iyang
                                                                                                      // gina tan aw gi
                                                                                                      // asa nag change
                                                                                                      // ang mid index
                    found = true;
                    break;
                } else if (comparison > 0) {
                    left = mid + 1; // skip the left half
                } else {
                    right = mid - 1; // Move to left half
                }
            }
            if (!found) {
                System.out.println("X" + target + "\" not found in the list.");
            }
        }
    }
}
