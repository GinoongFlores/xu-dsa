import java.util.Arrays;

public class Gamboa {

    public static int binarySearch(String[] data, String target) {
        int left = 0;
        int right = data.length - 1;

        System.out.println("\nSearching for: " + target);
        System.out.println("");

        while (left <= right) {
            int mid = (left + right) / 2;

            System.out.printf("left = %d (%s), mid = %d (%s), right = %d (%s)%n",
                    left, data[left], mid, data[mid], right, data[right]);

            int cmp = data[mid].compareToIgnoreCase(target);

            if (cmp == 0) {
                System.out.println("Target " + target + " found at index " + mid + "!");
                return mid;
            } else if (cmp < 0) {
                System.out.println("Target is greater than " + data[mid] + ", Move Right");
                left = mid + 1;
            } else {
                System.out.println("Target is less than " + data[mid] + ", Move Left");
                right = mid - 1;
            }
        }

        System.out.println("Target " + target + " is not found.");
        return -1;
    }

    public static void main(String[] args) {
        String[] data = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
        System.out.println("SOLAR SYSTEM");

        Arrays.sort(data, String.CASE_INSENSITIVE_ORDER);
        System.out.print("Planets (sorted): ");
        for (String planet : data) {
            System.out.print(planet + " ");
        }
        System.out.println();

        String target = "jupiter";

        int index = binarySearch(data, target);
        if (index >= 0) {
            System.out.println(target + " exists at index " + index + ".");
        } else {
            System.out.println(target + " not found in the solar system.");
        }
    }
}
