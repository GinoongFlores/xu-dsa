def binarySearch(arr, targetVal):
    left = 0
    right = len(arr) - 1

    print("Searching for:", targetVal)

    while left <= right:
        # Print the current state
        print("Left:", left, "Right:", right)

        mid = (left + right) // 2
        print("Checking middle index:", mid, "Value:", arr[mid])

        if arr[mid] == targetVal:
            return mid  # Found it!

        if arr[mid] < targetVal:
            # The target is bigger, so we look at the right half
            print(arr[mid], "is less than", targetVal, "-> moving right")
            left = mid + 1
        else:
            # The target is smaller, so we look at the left half
            print(arr[mid], "is greater than", targetVal, "-> moving left")
            right = mid - 1

    return -1 # Target not found

# --- Example with Numbers (Sorted List) ---
myArray = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
myTarget = 15

result = binarySearch(myArray, myTarget)

print("--------------------")
if result != -1:
    print("Value", myTarget, "found at index", result)
else:
    print("Target", myTarget, "not found in array.")