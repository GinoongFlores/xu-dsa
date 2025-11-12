import java.util.Scanner;

public class Yamut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = { 1, 5, 9, 13, 17, 21, 25, 29, 33 };

        System.out.print("Sorted List: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Enter a number to search for: ");
        int target = scanner.nextInt();

        int result = binarySearch(numbers, target);

        if (result == -1) {
            System.out.println("\nResult: " + target + " was NOT found in the list.");
        } else {
            System.out.println("\nResult: " + target + " was found at index " + result + ".");
        }

        scanner.close();
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int step = 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            System.out.println("\nStep " + step + ":");
            System.out.println("Left index: " + left + " (value = " + arr[left] + ")");
            System.out.println("Mid index: " + mid + " (value = " + arr[mid] + ")");
            System.out.println("Right index: " + right + " (value = " + arr[right] + ")");

            if (arr[mid] == target) {
                System.out.println("=> Target found! " + target + " == " + arr[mid]);
                return mid;
            }

            else if (arr[mid] > target) {
                System.out.println("=> Target is smaller than mid. Move RIGHT pointer left.");
                right = mid - 1;
            }

            else {
                System.out.println("=> Target is larger than mid. Move LEFT pointer right.");
                left = mid + 1;
            }

            step++;
        }

        return -1;
    }
}
