import java.util.Scanner;

class Gador {
    static int binarySearch(int arr[], int nLeft, int nRight, int nTarget) {
        int nMid;

        while (nLeft <= nRight) {
            nMid = (nLeft + nRight) / 2;

            System.out.println("Left: " + nLeft + " Right: " + nRight);
            System.out.println("Checking middle index: " + nMid + " Value: " + arr[nMid]);

            if (arr[nMid] == nTarget)
                return nMid;
            else if (arr[nMid] > nTarget) {
                nRight = nMid - 1;
                System.out.println(arr[nMid] + " is after " + nTarget + " -> moving left");
            } else {
                nLeft = nMid + 1;
                System.out.println(arr[nMid] + " is before " + nTarget + " -> moving right");
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int arr[];

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int s = 0;
        if (sc.hasNextInt()) {
            s = sc.nextInt();
        }

        arr = new int[s];

        System.out.println(
                "Enter the values of the array: ");
        for (int i = 0; i < s; i++) {
            if (sc.hasNextInt()) {
                arr[i] = sc.nextInt();
            }
        }

        System.out.println(
                "The values of the array are: ");
        for (int i = 0; i < s; i++) {

            System.out.print(arr[i] + " ");
        }

        System.out.println();

        int nRight, nLeft, nLength, nTarget, nAns;

        nLength = arr.length;

        nLeft = 0;

        nRight = nLength - 1;

        System.out.println("Enter target value: ");
        nTarget = sc.nextInt();

        System.out.println("Searching for: " + nTarget);

        nAns = binarySearch(arr, nLeft, nRight, nTarget);

        if (nAns == -1)
            System.out.print("Number could not be found in the array");
        else
            System.out.println("Value " + nTarget + " could be found at index " + nAns);
    }
}