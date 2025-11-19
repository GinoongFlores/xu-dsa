# Test Case Activity: Data Structures and Algorithms

## Overview

This activity provides hands-on practice with three fundamental data structures and algorithms:

1. **Stacks** - Understanding LIFO (Last In, First Out) operations
2. **Binary Search Tree** - Learning hierarchical data organization and search
3. **Bubble Sort** - Mastering basic sorting algorithms

Each topic includes **3 progressive test cases** that increase in difficulty, helping you build understanding step by step.

## Submission Information

This activity is part of a Moodle e-learning assignment. For complete submission instructions, grading rubric, and important notes about the in-class presentation, please refer to the activity page in Moodle.

**Quick Submission Checklist:**

- Complete all three starter files (Stack, BST, Bubble Sort)
- Fill out the `EXPLANATION` section at the bottom of each file
- Submit your three completed files via Moodle (or share OnlineGDB links if using an online IDE)

## How to Use This Activity

### Step 1: Choose Your Language

- **Java**: Navigate to `java/starter/` folder
- **Python**: Navigate to `python/starter/` folder

### Step 2: Work on Starter Code

- Open the starter file for the topic you want to practice
- Read the problem description and real-world context
- Implement the methods marked with `TODO` comments
- Run the file to execute the test cases

### Step 3: Test Your Implementation

- Each starter file includes 3 test cases that run automatically
- Check if your implementation passes all test cases
- Review the expected outputs to understand what each test validates

### Step 4: Write Your Explanation

- At the bottom of each starter file, fill out the `EXPLANATION` section
- Write your own explanation of how you solved the problem
- Explain your thought process and the data structures you used
- This demonstrates your understanding of the code

## Important Notes

- **Understand, don't copy**: The goal is to learn the concepts, not just pass tests
- **Test incrementally**: Implement one method at a time and test it
- **Read the comments**: They contain helpful hints and explanations
- **Write your own explanation**: After implementing, explain your solution in your own words to demonstrate understanding

---

## Topic 1: Stacks - Text Editor Undo Feature

### Real-World Context

Imagine you're typing in a text editor. Every time you type a word, it gets saved to your action history. When you press **Undo** (Ctrl+Z), the last word you typed disappears. This is exactly how a **Stack** works!

**Why Stacks?**

- **LIFO Principle**: Last In, First Out - the last word typed is the first one removed when you undo
- **Perfect for Undo/Redo**: Stacks naturally model sequential actions that need to be reversed
- **Simple Operations**: Push (add), Pop (remove), Peek (view top) - easy to understand and implement

### Test Cases

#### Test Case 1: Simple Push and Peek (Easy)

**Objective**: Verify basic push and peek operations work correctly.

**Actions**:

1. Push "Hello" onto the stack
2. Peek at the top of the stack

**Expected Output**: "Hello"

**Learning Goal**: Understand that push adds items and peek shows the top without removing it.

---

#### Test Case 2: Basic Undo Operation (Moderate)

**Objective**: Test the LIFO behavior with multiple operations.

**Actions**:

1. Push "Hello"
2. Push "World"
3. Pop (undo the last action)
4. Peek at the stack

**Expected Output**: "Hello"

**Learning Goal**: Verify that pop removes the most recently added item (LIFO), leaving "Hello" as the top.

---

#### Test Case 3: Empty Stack Edge Case (Harder)

**Objective**: Handle error cases when stack is empty.

**Actions**:

1. Try to pop from an empty stack

**Expected Output**: Should return `null` or a message like "Nothing to undo" (no crash/error)

**Learning Goal**: Learn to handle edge cases and prevent stack underflow errors.

---

## Topic 2: Binary Search Tree - Product Inventory Lookup

### Real-World Context

A warehouse needs to quickly find products by their unique ID numbers. Instead of checking every product one by one (slow!), we organize them in a **Binary Search Tree (BST)**.

**Why BST?**

