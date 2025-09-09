package dsa.bigO;

public class o1 {

    /*
     *
     *
     * ! Understanding O(1) Time Complexity
     * ? Key Characteristics:
     * Constant Time: The time taken does not depend on the input size
     * Predictable Performance: Always takes the same amount of time regardless of
     * data size
     * Direct Operations: No loops or recursion that depend on input size
     *
     * Examples:
     * ? Accessing an array element by index
     * ? Performing a simple arithmetic operation
     * ? Inserting or deleting an element in a stack or queue (if not full/empty)
     */

    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

        System.out.println("Demonstrating O(1) Time Complexity:");
        System.out.println("----------------------------------");

        // Example 1: Accessing array element by index - O(1)
        System.out.println("Example 1: Array access by index");
        long startTime = System.nanoTime();
        int value = getElementAtIndex(numbers, 3);
        long endTime = System.nanoTime();

        System.out.println("Element at index 3: " + value);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds\n");

        // Example 2: Check if number is even or odd - O(1)
        System.out.println("Example 2: Check if number is even");
        startTime = System.nanoTime();
        boolean isEven = isEven(42);
        endTime = System.nanoTime();

        System.out.println("Is 42 even? " + isEven);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds\n");

        // Example 3: Stack operations (push/pop) - O(1)
        System.out.println("Example 3: Stack operations");
        Stack stack = new Stack(5);

        startTime = System.nanoTime();
        stack.push(10);
        endTime = System.nanoTime();
        System.out.println("Push operation time: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        int popped = stack.pop();
        endTime = System.nanoTime();
        System.out.println("Pop operation time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("Popped element: " + popped);
    }

    // O(1) - Direct array access
    public static int getElementAtIndex(int[] array, int index) {
        return array[index]; // Constant time - direct memory access
    }

    // O(1) - Simple arithmetic operation
    public static boolean isEven(int number) {
        return number % 2 == 0; // Constant time - single calculation
    }

    // Simple stack implementation with O(1) push and pop operations
    static class Stack {
        private int[] array;
        private int top;
        private int capacity;

        public Stack(int size) {
            array = new int[size];
            capacity = size;
            top = -1;
        }

        // O(1) - Push operation
        public void push(int value) {
            if (top < capacity - 1) {
                array[++top] = value;
            }
        }

        // O(1) - Pop operation
        public int pop() {
            if (top >= 0) {
                return array[top--];
            }
            return -1; // Stack is empty
        }
    }
}
