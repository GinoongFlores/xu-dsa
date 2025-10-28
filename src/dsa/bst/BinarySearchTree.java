package dsa.bst;

// Define a BSTNode class for BST (renamed to avoid conflicts)
class BSTNode {
    int value;
    BSTNode left, right;

    public BSTNode(int item) {
        value = item;
        left = right = null;
    }
}

// BST class with search method
class BinarySearchTree {
    BSTNode root;

    /**
     * Search method with step-by-step explanation
     *
     * @param root The root BSTNode of the tree/subtree
     * @param key  The value to search for
     * @param step Counter to track the current search step
     * @return The BSTNode containing the key, or null if not found
     */
    BSTNode searchWithSteps(BSTNode root, int key, int step) {
        // Base case: root is null or key is present at root
        if (root == null) {
            System.out.println("Step " + step + ": Reached null BSTNode. Value " + key + " not found.");
            return null;
        }

        // Print the current step information
        System.out.println("Step " + step + ": Checking BSTNode with value " + root.value);

        // Check if the current BSTNode contains the key
        if (root.value == key) {
            System.out.println("Step " + step + ": Found value " + key + " at current BSTNode!");
            return root;
        }

        // If key is smaller, search left subtree
        if (key < root.value) {
            System.out.println("Step " + step + ": " + key + " < " + root.value + ", searching LEFT subtree");
            return searchWithSteps(root.left, key, step + 1);
        }

        // Otherwise, search right subtree
        System.out.println("Step " + step + ": " + key + " > " + root.value + ", searching RIGHT subtree");
        return searchWithSteps(root.right, key, step + 1);
    }

    // Original search method (for backwards compatibility)
    BSTNode search(BSTNode root, int key) {
        return searchWithSteps(root, key, 1);
    }

    /**
     * Insert a new value into the BST with step-by-step explanation
     *
     * @param root The root BSTNode of the tree/subtree
     * @param key  The value to insert
     * @param step Counter to track the current insertion step
     * @return The root BSTNode (after insertion)
     */
    BSTNode insertWithSteps(BSTNode root, int key, int step) {
        // Base case: If tree is empty or reached a leaf BSTNode
        if (root == null) {
            System.out.println("Step " + step + ": Found insertion point! Creating new BSTNode with value " + key);
            return new BSTNode(key);
        }

        // Print the current step information
        System.out.println("Step " + step + ": Checking BSTNode with value " + root.value);

        // If key already exists, we don't insert duplicates in BST
        if (root.value == key) {
            System.out.println("Step " + step + ": Value " + key + " already exists in the tree. No insertion needed.");
            return root;
        }

        // If key is smaller, insert in left subtree
        if (key < root.value) {
            System.out.println("Step " + step + ": " + key + " < " + root.value + ", moving to LEFT subtree");
            root.left = insertWithSteps(root.left, key, step + 1);
        }
        // Otherwise, insert in right subtree
        else {
            System.out.println("Step " + step + ": " + key + " > " + root.value + ", moving to RIGHT subtree");
            root.right = insertWithSteps(root.right, key, step + 1);
        }

        return root;
    }

    // Original insert method
    void insert(int key) {
        root = insertWithSteps(root, key, 1);
    }

    /**
     * Delete a value from the BST with step-by-step explanation
     *
     * @param root The root BSTNode of the tree/subtree
     * @param key  The value to delete
     * @param step Counter to track the current deletion step
     * @return The root BSTNode (after deletion)
     */
    BSTNode deleteWithSteps(BSTNode root, int key, int step) {
        // Base case: If tree is empty
        if (root == null) {
            System.out.println("Step " + step + ": Reached null BSTNode. Value " + key + " not found for deletion.");
            return null;
        }

        // Print the current step information
        System.out.println("Step " + step + ": Checking BSTNode with value " + root.value);

        // If key is smaller, look in left subtree
        if (key < root.value) {
            System.out.println("Step " + step + ": " + key + " < " + root.value + ", moving to LEFT subtree");
            root.left = deleteWithSteps(root.left, key, step + 1);
        }
        // If key is larger, look in right subtree
        else if (key > root.value) {
            System.out.println("Step " + step + ": " + key + " > " + root.value + ", moving to RIGHT subtree");
            root.right = deleteWithSteps(root.right, key, step + 1);
        }
        // BSTNode with matching key found - this is the BSTNode to delete
        else {
            System.out.println("Step " + step + ": Found BSTNode to delete (value " + key + ")");

            // CASE 1: BSTNode has no children or only one child
            if (root.left == null) {
                System.out.println("Step " + step + ": BSTNode has no left child. Replacing with right child.");
                return root.right;
            } else if (root.right == null) {
                System.out.println("Step " + step + ": BSTNode has no right child. Replacing with left child.");
                return root.left;
            }

            // CASE 2: BSTNode has two children
            // Find the inorder successor (smallest value in right subtree)
            System.out.println(
                    "Step " + step
                            + ": BSTNode has two children. Finding inorder successor (smallest in right subtree)");

            // Find the smallest value in the right subtree (inorder successor)
            BSTNode successor = root.right;
            int successorStep = step + 1;
            System.out.println("Step " + successorStep + ": Looking for smallest value in right subtree, starting at "
                    + successor.value);

            while (successor.left != null) {
                successorStep++;
                successor = successor.left;
                System.out.println("Step " + successorStep + ": Moving to left child " + successor.value);
            }

            System.out.println("Step " + (successorStep + 1) + ": Found inorder successor: " + successor.value);

            // Replace the value of the BSTNode to be deleted with the successor value
            System.out
                    .println("Step " + (successorStep + 2) + ": Replacing " + root.value + " with " + successor.value);
            root.value = successor.value;

            // Delete the successor (which is now a duplicate)
            System.out.println(
                    "Step " + (successorStep + 3)
                            + ": Now deleting the duplicate successor BSTNode from right subtree");
            root.right = deleteWithSteps(root.right, successor.value, successorStep + 4);
        }

        return root;
    }

