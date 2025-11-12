public class Inocian {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        System.out.println("Searching for: " + target);

        while (left <= right) {
            // Print the current state
            System.out.println("Left: " + left + ", Right: " + right);

            int mid = (left + right) / 2;
            System.out.println("Checking middle index: " + mid + ", Number: " + arr[mid]);

            if (arr[mid] == target) {
                return mid; // found it
            }

            if (arr[mid] < target) {
                // The brand we're looking for comes AFTER arr[mid] alphabetically
                System.out.println("'" + arr[mid] + "' is before '" + target + "' -> moving right");
                left = mid + 1;
            } else {
                // The brand we're looking for comes BEFORE arr[mid] alphabetically
                System.out.println("'" + arr[mid] + "' is after '" + target + "' -> moving left");
                right = mid - 1;
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] numbers = {
                3, 5, 8, 11, 15, 19, 25, 29, 34, 500
        };

        int target = 8;

        int result = binarySearch(numbers, target);

        System.out.println("--------------------");
        if (result != -1) {
            System.out.println("Number '" + target + "' found at index " + result);
        } else {
            System.out.println("Number '" + target + "' not found in the list.");
        }
    }
}