
import java.util.Scanner;
import java.util.Arrays;

public class Somido {
    // This part of the code will have a user input to enter the numbers for their
    // integers to use
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter numbers (space-separated): ");
            String[] parts = sc.nextLine().split("\\s+");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++)
                arr[i] = Integer.parseInt(parts[i]);
            // This is where the code will sort out the integers into smallest value to
            // highest
            Arrays.sort(arr);
            System.out.println("Sorted array: " + Arrays.toString(arr));
            // This is where the user will input the integer to search for
            System.out.print("Enter number to search for: ");
            int target = sc.nextInt();
            // This part of the code will be searching for the said integer
            int left = 0, right = arr.length - 1;
            System.out.println("\nSearching for: " + target);

            while (left <= right) {
                System.out.println("Left: " + left + " Right: " + right);
                int mid = left + (right - left) / 2;
                System.out.println("Checking middle index: " + mid + " (value: " + arr[mid] + ")");
                // This is where to check if the integer or target is found and if not found
                // will keep looking for it
                if (arr[mid] == target) {
                    System.out.println("Value '" + target + "' found at index " + mid);
                    return;
                } else if (arr[mid] < target) {
                    System.out.println(arr[mid] + " is before " + target + " → move left to mid+1\n");
                    left = mid + 1;
                } else {
                    System.out.println(arr[mid] + " is after " + target + " → move right to mid-1\n");
                    right = mid - 1;
                }
            }
        }
        // If the search is finished without finding the target
        System.out.println("Search finished: value not found.");
    }
}