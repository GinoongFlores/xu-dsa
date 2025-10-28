package dsa.bst;

// Node class specifically for activityBST
class ActivityBSTNode {
    int key;
    ActivityBSTNode left, right;

    public ActivityBSTNode(int item) {
        key = item;
        left = right = null;
    }
}

class BST {
    ActivityBSTNode root;

    BST() {
        root = null;
    }

    // Insert a node
    ActivityBSTNode insert(ActivityBSTNode root, int key) {
        if (root == null) {
            root = new ActivityBSTNode(key);
            return root;
        }
        if (key < root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);
        return root;
    }

    // Find minimum node
    ActivityBSTNode minValue(ActivityBSTNode root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    // Delete a node
    ActivityBSTNode delete(ActivityBSTNode root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children
            root.key = minValue(root.right).key;
            root.right = delete(root.right, root.key);
        }
        return root;
    }

    // Inorder traversal
    void inorder(ActivityBSTNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        int[] initial = { 50, 30, 70, 20, 40, 60, 80, 75, 35 };
        for (int val : initial) {
            tree.root = tree.insert(tree.root, val);
        }

        System.out.println("Initial BST (inorder):");
        tree.inorder(tree.root);
        System.out.println();

        // Insert values
        int[] toInsert = { 65, 85, 25 };
        for (int val : toInsert) {
            tree.root = tree.insert(tree.root, val);
        }
        System.out.println("After Insertions (inorder):");
        tree.inorder(tree.root);
        System.out.println();

        // Delete values
        int[] toDelete = { 20, 70, 35 };
        for (int val : toDelete) {
            tree.root = tree.delete(tree.root, val);
            System.out.println("After deleting " + val + ":");
            tree.inorder(tree.root);
            System.out.println();
        }
    }
}
