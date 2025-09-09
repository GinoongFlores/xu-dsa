package dsa;


    public class MusicPlaylist {

        // Node class representing a song in the playlist
        static class SongNode {
            String songName;   // Name of the song
            SongNode prev;     // Pointer to the previous song
            SongNode next;     // Pointer to the next song

            // Constructor to create a new song node
            SongNode(String songName) {
                this.songName = songName;
                this.prev = null;
                this.next = null;
            }
        }

        private SongNode head; // First song in the playlist
        private SongNode tail; // Last song in the playlist

        // Constructor initializes an empty playlist
        public MusicPlaylist() {
            head = null;
            tail = null;
        }

        // Method to add a song at the end of the playlist
        public void addSong(String songName) {
            SongNode newSong = new SongNode(songName);

            // If playlist is empty, set both head and tail to new song
            if (head == null) {
                head = newSong;
                tail = newSong;
            } else {
                // Link the new song after the current tail
                tail.next = newSong;
                newSong.prev = tail;
                tail = newSong;
            }
            System.out.println("Added: " + songName);
        }

        // Method to remove a song by its name
        public void removeSong(String songName) {
            if (head == null) {
                System.out.println("Playlist is empty.");
                return;
            }

            SongNode current = head;

            // Traverse until the song is found
            while (current != null && !current.songName.equals(songName)) {
                current = current.next;
            }

            // If song not found, output a message
            if (current == null) {
                System.out.println("Song not found: " + songName);
                return;
            }

            // If the song is at the head
            if (current == head) {
                head = current.next;
                if (head != null) {
                    head.prev = null;
                } else {
                    // List becomes empty
                    tail = null;
                }
            } else if (current == tail) { // If the song is at the tail
                tail = current.prev;
                tail.next = null;
            } else { // Song is in the middle
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            System.out.println("Removed: " + songName);
        }

        // Method to display the playlist forward (from head to tail)
        public void displayForward() {
            if (head == null) {
                System.out.println("Playlist is empty.");
                return;
            }
            System.out.print("Playlist (forward): ");
            SongNode current = head;
            while (current != null) {
                System.out.print(current.songName + " ");
                current = current.next;
            }
            System.out.println();
        }

        // Method to display the playlist backward (from tail to head)
        public void displayBackward() {
            if (tail == null) {
                System.out.println("Playlist is empty.");
                return;
            }
            System.out.print("Playlist (backward): ");
            SongNode current = tail;
            while (current != null) {
                System.out.print(current.songName + " ");
                current = current.prev;
            }
            System.out.println();
        }

        // Main method to demonstrate playlist operations
        public static void main(String[] args) {
            MusicPlaylist playlist = new MusicPlaylist();

            // Add songs to the playlist
            playlist.addSong("Song A");
            playlist.addSong("Song B");
            playlist.addSong("Song C");
            playlist.addSong("Song D");

            // Display the playlist in both directions
            playlist.displayForward();
            playlist.displayBackward();

            // Remove a song and then display the playlist
            playlist.removeSong("Song B");
            playlist.displayForward();
            playlist.displayBackward();

            // Attempt to remove a song that doesn't exist
            playlist.removeSong("Song X");
        }
    }

