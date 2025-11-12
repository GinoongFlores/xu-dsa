def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    print(f"Searching for: {target}")

    while left <= right:
        print(f"Left: {left}  Right: {right}")
        mid = (left + right) // 2
        print(f"Checking middle index: {mid}  Value: {arr[mid]}")

        if arr[mid] == target:
            print(f"Found {target} at index {mid}")
            return mid
        elif arr[mid] < target:
            print(f"{arr[mid]} is before {target} -> moving right")
            left = mid + 1
        else:
            print(f"{arr[mid]} is after {target} -> moving left")
            right = mid - 1

    print(f"{target} not found in the list.")
    return -1

words = ["1", "2", "3", "4", "5", "6", "7"]
binary_search(words, "2")