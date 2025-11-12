
public class Roa {

    // method - for the binary search
    public static int bSearch(String[] array, String target) {

        // index
        int left = 0;
        int right = array.length - 1;

        System.out.println("\nTarget: " + target);

        while (left <= right) {
            System.out.println("\nLeft: " + left + "\nRight: " + right);

            // formula
            int mid = (left + right) / 2;

            System.out.println("\nItem: " + array[mid] + "\nMiddle Index: " + mid);

            // checks the target's position alphabetically
            int compare = target.compareToIgnoreCase(array[mid]);
            if (compare == 0) {
                return mid;
            }
            if (compare > 0) {
                System.out.println("\n" + array[mid] + " is before " + target + ". | mid + 1");
                left = mid + 1;
            } else {
                System.out.println("\n" + array[mid] + " is after " + target + ". | mid - 1");
                right = mid - 1;
            }
        }

        // target not found
        return -1;
    }

    public static void main(String[] args) {
        String[] bList = { "Batteries", "Dehumidifier", "Flower Vase", "Laundry Basket", "Lint Roller" };
        String bTarget = "Laundry Basket";

        System.out.println("\n'To Buy' List: " + java.util.Arrays.toString(bList));
        System.out.println("\n--------------------");

        int result = bSearch(bList, bTarget);

        System.out.println("\n--------------------");
        if (result != -1) {
            System.out.println("\n" + bTarget + " is item " + result);
        } else {
            System.out.println("\n" + bTarget + " is not found on the list!");
        }
    }
}
