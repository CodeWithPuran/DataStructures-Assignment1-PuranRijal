package labyrinthpath;

// Node class for the linked list
class Node {
    String location; // The location name
    Node next; // Pointer to the next node

    Node(String location) {
        this.location = location; // Initialize location
        this.next = null; // Initialize next as null
    }
}

// The LabyrinthPath class manages a path using a singly linked list
public class LabyrinthPath {
    private Node head; // Head of the linked list
    private int size; // Size of the path

    public LabyrinthPath() {
        this.head = null; // Start with no locations
        this.size = 0; // Initialize size
    }

    // Method to add a new location to the path
    public void addLocation(String location) {
        Node newNode = new Node(location); // Create a new node for the location
        if (head == null) {
            head = newNode; // If list is empty, set head to new node
        } else {
            Node current = head;
            while (current.next != null) { // Traverse to the end of the list
                current = current.next;
            }
            current.next = newNode; // Add new node at the end
        }
        size++; // Increment size
    }

    // Method to remove the last visited location
    public boolean removeLastLocation() {
        if (head == null) {
            return false; // Return false if list is empty
        } else if (head.next == null) {
            head = null; // If only one location, clear the head
        } else {
            Node current = head;
            while (current.next.next != null) { // Traverse to the second last node
                current = current.next;
            }
            current.next = null; // Remove the last node
        }
        size--; // Decrement size
        return true; // Return true indicating success
    }

    // Method to check if the path contains a loop
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow by one step
            fast = fast.next.next; // Move fast by two steps
            if (slow == fast) {
                return true; // Loop detected
            }
        }
        return false; // No loop
    }

    // Method to print the entire path
    public void printPath() {
        Node current = head;
        System.out.println("Path through the labyrinth:");
        while (current != null) {
            System.out.print(current.location + " -> "); // Print current location
            current = current.next; // Move to the next location
        }
        System.out.println("null"); // Indicate end of path
    }

    // Main method for testing the LabyrinthPath class
    public static void main(String[] args) {
        LabyrinthPath path = new LabyrinthPath(); // Create a new labyrinth path

        // Adding locations
        path.addLocation("Entrance");
        path.addLocation("Hallway");
        path.addLocation("Treasure Room");
        path.addLocation("Exit");

        // Print the path
        path.printPath();

        // Remove the last visited location
        path.removeLastLocation();
        path.printPath(); // Print after removal

        // Check for loops (no loops in this case)
        System.out.println("Path has loop: " + path.hasLoop());
    }
}
