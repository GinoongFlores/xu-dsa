package dsa.bst;

class Node {
    String word;
    Node left, right;

    public Node(String item) {
        word = item;
        left = right = null;
    }
}

class Main {
    Node root;

    Main() {
        root = null;
    }

    // Insert a word
    Node insert(Node root, String word) {
        if (root == null)
            return new Node(word);

        if (word.compareTo(root.word) < 0)
            root.left = insert(root.left, word);
        else if (word.compareTo(root.word) > 0)
            root.right = insert(root.right, word);

        return root;
    }

    // Find minimum node
    Node minValue(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    // Delete a word
    Node delete(Node root, String word) {
        if (root == null)
            return root;

        if (word.compareTo(root.word) < 0)
            root.left = delete(root.left, word);
        else if (word.compareTo(root.word) > 0)
            root.right = delete(root.right, word);
        else {
            // One or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Two children
            root.word = minValue(root.right).word;
            root.right = delete(root.right, root.word);
        }
        return root;
    }

    // Inorder traversal (alphabetical order)
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.word + " ");
            inorder(root.right);
        }
    }

    // Search for a word
    Node search(Node root, String word) {
        if (root == null || root.word.equals(word))
            return root;

        if (word.compareTo(root.word) < 0)
            return search(root.left, word);

        return search(root.right, word);
    }

    // Wrapper methods for cleaner usage
    void insert(String word) {
        root = insert(root, word);
    }

    void delete(String word) {
        root = delete(root, word);
    }

    Node search(String word) {
        return search(root, word);
    }

    void printInOrder() {
        inorder(root);
    }

    public static void main(String[] args) {
        Main dict = new Main();

        System.out.println("DICTIONARY BST ACTIVITY");
        System.out.println("======================");
        System.out.println("Constructing a BST using the following words:");
        System.out.println();

        // Initial construction with fruit names
        String[] initial = { "Mango", "Apple", "Peach", "Banana", "Cherry", "Lemon", "Plum", "Pear", "Coconut" };
        System.out.println("Inserting initial words:");
        for (String word : initial) {
            System.out.println("  Inserting: " + word);
            dict.insert(word);
        }

        System.out.println("\nInitial Dictionary BST (inorder traversal - alphabetical order):");
        dict.printInOrder();
        System.out.println();
        System.out.println();

        // Insert new words
        System.out.println("---------------------------------------------------");
        System.out.println("INSERTING NEW WORDS:");
        String[] toInsert = { "Kiwi", "Papaya", "Blueberry" };
        for (String word : toInsert) {
            System.out.println("  Adding: " + word);
            dict.insert(word);
        }

        System.out.println("\nDictionary after insertions (alphabetical order):");
        dict.printInOrder();
        System.out.println();
        System.out.println();

        // Delete words
        System.out.println("---------------------------------------------------");
        System.out.println("DELETING WORDS:");
        String[] toDelete = { "Banana", "Peach", "Coconut" };
        for (String word : toDelete) {
            System.out.println("  Removing: " + word);
            dict.delete(word);
            System.out.println("  Dictionary after deleting " + word + ":");
            System.out.print("  ");
            dict.printInOrder();
            System.out.println();
            System.out.println();
        }

        System.out.println("---------------------------------------------------");
        System.out.println("FINAL DICTIONARY STATE:");
        System.out.println("Words remaining in alphabetical order:");
        dict.printInOrder();
        System.out.println();
        System.out.println();

        System.out.println("---------------------------------------------------");
        System.out.println("BST LEARNING NOTES:");
        System.out.println("• Words are automatically sorted in alphabetical order");
        System.out.println("• Inorder traversal gives us dictionary-like ordering");
        System.out.println("• Each operation maintains the BST property");
        System.out.println("• Perfect for implementing real dictionaries and spell-checkers!");
    }
}
