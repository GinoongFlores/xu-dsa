
public class Daayata {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        System.out.println("Searching for: " + target);

        while (left <= right) {
            // Show current search range
            System.out.println("Left: " + left + ", Right: " + right);

            int mid = (left + right) / 2;
            System.out.println("Checking middle index: " + mid + ", Value: " + arr[mid]);

            if (arr[mid] == target) {
                return mid; // Found it
            }

            if (arr[mid] < target) {
                // The target is greater, move right
                System.out.println(arr[mid] + " is less than " + target + " -> moving right");
                left = mid + 1;
            } else {
                // The target is smaller, move left
                System.out.println(arr[mid] + " is greater than " + target + " -> moving left");
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        // Example with a sorted list of numbers
        int[] numbers = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
        int target = 23;

        int result = binarySearch(numbers, target);

        System.out.println("--------------------");
        if (result != -1) {
            System.out.println("Value " + target + " found at index " + result);
        } else {
            System.out.println("Target " + target + " not found in array.");
        }
    }
}
