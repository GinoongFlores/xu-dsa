"""
Binary Search Tree Activity: Product Inventory Lookup

REAL-WORLD CONTEXT:
A warehouse needs to quickly find products by their unique ID numbers.
Instead of checking every product one by one (slow!), we organize them
in a Binary Search Tree (BST) for fast O(log n) search.

HOW BST WORKS:
- Smaller values go to the LEFT child
- Larger values go to the RIGHT child
- Start at root, compare, then go left or right
- Perfect for fast lookups in databases and inventory systems

YOUR TASK:
Implement the methods below to make all test cases pass.
"""


class Node:
    def __init__(self, product_id):
        self.product_id = product_id
        self.left = None
        self.right = None


class FinalBSTStarter:
    def __init__(self):
        self.root = None
    
    def insert(self, product_id):
        """
        Inserts a product ID into the BST.
        This method is already correctly implemented - it delegates to _insert_helper().
        
        Args:
            product_id: The product ID to insert
        """
        # Already implemented: delegates to helper method for recursive insertion
        self.root = self._insert_helper(self.root, product_id)
    
    def _insert_helper(self, node, product_id):
        """
        Helper method for recursive insertion.
        Used by: Test Case 1, Test Case 2, Test Case 3
        
        TODO: Implement the recursive insertion logic
        Hint: This is a recursive function with base case and recursive cases
        
        Base case: If current node is None, create and return a new Node(product_id)
        
        Recursive cases:
          - If product_id < node.product_id, recursively insert into left subtree
          - If product_id > node.product_id, recursively insert into right subtree
          - If product_id == node.product_id, you can either skip (duplicate) or handle as needed
        
        Example pattern:
          if node is None:
              return Node(product_id)
          if product_id < node.product_id:
              node.left = self._insert_helper(node.left, product_id)
          elif product_id > node.product_id:
              node.right = self._insert_helper(node.right, product_id)
          return node
        
        Args:
            node: Current node in the tree
            product_id: The product ID to insert
            
        Returns:
            The node (or new node if None)
        """
        # TODO: Implement recursive insertion
        # Hint: Follow the pattern described in the docstring above
        # This is intentionally incorrect - replace with proper recursive insertion logic
        return None
    
    def search(self, product_id):
        """
        Searches for a product ID in the BST.
        This method is already correctly implemented - it delegates to _search_helper().
        
        Args:
            product_id: The product ID to search for
            
        Returns:
            True if found, False otherwise
        """
        # Already implemented: delegates to helper method for recursive search
        return self._search_helper(self.root, product_id)
    
    def _search_helper(self, node, product_id):
        """
        Helper method for recursive search.
        Used by: Test Case 2, Test Case 3
        
        TODO: Implement the recursive search logic
        Hint: This is a recursive function with base cases and recursive cases
        
        Base cases:
          - If node is None, return False (not found)
          - If product_id == node.product_id, return True (found!)
        
        Recursive cases:
          - If product_id < node.product_id, search left subtree
          - If product_id > node.product_id, search right subtree
        
        Example pattern:
          if node is None:
              return False
          if product_id == node.product_id:
              return True
          if product_id < node.product_id:
              return self._search_helper(node.left, product_id)
          return self._search_helper(node.right, product_id)
        
        Args:
            node: Current node in the tree
            product_id: The product ID to search for
            
        Returns:
            True if found, False otherwise
        """
        # TODO: Implement recursive search
        # Hint: Follow the pattern described in the docstring above
        # Note: You need to implement BOTH _insert_helper() and _search_helper() correctly
        #       for all test cases to pass
        if node is None:
            # TODO: Replace this - should return False when node is None (item not found)
            return (product_id == 99)  # This is intentionally incorrect - replace with proper logic
        # TODO: Replace this - should check if product_id matches node.product_id
        #       If not found, recursively search left or right subtree based on comparison
        return False  # This is intentionally incorrect - replace with proper recursive search
    
    def get_root(self):
        """
        Gets the root value (for testing purposes).
        Used by: Test Case 1
        This method is already correctly implemented.
        
        Returns:
            The root product ID, or -1 if tree is empty
        """
        # Already implemented: returns root value or -1 if empty
        if self.root is None:
            return -1
        return self.root.product_id


# ============================================
# TEST CASES - Already implemented below
# Just run this file to test your implementation
# 
#  IMPORTANT: DO NOT MODIFY OR TOUCH THE TEST CASE CODE BELOW 
# The test cases are already complete and should remain unchanged.
# Only modify the TODO sections in the class methods above.
# ============================================

def test_case_1():
    print("=" * 50)
    print("TEST CASE 1: Simple Insert (Easy)")
    print("=" * 50)
    
    inventory = FinalBSTStarter()
    
    print("Action: Insert product ID 50")
    inventory.insert(50)
    
    print("Action: Check root value")
    root_value = inventory.get_root()
    
    print("Expected: 50")
    print(f"Got: {root_value}")
    
    if root_value == 50:
        print("[PASS] - Test Case 1")
        passed = True
    else:
        print("[FAIL] - Test Case 1")
        passed = False
    print()
    return passed


def test_case_2():
    print("=" * 50)
    print("TEST CASE 2: Search for Existing Item (Moderate)")
    print("=" * 50)
    
    inventory = FinalBSTStarter()
    
    print("Action: Insert product IDs: 50, 30, 70")
    inventory.insert(50)
    inventory.insert(30)
    inventory.insert(70)
    
    print("Action: Search for product ID 30")
    found = inventory.search(30)
    
    print("Expected: True (Found)")
    print(f"Got: {found}")
    
    if found:
        print("[PASS] - Test Case 2")
        passed = True
    else:
        print("[FAIL] - Test Case 2")
        passed = False
    print()
    return passed


def test_case_3():
    print("=" * 50)
    print("TEST CASE 3: Search for Non-Existent Item (Harder)")
    print("=" * 50)
    
    inventory = FinalBSTStarter()
    
    print("Action: Insert product IDs: 50, 30, 70")
    inventory.insert(50)
    inventory.insert(30)
    inventory.insert(70)
    
    print("Action: Search for product ID 99 (not in tree)")
    found = inventory.search(99)
    
    print("Expected: False (Not Found)")
    print(f"Got: {found}")
    
    if not found:
        print("[PASS] - Test Case 3 (correctly handled not found)")
        passed = True
    else:
        print("[FAIL] - Test Case 3 (should return False for non-existent item)")
        passed = False
    print()
    return passed


def main():
    print("\n" + "=" * 50)
    print("BST TEST CASES - Product Inventory Lookup")
    print("=" * 50 + "\n")
    
    result1 = test_case_1()
    result2 = test_case_2()
    result3 = test_case_3()
    
    print("=" * 50)
    print("TEST SUMMARY")
    print("=" * 50)
    print(f"Test Case 1: {'[PASS]' if result1 else '[FAIL]'}")
    print(f"Test Case 2: {'[PASS]' if result2 else '[FAIL]'}")
    print(f"Test Case 3: {'[PASS]' if result3 else '[FAIL]'}")
    print("=" * 50)
    
    if result1 and result2 and result3:
        print("All test cases PASSED!")
    else:
        print("Some test cases FAILED. Complete the TODO sections to fix them.")
    print("=" * 50)


if __name__ == "__main__":
    main()

# ============================================
# TODO: EXPLANATION
# ============================================
#
# Write a brief explanation of how you solved the problem.
# What was your thought process? What data structures did you use and why?
#
# 1. Insert Helper: [Your explanation here]
# 2. Search Helper: [Your explanation here]
#


