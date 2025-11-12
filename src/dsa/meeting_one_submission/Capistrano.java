import java.util.Scanner;

public class Capistrano {
    public static void main(String[] args) {
        // Sorted list of names
        String[] names = { "Anna", "Ben", "Carlos", "Diana", "Ella", "Francis", "Grace", "Hannah" };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name to search: ");
        String target = sc.nextLine();

        int left = 0;
        int right = names.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;

            // Print the left, mid, and right values at each step
            System.out.println("\nLeft: " + left + " (" + names[left] + ")");
            System.out.println("Mid: " + mid + " (" + names[mid] + ")");
            System.out.println("Right: " + right + " (" + names[right] + ")");

            int result = target.compareToIgnoreCase(names[mid]);

            if (result == 0) {
                System.out.println("\n✅ " + target + " found at index " + mid + "!");
                found = true;
                break;
            } else if (result < 0) {
                System.out.println(target + " comes before " + names[mid] + " → move left");
                right = mid - 1;
            } else {
                System.out.println(target + " comes after " + names[mid] + " → move right");
                left = mid + 1;
            }
        }

        if (!found) {
            System.out.println("\n❌ " + target + " not found in the list.");
        }

        sc.close();
    }
}