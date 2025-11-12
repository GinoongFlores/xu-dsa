
import java.util.Scanner;

class Sample {

    public static int binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        System.out.println("Searching for: " + target);

        while (left <= right) {
            System.out.println("Left: " + left + "Right: " + right);

            int mid = (left + right) / 2;
            System.out.println("Middle Index: " + mid + ", Value: " + arr[mid]);

            int compareResult = target.compareToIgnoreCase(arr[mid]);

            // Case 1: Target is the same as the middle element, we found it!
            if (compareResult == 0) {
                return mid;
            }
            // Case 2: Target is greater than the middle element, search the right half
            else if (compareResult > 0) {
                System.out.println(" ' " + target + "' is after (greater) '" + arr[mid] + "' -> moving left pointer");
                left = mid + 1;
            }
            // Case 3: Target is less than the middle element, search the left half
            else {
                System.out.println(" ' " + target + "' is before (less) '" + arr[mid] + "' -> moving right pointer");
                right = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("List of Brands:");
        String[] myArray = { "Ford", "Honda", "Lexus", "Mitsubishi", "Nissan", "Toyota" };
        System.out.println("Ford, Honda, Lexus, Mitsubishi, Nissan, Toyota");
        System.out.println("Search for: ");
        Scanner scan = new Scanner(System.in);
        String myTarget = scan.next();
        scan.close();

        int result = binarySearch(myArray, myTarget);

        if (result != -1) {
            System.out.println("Value: " + myTarget + " found at index " + result);

        } else {
            System.out.println("Target " + myTarget + "not found in array");

        }
    }
}