    // Original delete method
    void delete(int key) {
        root = deleteWithSteps(root, key, 1);
    }

    /**
     * Updates the tree visualization after changes
     */
    void updateTreeVisualization(String action, int value) {
        System.out.println("\nBinary Search Tree Structure (after " + action + " " + value + "):");
        // This is a simplified visual representation - in a real implementation
        // we would traverse the tree and print the actual structure
    }

    /**
     * Utility method to print the tree structure
     * This helps students visualize the tree
     */
    void printTree() {
        System.out.println("\nBinary Search Tree Structure:");
        System.out.println("---------------------------");
        System.out.println("          45           ");
        System.out.println("        /     \\       ");
        System.out.println("      15        79     ");
        System.out.println("     /  \\      / \\   ");
        System.out.println("   10    20   55   90  ");
        System.out.println("     \\      /         ");
        System.out.println("      12   50          ");
        System.out.println("---------------------------\n");
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Build tree
        tree.root = new BSTNode(45);
        tree.root.left = new BSTNode(15);
        tree.root.right = new BSTNode(79);
        tree.root.left.left = new BSTNode(10);
        tree.root.left.right = new BSTNode(20);
        tree.root.left.left.right = new BSTNode(12);
        tree.root.right.left = new BSTNode(55);
        tree.root.right.left.left = new BSTNode(50);
        tree.root.right.right = new BSTNode(90);

        // Print the tree structure for visualization
        tree.printTree();

        // Search for values with step-by-step explanation
        System.out.println("1. SEARCHING FOR VALUE 20:");
        System.out.println("=====================");
        BSTNode result1 = tree.search(tree.root, 20);
        System.out.println(
                result1 != null ? "RESULT: Value 20 found in the BST!" : "RESULT: Value 20 not found in the BST.");

        // Add a second search to demonstrate a different path
        System.out.println("\n2. SEARCHING FOR VALUE 50:");
        System.out.println("=====================");
        BSTNode result2 = tree.search(tree.root, 50);
        System.out.println(
                result2 != null ? "RESULT: Value 50 found in the BST!" : "RESULT: Value 50 not found in the BST.");

        // Add a search for a value not in the tree
        System.out.println("\n3. SEARCHING FOR VALUE 30:");
        System.out.println("=====================");
        BSTNode result3 = tree.search(tree.root, 30);
        System.out.println(
                result3 != null ? "RESULT: Value 30 found in the BST!" : "RESULT: Value 30 not found in the BST.");

        // INSERT EXAMPLE - insert value 60
        System.out.println("\n4. INSERTING VALUE 60:");
        System.out.println("=====================");
        tree.insert(60);
        System.out.println("RESULT: Value 60 inserted into the BST!");
        tree.updateTreeVisualization("inserting", 60);
        System.out.println("          45           ");
        System.out.println("        /     \\       ");
        System.out.println("      15        79     ");
        System.out.println("     /  \\      / \\   ");
        System.out.println("   10    20   55   90  ");
        System.out.println("     \\      /  \\     ");
        System.out.println("      12   50   60     ");

        // DELETE EXAMPLE - delete value 90
        System.out.println("\n5. DELETING VALUE 90:");
        System.out.println("=====================");
        tree.delete(90);
        System.out.println("RESULT: Value 90 deleted from the BST!");
        tree.updateTreeVisualization("deleting", 90);
        System.out.println("          45           ");
        System.out.println("        /     \\       ");
        System.out.println("      15        79     ");
        System.out.println("     /  \\      /      ");
        System.out.println("   10    20   55       ");
        System.out.println("     \\      /  \\     ");
        System.out.println("      12   50   60     ");
    }
}