- **Fast Search**: O(log n) time complexity - much faster than linear search
- **Ordered Structure**: Smaller IDs go left, larger IDs go right
- **Efficient Lookup**: Perfect for databases, file systems, and inventory management

**How it works**:

- Start at the root (middle value)
- If the ID you're looking for is smaller → go left
- If it's larger → go right
- Repeat until found or reach a null pointer

### Test Cases

#### Test Case 1: Simple Insert (Easy)

**Objective**: Verify basic insertion creates the root node correctly.

**Actions**:

1. Insert product ID 50
2. Check the root value

**Expected Output**: Root = 50

**Learning Goal**: Understand that the first insert becomes the root of the tree.

---

#### Test Case 2: Search for Existing Item (Moderate)

**Objective**: Test the search functionality with a properly structured tree.

**Actions**:

1. Insert product IDs: 50, 30, 70 (in any order)
2. Search for product ID 30

**Expected Output**: `true` or "Found"

**Learning Goal**: Verify that search correctly traverses the tree (left for smaller, right for larger) to find existing items.

---

#### Test Case 3: Search for Non-Existent Item (Harder)

**Objective**: Handle the case when an item doesn't exist in the tree.

**Actions**:

1. Insert product IDs: 50, 30, 70
2. Search for product ID 99 (not in tree)

**Expected Output**: `false` or "Not Found"

**Learning Goal**: Learn to handle null pointers and return appropriate "not found" responses without crashing.

---

## Topic 3: Bubble Sort - High Score Leaderboard

### Real-World Context

A game has a list of player scores that are all jumbled up: `[45, 10, 90, 25]`. To display a proper leaderboard, we need to sort them from lowest to highest (or highest to lowest). **Bubble Sort** is a simple sorting algorithm that "bubbles" the largest (or smallest) values to the top.

**Why Bubble Sort?**

- **Easy to Understand**: Simple comparison and swap logic
- **Visual Learning**: You can see values "bubbling" to their correct positions
- **Foundation**: Understanding bubble sort helps you learn more complex sorting algorithms

**How it works**:

- Compare adjacent elements
- Swap if they're in wrong order
- Repeat until no more swaps are needed
- Largest values "bubble" to the end in each pass

### Test Cases

#### Test Case 1: Two Elements (Easy)

**Objective**: Verify basic swapping logic works correctly.

**Input**: `[30, 10]`

**Expected Output**: `[10, 30]`

**Learning Goal**: Understand the fundamental compare-and-swap operation that all sorting algorithms use.

---

#### Test Case 2: Jumbled List (Moderate)

**Objective**: Test the algorithm with multiple unsorted elements.

**Input**: `[45, 10, 90, 25]`

**Expected Output**: `[10, 25, 45, 90]`

**Learning Goal**: Verify that the algorithm correctly performs multiple passes and swaps to sort the entire list.

---

#### Test Case 3: Reverse Sorted (Harder)

**Objective**: Test the algorithm with reverse-ordered data (worst case scenario).

**Input**: `[40, 30, 20, 10]`

**Expected Output**: `[10, 20, 30, 40]`

**Learning Goal**: Understand that reverse-sorted data requires the maximum number of swaps, testing the algorithm's ability to handle the worst-case scenario for bubble sort.

---

## Tips for Success

1. **Start with Test Case 1**: It's designed to be easy - get it working first!
2. **Read the comments**: They explain the real-world context and provide hints
3. **Test incrementally**: Implement one method, test it, then move to the next
4. **Trace through examples**: Draw out the data structure (stack, tree, array) to visualize what's happening
5. **Don't give up**: If stuck, review the concept, then try again

## Learning Objectives

By completing these activities, you will:

- Understand the LIFO principle and stack operations
- Learn how binary search trees organize and search data efficiently
- Master the bubble sort algorithm and sorting fundamentals
- Practice handling edge cases and error conditions
- Build confidence in implementing data structures from scratch

Good luck! Remember: the goal is understanding, not just passing tests. Take your time and truly grasp each concept.
