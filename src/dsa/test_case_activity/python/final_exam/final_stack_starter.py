"""
Stack Activity: Text Editor Undo Feature

REAL-WORLD CONTEXT:
Imagine you're typing in a text editor. Every time you type a word,
it gets saved to your action history. When you press Undo (Ctrl+Z),
the last word you typed disappears. This is exactly how a Stack works!

HOW STACKS WORK:
- LIFO (Last In, First Out): The last word typed is the first one removed
- Push: Adds a word to the top of the stack
- Pop: Removes and returns the top word (undo action)
- Peek: Shows the top word without removing it

YOUR TASK:
Implement the methods below to make all test cases pass.
Use a Python list to store the stack elements.
"""


class FinalStackStarter:
    # TODO: Declare your stack data structure here
    # Hint: Use a list to store the words
    # Example: self.stack = []
    
    def __init__(self):
        # TODO: Initialize the stack by creating a new list instance
        # Hint: Instantiate the list you declared above
        # Example: self.stack = []
        pass
    
    def push(self, word):
        """
        Adds a word to the top of the stack.
        Used by: Test Case 1, Test Case 2
        
        Args:
            word: The word to add to the stack
        """
        # TODO: Add the word to your stack
        # Hint: Use the append() method of list to add the word
        # Example: If your stack is a list, think about which method adds elements
        #         Consider: self.stack.append(word) - this adds to the end
        #         Remember: Stack is LIFO - Last In, First Out. Where should new items go?
        pass
    
    def pop(self):
        """
        Removes and returns the top word from the stack (undo action).
        Used by: Test Case 2, Test Case 3
        
        Returns:
            The word that was removed, or None if stack is empty
        """
        # TODO: Remove and return the last word added
        # Hint: First check if stack is empty using is_empty() method
        #       If empty, return None
        #       Otherwise, remove the last element and return it
        # Example: Think about list methods:
        #         - How to check if empty? (len(self.stack) == 0 or not self.stack)
        #         - How to remove and get the last element? (pop() method returns the removed element)
        #         Pattern: if self.is_empty(): return None; else return self.stack.pop()
        return "ERROR"  # TODO: Replace this - implement proper pop logic
    
    def peek(self):
        """
        Returns the top word without removing it.
        Used by: Test Case 1, Test Case 2
        
        Returns:
            The top word, or None if stack is empty
        """
        # TODO: Return the last word without removing it
        # Hint: Check if stack is empty first, then access the last element
        # Example: Similar to pop(), but use indexing instead of pop()
        #         Pattern: if self.is_empty(): return None; else return self.stack[-1]
        return None  # TODO: Replace this
    
    def is_empty(self):
        """
        Checks if the stack is empty.
        Used by: Test Case 3 (indirectly through pop())
        
        Returns:
            True if stack is empty, False otherwise
        """
        # TODO: Check if the stack has no elements
        # Hint: Use len() == 0 or check if list is falsy
        # Example: return len(self.stack) == 0 or return not self.stack
        #         Note: Make sure stack is initialized first, or this will cause AttributeError
        return False  # TODO: Replace this - implement proper is_empty logic


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
    print("TEST CASE 1: Simple Push and Peek (Easy)")
    print("=" * 50)
    
    editor = FinalStackStarter()
    
    print("Action: Push 'Hello'")
    editor.push("Hello")
    
    print("Action: Peek at the stack")
    result = editor.peek()
    
    print("Expected: Hello")
    print(f"Got: {result}")
    
    if result == "Hello":
        print("[PASS] - Test Case 1")
        passed = True
    else:
        print("[FAIL] - Test Case 1")
        passed = False
    print()
    return passed


def test_case_2():
    print("=" * 50)
    print("TEST CASE 2: Basic Undo Operation (Moderate)")
    print("=" * 50)
    
    editor = FinalStackStarter()
    
    print("Action: Push 'Hello'")
    editor.push("Hello")
    
    print("Action: Push 'World'")
    editor.push("World")
    
    print("Action: Pop (undo last action)")
    popped = editor.pop()
    print(f"Popped: {popped}")
    
    print("Action: Peek at the stack")
    result = editor.peek()
    
    print("Expected: Hello (World was removed)")
    print(f"Got: {result}")
    
    if result == "Hello":
        print("[PASS] - Test Case 2")
        passed = True
    else:
        print("[FAIL] - Test Case 2")
        passed = False
    print()
    return passed


def test_case_3():
    print("=" * 50)
    print("TEST CASE 3: Empty Stack Edge Case (Harder)")
    print("=" * 50)
    
    editor = FinalStackStarter()
    
    print("Action: Try to pop from empty stack")
    result = editor.pop()
    
    print("Expected: None or 'Nothing to undo'")
    print(f"Got: {result}")
    
    if result is None:
        print("[PASS] - Test Case 3 (handled empty stack correctly)")
        passed = True
    else:
        print("[FAIL] - Test Case 3 (should return None for empty stack)")
        passed = False
    print()
    return passed


def main():
    print("\n" + "=" * 50)
    print("STACK TEST CASES - Text Editor Undo Feature")
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
# 1. Push: [Your explanation here]
# 2. Pop: [Your explanation here]
# 3. Peek: [Your explanation here]
# 4. is_empty: [Your explanation here]
#


