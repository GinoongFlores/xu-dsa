"""
Binary Search Tree Implementation with Step-by-Step Explanations

This module implements a Binary Search Tree (BST) with detailed step-by-step
explanations for search, insert, and delete operations to help understand
how BST operations work and why they have O(log n) complexity.
"""

# Define a Node class for BST
class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BinarySearchTree:
    def __init__(self):
        self.root = None

    def search_with_steps(self, root, key, step=1):
        """
        Search for a key in the BST with step-by-step explanation

        Args:
            root: The current node being examined
            key: The value to search for
            step: Current step number (for tracking)

        Returns:
            The node containing the key, or None if not found
        """
        # Base case: root is None or key is present at root
        if root is None:
            print(f"Step {step}: Reached null node. Value {key} not found.")
            return None

        # Print current step information
        print(f"Step {step}: Checking node with value {root.value}")

        # Check if current node contains the key
        if root.value == key:
            print(f"Step {step}: Found value {key} at current node!")
            return root

        # If key is smaller, search left subtree
        if key < root.value:
            print(f"Step {step}: {key} < {root.value}, searching LEFT subtree")
            return self.search_with_steps(root.left, key, step + 1)

        # Otherwise, search right subtree
        print(f"Step {step}: {key} > {root.value}, searching RIGHT subtree")
        return self.search_with_steps(root.right, key, step + 1)

    def search(self, key):
        """Wrapper for search_with_steps starting at root"""
        return self.search_with_steps(self.root, key)

    def insert_with_steps(self, root, key, step=1):
        """
        Insert a new value into the BST with step-by-step explanation

        Args:
            root: The current node being examined
            key: The value to insert
            step: Current step number (for tracking)

        Returns:
            The node at this position (after insertion)
        """
        # Base case: If tree is empty or reached a leaf node
        if root is None:
            print(f"Step {step}: Found insertion point! Creating new node with value {key}")
            return Node(key)

        # Print current step information
        print(f"Step {step}: Checking node with value {root.value}")

        # If key already exists, we don't insert duplicates in BST
        if root.value == key:
            print(f"Step {step}: Value {key} already exists in the tree. No insertion needed.")
            return root

        # If key is smaller, insert in left subtree
        if key < root.value:
            print(f"Step {step}: {key} < {root.value}, moving to LEFT subtree")
            root.left = self.insert_with_steps(root.left, key, step + 1)
        # Otherwise, insert in right subtree
        else:
            print(f"Step {step}: {key} > {root.value}, moving to RIGHT subtree")
            root.right = self.insert_with_steps(root.right, key, step + 1)

        return root

    def insert(self, key):
        """Wrapper for insert_with_steps starting at root"""
        self.root = self.insert_with_steps(self.root, key)

    def delete_with_steps(self, root, key, step=1):
        """
        Delete a value from the BST with step-by-step explanation

        Args:
            root: The current node being examined
            key: The value to delete
            step: Current step number (for tracking)

        Returns:
            The node at this position (after deletion)
        """
        # Base case: If tree is empty
        if root is None:
            print(f"Step {step}: Reached null node. Value {key} not found for deletion.")
            return None

        # Print current step information
        print(f"Step {step}: Checking node with value {root.value}")

        # If key is smaller, look in left subtree
        if key < root.value:
            print(f"Step {step}: {key} < {root.value}, moving to LEFT subtree")
            root.left = self.delete_with_steps(root.left, key, step + 1)
        # If key is larger, look in right subtree
        elif key > root.value:
            print(f"Step {step}: {key} > {root.value}, moving to RIGHT subtree")
            root.right = self.delete_with_steps(root.right, key, step + 1)
        # Node with matching key found - this is the node to delete
        else:
            print(f"Step {step}: Found node to delete (value {key})")

            # CASE 1: Node has no children or only one child
            if root.left is None:
                print(f"Step {step}: Node has no left child. Replacing with right child.")
                return root.right
            elif root.right is None:
                print(f"Step {step}: Node has no right child. Replacing with left child.")
                return root.left

            # CASE 2: Node has two children
            # Find the inorder successor (smallest value in right subtree)
            print(f"Step {step}: Node has two children. Finding inorder successor (smallest in right subtree)")

            # Find the smallest value in the right subtree (inorder successor)
            successor = root.right
            successor_step = step + 1
            print(f"Step {successor_step}: Looking for smallest value in right subtree, starting at {successor.value}")

            while successor.left is not None:
                successor_step += 1
                successor = successor.left
                print(f"Step {successor_step}: Moving to left child {successor.value}")

            print(f"Step {successor_step + 1}: Found inorder successor: {successor.value}")

            # Replace the value of the node to be deleted with successor value
            print(f"Step {successor_step + 2}: Replacing {root.value} with {successor.value}")
            root.value = successor.value

            # Delete the successor (which is now a duplicate)
            print(f"Step {successor_step + 3}: Now deleting the duplicate successor node from right subtree")
            root.right = self.delete_with_steps(root.right, successor.value, successor_step + 4)

        return root

    def delete(self, key):
        """Wrapper for delete_with_steps starting at root"""
        self.root = self.delete_with_steps(self.root, key)

    def print_tree(self):
        """Print a visualization of the BST structure"""
        print("\nBinary Search Tree Structure:")
        print("---------------------------")
        print("          45           ")
        print("        /     \\       ")
        print("      15        79     ")
        print("     /  \\      / \\   ")
        print("   10    20   55   90  ")
        print("     \\      /         ")
        print("      12   50          ")
        print("---------------------------\n")

    def update_tree_visualization(self, action, value):
        """Show tree structure after changes"""
        print(f"\nBinary Search Tree Structure (after {action} {value}):")
        # In a real implementation, we would traverse the tree and print the actual structure

