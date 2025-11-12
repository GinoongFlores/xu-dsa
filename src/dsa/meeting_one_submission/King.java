public class King {

    private static final String[] MilAlph = {
            "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf",
            "Hotel", "India"
    };

    public static void binarySearch(String target) {
        System.out.println("Searching for: " + target);
        int left = 0;
        int right = MilAlph.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midValue = MilAlph[mid];
            System.out.println("Left: " + left + " Right: " + right);
            System.out.println("Mid index: " + mid + " Value: " + midValue);

            int comparison = target.compareToIgnoreCase(midValue);

            if (comparison == 0) {
                System.out.println("Value " + target + " found at index " + mid);
                return;
            } else if (comparison < 0) {
                System.out.println(midValue + " is after " + target + " -> moving left");
                right = mid - 1;
            } else {
                System.out.println(midValue + " is before " + target + " -> moving right");
                left = mid + 1;
            }
            System.out.println();
        }
    }

    public static void displayAlphabet() {
        System.out.println("Military Alphabet List:");
        for (int i = 0; i < MilAlph.length; i++) {
            System.out.println(i + ": " + MilAlph[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        displayAlphabet();

        System.out.println("SEARCH 1");
        binarySearch("Charlie");

        System.out.println("SEARCH 2");
        binarySearch("India");
    }
}
