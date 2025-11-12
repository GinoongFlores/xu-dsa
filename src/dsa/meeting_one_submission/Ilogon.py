def binarySearch(arr, targetVal):
    left = 0
    right = len(arr) - 1

    print("Searching for:", targetVal)

    while left <= right:

        print("Left:", left, "Right:", right)

        mid = (left + right) // 2
        print("Checking middle index:", mid, "Value:", arr[mid])

        if arr[mid] == targetVal:
            return mid
        if arr[mid] < targetVal:
            print(arr[mid], "is before", targetVal, "-> moving right")
            left = mid + 1
        else:
            print(arr[mid], "is after", targetVal, "-> moving left")
            right = mid - 1

    return -1


famous_games = [
    "Assassin's Creed", "Call of Duty", "Elden Ring", "Ghost of Tsushima", "Ghost of Yotei", "God of War","Sekiro"
]

target_game_1 = "Elden Ring"
result_1 = binarySearch(famous_games, target_game_1)

print("--------------------")

if result_1 != -1:
    print("Value '", target_game_1, "' found at index", result_1)
else:
    print("Target '", target_game_1, "https://www.onlinegdb.com/fork/dPjFAz8fH#tab-stdin' not found in array.")