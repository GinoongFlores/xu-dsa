
import java.util.Scanner;

public class Tuquib {
    public static int binarySearch(String[] array, String target) {
        int left = 0;
        int right = array.length - 1;

        System.out.println("Searching for: " + target);

        while (left <= right) {
            System.out.println("Left: " + left + ", Right: " + right);

            int mid = (left + right) / 2;
            System.out.println("Checking middle index: " + mid + ", Value: " + array[mid]);

            int compareResult = target.compareToIgnoreCase(array[mid]);

            if (compareResult == 0) {
                return mid;
            }

            if (compareResult > 0) {
                System.out.println("'" + array[mid] + "' is before '" + target + "' -> moving right");
                left = mid + 1;
            } else {
                System.out.println("'" + array[mid] + "' is after '" + target + "' <- moving left");
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] classList = { "Annie", "Arnie", "Billie", "Bobby", "Celine",
                "Charlie", "Deane", "Dirk", "Ellie", "Emmet", "Fanny", "Frisk" };

        System.out.print("pick a target from the array: ");
        String myTarget = scan.nextLine();

        int result = binarySearch(classList, myTarget);

        System.out.println("-----------------");
        if (result != -1) {
            System.out.println("Value '" + myTarget + "' found at index " + result);
        } else {
            System.out.println("Target '" + myTarget + "' not found in array.");
        }

    }

}
