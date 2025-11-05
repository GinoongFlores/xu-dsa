# 1. We need a class to define what a tree node is
class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

# 2. The binary search function for a BST (Iterative)
def search_bst(root, target):
    """
    Performs a binary search on a Binary Search Tree.
    This is the direct equivalent of your array-based function.
    """
    current = root  # Start at the top of the tree

    print("Searching for:", target)

    # We loop as long as we haven't fallen off the tree
    while current is not None:

        # 'current.key' is the "middle" value we are checking
        print("Checking node:", current.key)

        if current.key == target:
            return current  # Found it!


        if target < current.key:
            # The target is smaller, so we go to the left subtree
            print(target, "is less than", current.key, "-> moving left")
            current = current.left
        else:
            # The target is larger, so we go to the right subtree
            print(target, "is greater than", current.key, "-> moving right")
            current = current.right

    return None # Target not found

# --- Example with a Binary Search Tree ---

# 3. We have to build the tree first (unlike an array)
# Let's build a balanced tree with similar numbers
root = Node(11)
root.left = Node(5)
root.right = Node(17)

root.left.left = Node(3)
root.left.right = Node(9)

root.right.left = Node(13)
root.right.right = Node(19)

# Let's add 15, which will be the right child of 13
root.right.left.right = Node(15)

# 4. Run the search
myTarget = 15
result_node = search_bst(root, myTarget)

print("--------------------")
if result_node is not None:
    print("Value", myTarget, "found in the tree!")
else:
    print("Target", myTarget, "not found in the tree.")