public class Peruelo {

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

        String[] myArray = {"A Game of Thrones", "Coraline", "Dune", "Frankenstein", "Heartstopper", "It", "Jurassic Park",
        "Little Women", "Me Before You", "Oliver Twist", "Percy Jackson and the Olympians: The Lightning Thief",
        "Ready Player One", "Song of Achilles", "To Kill a Mockingbird"};
        String myTarget = "Me Before You";

        int result = binarySearch(myArray, myTarget);

        System.out.println("--------------------");
        if (result != -1) {
            System.out.println("Value '" + myTarget + "' found at index " + result);
        } else {
            System.out.println("Target '" + myTarget + "' not found in array.");
        }
    }
}