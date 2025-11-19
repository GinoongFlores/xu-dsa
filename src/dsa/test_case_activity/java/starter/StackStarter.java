import java.util.ArrayList;

/**
 * Stack Activity: Text Editor Undo Feature
 *
 * REAL-WORLD CONTEXT:
 * Imagine you're typing in a text editor. Every time you type a word,
 * it gets saved to your action history. When you press Undo (Ctrl+Z),
 * the last word you typed disappears. This is exactly how a Stack works!
 *
 * HOW STACKS WORK:
 * - LIFO (Last In, First Out): The last word typed is the first one removed
 * - Push: Adds a word to the top of the stack
 * - Pop: Removes and returns the top word (undo action)
 * - Peek: Shows the top word without removing it
 *
 * YOUR TASK:
 * Implement the methods below to make all test cases pass.
 * Use an ArrayList<String> to store the stack elements.
 */

public class StackStarter {
    // TODO: Add your stack data structure here
    // Hint: Use ArrayList<String> to store the words
    // Example: private ArrayList<String> stack;
    
    // TODO: Initialize the stack in a constructor
    public StackStarter() {
        // Your code here
    }
    
    /**
     * Adds a word to the top of the stack.
     * Used by: Test Case 1, Test Case 2
     * 
     * @param word The word to add to the stack
     */
    public void push(String word) {
        // TODO: Add the word to your stack
        // Hint: Use the add() method of ArrayList
    }
    
    /**
     * Removes and returns the top word from the stack (undo action).
     * Used by: Test Case 2, Test Case 3
     * 
     * @return The word that was removed, or null if stack is empty
     */
    public String pop() {
        // TODO: Remove and return the last word added
        // Hint: Check if stack is empty first, then remove the last element
        // Use isEmpty() to check, and remove(size() - 1) to get the last element
        return null; // Replace this
    }
    
    /**
     * Returns the top word without removing it.
     * Used by: Test Case 1, Test Case 2
     * 
     * @return The top word, or null if stack is empty
     */
    public String peek() {
        // TODO: Return the last word without removing it
        // Hint: Use get(size() - 1) to access the last element
        return null; // Replace this
    }
    
    /**
     * Checks if the stack is empty.
     * Used by: Test Case 3 (indirectly through pop())
     * 
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        // TODO: Check if the stack has no elements
        // Hint: Use isEmpty() method or check if size() == 0
        return true; // Replace this
    }
    
    // ============================================
    // TEST CASES - Already implemented below
    // Just run this file to test your implementation
    // 
    //  IMPORTANT: DO NOT MODIFY OR TOUCH THE TEST CASE CODE BELOW 
    // The test cases are already complete and should remain unchanged.
    // Only modify the TODO sections in the class methods above.
    // ============================================
    
    public static boolean testCase1() {
        System.out.println("=".repeat(50));
        System.out.println("TEST CASE 1: Simple Push and Peek (Easy)");
        System.out.println("=".repeat(50));
        
        StackStarter editor = new StackStarter();
        
        System.out.println("Action: Push 'Hello'");
        editor.push("Hello");
        
        System.out.println("Action: Peek at the stack");
        String result = editor.peek();
        
        System.out.println("Expected: Hello");
        System.out.println("Got: " + result);
        
        boolean passed;
        if (result != null && result.equals("Hello")) {
            System.out.println("[PASS] - Test Case 1");
            passed = true;
        } else {
            System.out.println("[FAIL] - Test Case 1");
            passed = false;
        }
        System.out.println();
        return passed;
    }
    
    public static boolean testCase2() {
        System.out.println("=".repeat(50));
        System.out.println("TEST CASE 2: Basic Undo Operation (Moderate)");
        System.out.println("=".repeat(50));
        
        StackStarter editor = new StackStarter();
        
        System.out.println("Action: Push 'Hello'");
        editor.push("Hello");
        
        System.out.println("Action: Push 'World'");
        editor.push("World");
        
        System.out.println("Action: Pop (undo last action)");
        String popped = editor.pop();
        System.out.println("Popped: " + popped);
        
        System.out.println("Action: Peek at the stack");
        String result = editor.peek();
        
        System.out.println("Expected: Hello (World was removed)");
        System.out.println("Got: " + result);
        
        boolean passed;
        if (result != null && result.equals("Hello")) {
            System.out.println("[PASS] - Test Case 2");
            passed = true;
        } else {
            System.out.println("[FAIL] - Test Case 2");
            passed = false;
        }
        System.out.println();
        return passed;
    }
    
    public static boolean testCase3() {
        System.out.println("=".repeat(50));
        System.out.println("TEST CASE 3: Empty Stack Edge Case (Harder)");
        System.out.println("=".repeat(50));
        
        StackStarter editor = new StackStarter();
        
        System.out.println("Action: Try to pop from empty stack");
        String result = editor.pop();
        
        System.out.println("Expected: null or 'Nothing to undo'");
        System.out.println("Got: " + result);
        
        boolean passed;
        if (result == null) {
            System.out.println("[PASS] - Test Case 3 (handled empty stack correctly)");
            passed = true;
        } else {
            System.out.println("[FAIL] - Test Case 3 (should return null for empty stack)");
            passed = false;
        }
        System.out.println();
        return passed;
    }
    
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("STACK TEST CASES - Text Editor Undo Feature");
        System.out.println("=".repeat(50) + "\n");
        
        boolean result1 = testCase1();
        boolean result2 = testCase2();
        boolean result3 = testCase3();
        
        System.out.println("=".repeat(50));
        System.out.println("TEST SUMMARY");
        System.out.println("=".repeat(50));
        System.out.println("Test Case 1: " + (result1 ? "[PASS]" : "[FAIL]"));
        System.out.println("Test Case 2: " + (result2 ? "[PASS]" : "[FAIL]"));
        System.out.println("Test Case 3: " + (result3 ? "[PASS]" : "[FAIL]"));
        System.out.println("=".repeat(50));
        
        if (result1 && result2 && result3) {
            System.out.println("All test cases PASSED!");
        } else {
            System.out.println("Some test cases FAILED. Complete the TODO sections to fix them.");
        }
        System.out.println("=".repeat(50));
    }
}

/*
============================================
TODO: EXPLANATION
============================================

Write a brief explanation of how you solved the problem.
What was your thought process? What data structures did you use and why?

1. Push: [Your explanation here]
2. Pop: [Your explanation here]
3. Peek: [Your explanation here]

*/

