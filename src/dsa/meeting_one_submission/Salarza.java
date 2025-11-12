public class Salarza {
    public static int binarySearch(char[] arr, char key) {

        System.out.print("Array: ");
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println("\nSearching for -> " + key);
        System.out.println("===============================");

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            System.out.println("Search Window:");
            for (int i = 0; i < arr.length; i++) {
                if (i == left)
                    System.out.print("L");
                else if (i == mid)
                    System.out.print("M");
                else if (i == right)
                    System.out.print("R");
                else
                    System.out.print(" ");
                System.out.print(" ");

            }
            System.out.println("");
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.println("\nLeft: " + left + "[" + arr[left] + "]");
            System.out.println("Mid:  " + mid + "[" + arr[mid] + "]");
            System.out.println("Right:" + right + "[" + arr[right] + "]");

            if (arr[mid] == key)
                return mid;

            if (arr[mid] < key) {
                System.out.println("Moving right -> " + arr[mid] + " < " + key);
                left = mid + 1;
            } else {
                System.out.println("Moving left <- " + arr[mid] + " > " + key);
                right = mid - 1;
            }
            System.out.println("===============================");
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
        char target = 'f';

        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("Found at position: " + result);
        } else {
            System.out.println("Not found in array");
        }
    }
}