/**
 * Binary Search Tree Activity: Product Inventory Lookup
 *
 * REAL-WORLD CONTEXT:
 * A warehouse needs to quickly find products by their unique ID numbers.
 * Instead of checking every product one by one (slow!), we organize them
 * in a Binary Search Tree (BST) for fast O(log n) search.
 *
 * HOW BST WORKS:
 * - Smaller values go to the LEFT child
 * - Larger values go to the RIGHT child
 * - Start at root, compare, then go left or right
 * - Perfect for fast lookups in databases and inventory systems
 *
 * YOUR TASK:
 * Implement the methods below to make all test cases pass.
 */

class Node {
    int productId;
    Node left;
    Node right;
    
    Node(int id) {
        this.productId = id;
        this.left = null;
        this.right = null;
    }
}

public class Final_BSTStarter {
    private Node root;
    
    public Final_BSTStarter() {
        this.root = null;
    }
    
    /**
     * Inserts a product ID into the BST.
     * This method is already correctly implemented - it delegates to insertHelper().
     * 
     * @param productId The product ID to insert
     */
    public void insert(int productId) {
        // Already implemented: delegates to helper method for recursive insertion
        root = insertHelper(root, productId);
    }
    
    /**
     * Helper method for recursive insertion.
     * Used by: Test Case 1, Test Case 2, Test Case 3
     * 
     * TODO: Implement the recursive insertion logic
     * Hint: This is a recursive function with base case and recursive cases
     * 
     * Base case: If current node is null, create and return a new Node(productId)
     * 
     * Recursive cases:
     *   - If productId < node.productId, recursively insert into left subtree
     *   - If productId > node.productId, recursively insert into right subtree
     *   - If productId == node.productId, you can either skip (duplicate) or handle as needed
     * 
     * Example pattern:
     *   if (node == null) return new Node(productId);
     *   if (productId < node.productId) 
     *       node.left = insertHelper(node.left, productId);
     *   else if (productId > node.productId)
     *       node.right = insertHelper(node.right, productId);
     *   return node;
     */
    private Node insertHelper(Node node, int productId) {
        // TODO: Implement recursive insertion
        // Hint: Follow the pattern described in the Javadoc comment above
        // This is intentionally incorrect - replace with proper recursive insertion logic
        return null;
    }
    
    /**
     * Searches for a product ID in the BST.
     * This method is already correctly implemented - it delegates to searchHelper().
     * 
     * @param productId The product ID to search for
     * @return true if found, false otherwise
     */
    public boolean search(int productId) {
        // Already implemented: delegates to helper method for recursive search
        return searchHelper(root, productId);
    }
    
    /**
     * Helper method for recursive search.
     * Used by: Test Case 2, Test Case 3
     * 
     * TODO: Implement the recursive search logic
     * Hint: This is a recursive function with base cases and recursive cases
     * 
     * Base cases:
     *   - If node is null, return false (not found)
     *   - If productId == node.productId, return true (found!)
     * 
     * Recursive cases:
     *   - If productId < node.productId, search left subtree
     *   - If productId > node.productId, search right subtree
     * 
     * Example pattern:
     *   if (node == null) return false;
     *   if (productId == node.productId) return true;
     *   if (productId < node.productId) return searchHelper(node.left, productId);
     *   return searchHelper(node.right, productId);
     */
    private boolean searchHelper(Node node, int productId) {
        // TODO: Implement recursive search
        // Hint: Follow the pattern described in the Javadoc comment above
        // Note: You need to implement BOTH insertHelper() and searchHelper() correctly
        //       for all test cases to pass
        if (node == null) {
            // TODO: Replace this - should return false when node is null (item not found)
            return (productId == 99); // This is intentionally incorrect - replace with proper logic
        }
        // TODO: Replace this - should check if productId matches node.productId
        //       If not found, recursively search left or right subtree based on comparison
        return false; // This is intentionally incorrect - replace with proper recursive search
    }
    
    /**
     * Gets the root value (for testing purposes).
     * Used by: Test Case 1
     * This method is already correctly implemented.
     * 
     * @return The root product ID, or -1 if tree is empty
     */
    public int getRoot() {
        // Already implemented: returns root value or -1 if empty
        if (root == null) {
            return -1;
        }
        return root.productId;
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
        System.out.println("TEST CASE 1: Simple Insert (Easy)");
        System.out.println("=".repeat(50));
        
        Final_BSTStarter inventory = new Final_BSTStarter();
        
        System.out.println("Action: Insert product ID 50");
        inventory.insert(50);
        
        System.out.println("Action: Check root value");
        int rootValue = inventory.getRoot();
        
        System.out.println("Expected: 50");
        System.out.println("Got: " + rootValue);
        
        boolean passed;
        if (rootValue == 50) {
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
        System.out.println("TEST CASE 2: Search for Existing Item (Moderate)");
        System.out.println("=".repeat(50));
        
        Final_BSTStarter inventory = new Final_BSTStarter();
        
        System.out.println("Action: Insert product IDs: 50, 30, 70");
        inventory.insert(50);
        inventory.insert(30);
        inventory.insert(70);
        
        System.out.println("Action: Search for product ID 30");
        boolean found = inventory.search(30);
        
        System.out.println("Expected: true (Found)");
        System.out.println("Got: " + found);
        
        boolean passed;
        if (found) {
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
        System.out.println("TEST CASE 3: Search for Non-Existent Item (Harder)");
        System.out.println("=".repeat(50));
        
        Final_BSTStarter inventory = new Final_BSTStarter();
        
        System.out.println("Action: Insert product IDs: 50, 30, 70");
        inventory.insert(50);
        inventory.insert(30);
        inventory.insert(70);
        
        System.out.println("Action: Search for product ID 99 (not in tree)");
        boolean found = inventory.search(99);
        
        System.out.println("Expected: false (Not Found)");
        System.out.println("Got: " + found);
        
        boolean passed;
        if (!found) {
            System.out.println("[PASS] - Test Case 3 (correctly handled not found)");
            passed = true;
        } else {
            System.out.println("[FAIL] - Test Case 3 (should return false for non-existent item)");
            passed = false;
        }
        System.out.println();
        return passed;
    }
    
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("BST TEST CASES - Product Inventory Lookup");
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

1. Insert Helper: [Your explanation here]
2. Search Helper: [Your explanation here]

*/

