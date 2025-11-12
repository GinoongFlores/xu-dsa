import java.util.Arrays;

public class Edulsa {

    // Song class
    static class Song {
        String id;
        String name;
        String artist;

        public Song(String id, String name, String artist) {
            this.id = id;
            this.name = name;
            this.artist = artist;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Name: " + name + " | Artist: " + artist;
        }
    }

    // Binary search for Song array by name
    public static int binarySearchByName(Song[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = target.compareToIgnoreCase(arr[mid].name);

            if (compareResult == 0) {
                return mid;
            }

            if (compareResult > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Binary search for a simple String array
    public static int binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        System.out.println("Searching for: " + target);

        while (left <= right) {
            System.out.println("Left: " + left + ", Right: " + right);

            int mid = (left + right) / 2;
            System.out.println("Checking middle index: " + mid + ", Value: " + arr[mid]);

            int compareResult = target.compareToIgnoreCase(arr[mid]);

            if (compareResult == 0) {
                return mid; // Found it!
            }

            if (compareResult > 0) {
                System.out.println("'" + arr[mid] + "' is before '" + target + "' -> moving right");
                left = mid + 1;
            } else {
                System.out.println("'" + arr[mid] + "' is after '" + target + "' -> moving left");
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        // --- Song List ---
        Song[] songs = {
                new Song("1234", "Over", "Playboi Carti"),
                new Song("1235", "All I Need", "Lloyd"),
                new Song("1236", "B.E.D", "Jacquees"),
                new Song("1237", "Rapstar", "Polo G"),
        };

        // Sort songs by name
        Arrays.sort(songs, (s1, s2) -> s1.name.compareToIgnoreCase(s2.name));

        // Extract song names into a separate String array
        String[] songNames = Arrays.stream(songs).map(s -> s.name).toArray(String[]::new);

        // Hardcoded target
        String targetName = "All I Need";

        // Use binary search for String array
        int resultIndex = binarySearch(songNames, targetName);

        System.out.println("--------------------");
        if (resultIndex != -1) {
            System.out.println("Song found at index " + resultIndex + ": " + songs[resultIndex]);
        } else {
            System.out.println("Song with Name '" + targetName + "' not found.");
        }
    }
}
