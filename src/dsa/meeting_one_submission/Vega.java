import java.util.Scanner;

class Vega {
    public static void main(String[] args) {
        int[] A = { 27, 40, 48, 54, 62, 68, 94 }; // the sorted array

        // print array
        System.out.println();
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();

        // initial left and right indexes
        int left = 0;
        int right = A.length - 1;

        int target = 0;
        int mid = 0;
        double dmid = 0;

        // Gets input for target value
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your target value: ");
        target = s.nextInt();
        System.out.println("Target: " + target);

        while (A[mid] != target) {
            // prints items from left to right index
            System.out.println();
            for (int i = left; left <= i && i <= right; i++) {
                System.out.print(A[i] + " ");
            }
            System.out.println();

            // calculates mid index and stores in double var
            dmid = Math.floor((left + right) / 2);
            // converts double to int value
            mid = (int) dmid;

            // prints the left, right, and mid index and their values
            System.out.println("left: A[" + left + "] = " + A[left]);
            System.out.println("middle: A[" + mid + "] = " + A[mid]);
            System.out.println("right: A[" + right + "] = " + A[right]);

            // finds the target
            if (A[mid] == target) {
                System.out.println("Target value, " + target + ", found in index " + mid);
            }
            // if target is not found
            else if (left == right & A[mid] != target) {
                System.out.println("The target value does not exist in the array.");
                return;
            }
            // if target is greater than A[mid]
            else if (A[mid] < target) {
                left = mid + 1;
            }
            // if target is lesser than A[mid]
            else if (A[mid] > target) {
                right = mid - 1;
            }

        }
    }
}