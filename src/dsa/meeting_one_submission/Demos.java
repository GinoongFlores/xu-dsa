import java.util.Arrays;
import java.util.Scanner;

public class Demos {

    public static int binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        System.out.println("Seaching for: " + target);

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

        String[] myArray = { "Iron Sword", "Diamond Pickaxe", "Golden Apple", "Bow", "Arrow",
                "Shield", "Enchanted Book", "Flint and Steel", "Potion of Healing",
                "Fishing Rod", "Elytra", "Ender Pearl", "Netherite Ingot", "Torch",
                "Crafting Table", "Bread", "Redstone Dust", "Diamond Helmet",
                "Leather Boots", "Minecart" };

        System.out.println("The inventory: " + Arrays.toString(myArray));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the element you want to find in the inventory: ");
        String myTarget = scanner.nextLine();

        int result = binarySearch(myArray, myTarget);

        System.out.println("--------------------");
        if (result != -1) {
            System.out.println("Value '" + myTarget + "' found at index " + result);
        } else {
            System.out.println("Target '" + myTarget + "' not found in array.");
        }
    }
}