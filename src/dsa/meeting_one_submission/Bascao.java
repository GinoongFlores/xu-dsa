
import java.util.Scanner;

class Bascao {

	public static int binarySearch(String[] arr, String target) {
		int left = 0;
		int right = arr.length - 1;

		System.out.println("Searching for: " + target);

		while (left <= right) {
			System.out.println("Left: " + left + "Right: " + right);

			int mid = (left + right) / 2;
			System.out.println("Middle Index: " + mid + ", Value: " + arr[mid]);

			int compareResult = target.compareToIgnoreCase(arr[mid]);

			if (compareResult == 0) {
				return mid;
			}

			if (compareResult > 0) {
				System.out.println(" ' " + target + "' is before '" + target + "' -> moving right");
				left = mid + 1;

			} else {
				System.out.println(" ' " + arr[mid] + "' is after '" + target + "' -> moving left");
				right = mid - 1;

			}

		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("List of Brands:");
		String[] myArray = { "Ford", "Honda", "Lexus", "Mitsubishi", "Nissan", "Toyota" };
		System.out.println("Ford, Honda, Lexus, Mitsubishi, Nissan, Toyota");
		System.out.println("Search for: ");
		Scanner scan = new Scanner(System.in);
		String myTarget = scan.next();

		int result = binarySearch(myArray, myTarget);

		if (result != -1) {
			System.out.println("Value: " + myTarget + " found at index " + result);

		} else {
			System.out.println("Target " + myTarget + "not found in array");

		}
	}
}