# Build the initial BST for demonstration
tree = BinarySearchTree()
tree.root = Node(45)
tree.root.left = Node(15)
tree.root.right = Node(79)
tree.root.left.left = Node(10)
tree.root.left.right = Node(20)
tree.root.left.left.right = Node(12)
tree.root.right.left = Node(55)
tree.root.right.left.left = Node(50)
tree.root.right.right = Node(90)

# Main demonstration of BST operations
if __name__ == "__main__":
    # Print the initial tree structure
    tree.print_tree()

    # 1. Search for value 20 (which exists in the tree)
    print("1. SEARCHING FOR VALUE 20:")
    print("=====================")
    result = tree.search(20)
    print(f"RESULT: Value 20 {'found in the BST!' if result else 'not found in the BST.'}")

    # 2. Search for value 50 (which exists in the tree via a different path)
    print("\n2. SEARCHING FOR VALUE 50:")
    print("=====================")
    result = tree.search(50)
    print(f"RESULT: Value 50 {'found in the BST!' if result else 'not found in the BST.'}")

    # 3. Search for value 30 (which does not exist in the tree)
    print("\n3. SEARCHING FOR VALUE 30:")
    print("=====================")
    result = tree.search(30)
    print(f"RESULT: Value 30 {'found in the BST!' if result else 'not found in the BST.'}")

    # 4. Insert value 60 with step-by-step explanation
    print("\n4. INSERTING VALUE 60:")
    print("=====================")
    tree.insert(60)
    print("RESULT: Value 60 inserted into the BST!")
    tree.update_tree_visualization("inserting", 60)
    print("          45           ")
    print("        /     \\       ")
    print("      15        79     ")
    print("     /  \\      / \\   ")
    print("   10    20   55   90  ")
    print("     \\      /  \\     ")
    print("      12   50   60     ")

    # 5. Delete value 90 with step-by-step explanation
    print("\n5. DELETING VALUE 90:")
    print("=====================")
    tree.delete(90)
    print("RESULT: Value 90 deleted from the BST!")
    tree.update_tree_visualization("deleting", 90)
    print("          45           ")
    print("        /     \\       ")
    print("      15        79     ")
    print("     /  \\      /      ")
    print("   10    20   55       ")
    print("     \\      /  \\     ")
    print("      12   50   60     ")
