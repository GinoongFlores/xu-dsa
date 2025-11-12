
import java.util.Scanner;

public class Bagotchay {

    public static int binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            System.out.println("Left: " + left + ", Right: " + right);

            int mid = (left + right) / 2;
            System.out.println("Middle: " + mid + ", Value: " + arr[mid]);
            System.out.println("");

            int compareResult = target.compareToIgnoreCase(arr[mid]);

            if (compareResult == 0) {
                return mid;
            } else if (compareResult > 0) {
                System.out.println("'" + arr[mid] + "' is before '" + target + "' -> right");
                System.out.println("");
                left = mid + 1;
            } else {
                System.out.println("'" + arr[mid] + "' is after '" + target + "' -> left");
                System.out.println("");
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] seventeen = { "hoshi", "jeonghan", "jisoo", "jun", "seungcheol", "wonwoo", "woozi" };

        Scanner input = new Scanner(System.in);
        System.out.println("Seventeen Members: hoshi, jeonghan, jisoo, jun, seungcheol, wonwoo, woozi");
        System.out.print("Searching member: ");
        String member = input.nextLine();

        System.out.println("");
        System.out.println("Formula: Mid = left + right / 2");
        System.out.println("");

        int result = binarySearch(seventeen, member);

        if (result != -1) {
            System.out.println("Member '" + member + "' found at array " + result);
        } else {
            System.out.println("Member '" + member + "' not found in array.");
        }

        input.close();
    }
}
