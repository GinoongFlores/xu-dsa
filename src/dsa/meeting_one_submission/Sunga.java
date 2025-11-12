import java.util.*;

public class Sunga {

    public static int binarySearch(String[] arr, String target) {
        // Two pointers that bound the current search window
        int left = 0;
        int right = arr.length - 1;

        System.out.println("\nSearching for: " + target);

        // While there is a valid window to search
        while (left <= right) {
            // Show current window for tracing
            System.out.println("Left: " + left + " Right: " + right);

            // Middle index (avoid overflow in huge arrays with: left + (right-left)/2)
            int mid = (left + right) / 2;

            // Show what value we are checking
            System.out.println("Checking middle index: " + mid + " Value: " + arr[mid]);

            // Case-insensitive comparison:
            // = 0 -> equal (found)
            // < 0 -> arr[mid] comes BEFORE target (alphabetically)
            // > 0 -> arr[mid] comes AFTER target
            int compare = arr[mid].compareToIgnoreCase(target);

            if (compare == 0) {
                // Found the value
                System.out.println("--------------------");
                System.out.println("Value '" + target + "' found at index " + mid);
                return mid;
            } else if (compare < 0) {
                // Target is to the RIGHT of mid -> shrink window to the right half
                System.out.println(arr[mid] + " is before " + target + " -> moving right");
                left = mid + 1;
            } else {
                // Target is to the LEFT of mid -> shrink window to the left half
                System.out.println(arr[mid] + " is after " + target + " -> moving left");
                right = mid - 1;
            }
        }

        // If we exit the loop, target was not found in the array
        System.out.println("--------------------");
        System.out.println("Value '" + target + "' not found.");
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) Genres list (we will SORT this so binary search is valid)
        String[] genres = { "Fantasy", "Mystery", "Romance", "Science Fiction", "Nonfiction" };
        // Sort genres alphabetically (case-insensitive) so binary search works
        // correctly
        Arrays.sort(genres, String.CASE_INSENSITIVE_ORDER);

        // 2) Books per genre (kept unsorted here to demonstrate we sort before
        // searching them)
        HashMap<String, String[]> books = new HashMap<>();
        books.put("Fantasy", new String[] {
                "The Hobbit", "Mistborn", "A Game of Thrones", "The Name of the Wind", "The Way of Kings"
        });
        books.put("Mystery", new String[] {
                "Gone Girl", "The Da Vinci Code", "The Girl with the Dragon Tattoo", "Big Little Lies",
                "And Then There Were None"
        });
        books.put("Romance", new String[] {
                "Pride and Prejudice", "The Notebook", "Me Before You", "Outlander", "The Hating Game"
        });
        books.put("Science Fiction", new String[] {
                "Dune", "Ender's Game", "Neuromancer", "Foundation", "The Martian"
        });
        books.put("Nonfiction", new String[] {
                "Atomic Habits", "Sapiens", "Educated", "The Power of Habit", "Thinking, Fast and Slow"
        });

        // ====== MAIN LOOP ======
        // Allows the user to search again without restarting the program
        while (true) {
            // Show the available (already sorted) genres
            System.out.println("\nAvailable genres: " + Arrays.toString(genres));

            // Ask user which genre to search for
            System.out.print("\nEnter a genre to search: ");
            String targetGenre = sc.nextLine().trim();

            // Binary search on the SORTED genres array
            int genreIndex = binarySearch(genres, targetGenre);

            // If genre is found, proceed to book search within that genre
            if (genreIndex != -1) {
                String foundGenre = genres[genreIndex];

                // Get the books for the found genre
                String[] selectedBooks = books.get(foundGenre);

                // Sort the book titles alphabetically (required for binary search)
                Arrays.sort(selectedBooks, String.CASE_INSENSITIVE_ORDER);

                // Show the list we are about to search (for clarity)
                System.out.println("\nGenre found: " + foundGenre);
                System.out.println("Books available (sorted): " + Arrays.toString(selectedBooks));

                // Ask user which book title to search for
                System.out.print("\nEnter a book title to search: ");
                String targetBook = sc.nextLine().trim();

                // Binary search on the SORTED books array (with full trace)
                binarySearch(selectedBooks, targetBook);
            }
            // If genre not found, the not-found message has already been printed by
            // binarySearch

            // Ask if the user wants to perform another search
            System.out.print("\nDo you want to search again? (yes/no): ");
            String again = sc.nextLine().trim().toLowerCase();

            // If the answer is not exactly "yes", exit the loop and end the program
            if (!again.equals("yes")) {
                System.out.println("\nThank you for using the Book Binary Search! 📚");
                break;
            }
        }

        // Close the scanner resource
        sc.close();
    }
}