public class Jimenez {
    public static void main(String[] args) {

        String[] icecreamFlavors = { "chocolate", "cookiesandcream", "mintchocolatechip", "strawberry", "vanilla" };
        String target = "mintchocolatechip";

        int resultIndex = binarySearch(icecreamFlavors, target);

        if (resultIndex == -1) {
            System.out.println("Flavor \"" + target + "\" not found in the list.");
        } else {
            System.out.println("Flavor \"" + target + "\" found at index " + resultIndex + ".");
        }
    }

    public static int binarySearch(String[] arr, String target) {
        // array lenght starting from low to high (Left & Right concept)
        int low = 0;
        int high = arr.length - 1;

        // checks the middle position between low and high
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // compares the middle item to the target
            int compare = arr[mid].compareTo(target);

            if (compare == 0) {
                return mid; // same and found, it returns the position
            } else if (compare < 0) {
                low = mid + 1; // if it comes after, it goes through the right side of the array
            } else {
                high = mid - 1; // if it comes before, it goes through the left side of the array
            }
        }

        return -1;
    }
}
