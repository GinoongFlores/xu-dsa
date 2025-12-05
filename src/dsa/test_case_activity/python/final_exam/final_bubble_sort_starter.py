"""
Bubble Sort Activity: High Score Leaderboard

REAL-WORLD CONTEXT:
A game has a list of player scores that are all jumbled up.
To display a proper leaderboard, we need to sort them from
lowest to highest. Bubble Sort is a simple algorithm that
"bubbles" the largest values to the end.

HOW BUBBLE SORT WORKS:
- Compare adjacent elements
- Swap if they're in wrong order
- Repeat until no more swaps are needed
- Largest values "bubble" to the end in each pass

YOUR TASK:
Implement the bubble_sort method to make all test cases pass.
"""


class FinalBubbleSortStarter:
    def bubble_sort(self, scores):
        """
        Sorts a list of scores in ascending order using bubble sort.
        Used by: Test Case 1, Test Case 2, Test Case 3
        
        Args:
            scores: The list of scores to sort
            
        Returns:
            A new sorted list
        """
        # TODO: Implement bubble sort algorithm
        # Hint: Follow the pattern described in the docstring above
        #       Create a copy first, then sort it using nested loops
        
        # Create a copy to avoid modifying the original
        sorted_scores = scores.copy()
        
        # TODO: Implement the bubble sort logic here
        # Hint: Use nested loops:
        #   - Outer loop: number of passes (len(sorted_scores) - 1)
        #   - Inner loop: compare adjacent elements (len(sorted_scores) - 1 - i)
        #   - If sorted_scores[j] > sorted_scores[j+1], swap them using a temporary variable
        # Example structure:
        # for i in range(len(sorted_scores) - 1):
        #     for j in range(len(sorted_scores) - 1 - i):
        #         if sorted_scores[j] > sorted_scores[j + 1]:
        #             # Swap: use a temporary variable
        #             # temp = sorted_scores[j]
        #             # sorted_scores[j] = sorted_scores[j + 1]
        #             # sorted_scores[j + 1] = temp
        
        # This is intentionally incorrect - returns unsorted list
        return sorted_scores  # TODO: Replace this - implement proper bubble sort


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
    print("TEST CASE 1: Two Elements (Easy)")
    print("=" * 50)
    
    sorter = FinalBubbleSortStarter()
    
    input_scores = [30, 10]
    print(f"Input: {input_scores}")
    
    result = sorter.bubble_sort(input_scores)
    expected = [10, 30]
    
    print(f"Expected: {expected}")
    print(f"Got: {result}")
    
    if result == expected:
        print("[PASS] - Test Case 1")
        passed = True
    else:
        print("[FAIL] - Test Case 1")
        passed = False
    print()
    return passed


def test_case_2():
    print("=" * 50)
    print("TEST CASE 2: Jumbled List (Moderate)")
    print("=" * 50)
    
    sorter = FinalBubbleSortStarter()
    
    input_scores = [45, 10, 90, 25]
    print(f"Input: {input_scores}")
    
    result = sorter.bubble_sort(input_scores)
    expected = [10, 25, 45, 90]
    
    print(f"Expected: {expected}")
    print(f"Got: {result}")
    
    if result == expected:
        print("[PASS] - Test Case 2")
        passed = True
    else:
        print("[FAIL] - Test Case 2")
        passed = False
    print()
    return passed


def test_case_3():
    print("=" * 50)
    print("TEST CASE 3: Reverse Sorted (Harder)")
    print("=" * 50)
    
    sorter = FinalBubbleSortStarter()
    
    input_scores = [40, 30, 20, 10]
    print(f"Input: {input_scores}")
    
    result = sorter.bubble_sort(input_scores)
    expected = [10, 20, 30, 40]
    
    print(f"Expected: {expected}")
    print(f"Got: {result}")
    
    if result == expected:
        print("[PASS] - Test Case 3 (correctly sorted reverse-ordered data)")
        passed = True
    else:
        print("[FAIL] - Test Case 3 (should sort from highest to lowest)")
        passed = False
    print()
    return passed


def main():
    print("\n" + "=" * 50)
    print("BUBBLE SORT TEST CASES - High Score Leaderboard")
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
# 1. Bubble Sort Logic: [Your explanation here]
#


