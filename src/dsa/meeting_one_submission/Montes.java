public class Montes {

    public static int binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        System.out.println("Searching for: " + target);

        while (left <= right) {
            System.out.println("Left: " + left + ", Right: " + right);

            int mid = (left + right) / 2;
            System.out.println("Checking middle index: " + mid + ", Value: " + arr[mid]);

            int compareResult = target.compareToIgnoreCase(arr[mid]);

            if (compareResult == 0) {
                return mid;
            }

            if (compareResult > 0) {
                System.out.println("'" + arr[mid] + "' is before '" + target + "' -> moving right");
                left = mid + 1;
            } else {
                System.out.println("'" + arr[mid] + "' is after '" + target + "' -> moving left");
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] sortedArray = {
                "Art", "Chemistry", "English", "History",
                "Math", "Music", "Physical Education", "Science", "Social Studies"
        };
        String target = "Science";

        System.out.println("Sorted array: " + java.util.Arrays.toString(sortedArray));
        System.out.println("--------------------");

        int result = binarySearch(sortedArray, target);

        System.out.println("--------------------");
        if (result != -1) {
            System.out.println("Value '" + target + "' found at index " + result);
        } else {
            System.out.println("Target '" + target + "' not found in array.");
        }
    }
}
