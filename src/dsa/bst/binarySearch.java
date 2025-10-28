package dsa.bst;

// Minimal, beginner-friendly binary search example
public class binarySearch {

    // Binary Search looks in a sorted array by repeatedly cutting the search space
    // in half.
    // Think of 'low' and 'high' as two fingers pointing to the current search
    // range.
    // We move one finger inwards based on how 'target' compares to the middle
    // value.
    // It stops when the range is empty (low > high) or when we find the target.
    // Time complexity: O(log n) because the range halves each step.

    // Repeat until the pointers 'left' and 'right' meet or cross each other
    public static int search(int[] arr, int target, int left, int right) {
        while (left <= right) {
            // Pick the middle index of the current range.
            // Using: left + (right - left) / 2 avoids potential overflow vs (left + right) / 2
            int mid = left + (right - left) / 2;

            // If the middle value is exactly what we want, return its index.
            if (arr[mid] == target)
                return mid;

            // If the middle value is LESS than target, the target can only be on the RIGHT
            // side.
            // So we move 'left' just past mid to narrow the search to the right half.
            if (arr[mid] < target)
                left = mid + 1;
            // Otherwise, the target is smaller than the middle value, so it must be on the
            // LEFT side.
            // We move 'right' just before mid to narrow the search to the left half.
            else
                right = mid - 1;
        }
        // If we exit the loop, the range is empty and the target is not in the array.
        return -1;
    }

    public static void main(String[] args) {
        // Our array MUST be sorted for binary search to work correctly.
        int[] arr = { 2, 3, 4, 7, 9, 10 };
        int n = arr.length; // number of elements
        int target = 7; // value we are searching for
    int left = 0; // start index of the array
    // 'right' should be the last valid index (n - 1), not 'n' (which is out of
    // bounds)
    int right = n - 1; // end index of the array

    // Run the search within [left, right]
    int index = search(arr, target, left, right);
        System.out.println(index); // Expected: 3 (since arr[3] == 7)
    }
}
