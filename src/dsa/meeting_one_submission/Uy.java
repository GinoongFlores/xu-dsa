public class Uy {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        System.out.println("Searching for: " + target);

        while (left <= right) {
            // Print the current state
            System.out.println("Left: " + left + ", Right: " + right);

            int mid = (left + right) / 2;
            System.out.println("Checking middle index: " + mid + ", Value: " + arr[mid]);

            if (arr[mid] == target) {
                return mid; // Found it!
            }

            if (arr[mid] < target) {
                // The word we're looking for comes AFTER arr[mid] alphabetically
                System.out.println("'" + arr[mid] + "' is before '" + target + "' -> moving right");
                left = mid + 1;
            } else {
                // The word we're looking for comes BEFORE arr[mid] alphabetically
                System.out.println("'" + arr[mid] + "' is after '" + target + "' -> moving left");
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        // --- Real-World Example with Words (Sorted List) ---
        int[] myArray = { 1, 2, 3, 4, 5, 6, 7 };
        int myTarget = 6;

        int result = binarySearch(myArray, myTarget);

        System.out.println("--------------------");
        if (result != -1) {
            System.out.println("Value '" + myTarget + "' found at index " + result);
        } else {
            System.out.println("Target '" + myTarget + "' not found in array.");
        }
    }
}