cars = ["Audi", "BMW", "Ferrari", "Honda", "Sakyanan"]
target = "Honda"

left = 0
right = len(cars) - 1

print(f"Searching for: {target}\n")

while left <= right:
    print(f"Left: {left} Right: {right}")

    mid = (left + right)// 2
    print(f"Checking middle index: {mid} Value: {cars[mid]}")

    if cars[mid] == target:
        print(f"\n '{target}' found at index {mid}")
        break

    elif cars[mid] < target:
        left = mid + 1
        print()

    else:
        right = mid - 1
        print()

if left > right:
    print(f"\n '{target}' not found in the list")