package explorerqueue;

// The ExplorerQueue class implements a circular queue for explorers
public class ExplorerQueue {
    private String[] queue; // Array to store explorers
    private int front; // Index of the front of the queue
    private int rear; // Index of the rear of the queue
    private int size; // Maximum size of the queue
    private int currentSize; // Current number of elements in the queue

    // Constructor to initialize the queue
    public ExplorerQueue(int size) {
        this.size = size; // Set maximum size
        queue = new String[size]; // Initialize the queue array
        front = 0; // Initialize front index
        rear = -1; // Initialize rear index
        currentSize = 0; // Initialize current size
    }

    // Method to enqueue a new explorer
    public void enqueue(String explorer) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add explorer: " + explorer);
            return; // Return if the queue is full
        }
        rear = (rear + 1) % size; // Circular increment
        queue[rear] = explorer; // Add explorer to the queue
        currentSize++; // Increase current size
        System.out.println("Explorer added: " + explorer);
    }

    // Method to dequeue an explorer from the front
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No explorer to dequeue.");
            return null; // Return null if the queue is empty
        }
        String explorer = queue[front]; // Get the explorer at the front
        front = (front + 1) % size; // Circular increment
        currentSize--; // Decrease current size
        System.out.println("Explorer dequeued: " + explorer);
        return explorer; // Return the dequeued explorer
    }

    // Method to display the next explorer in line
    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No explorer in line.");
            return null; // Return null if the queue is empty
        }
        return queue[front]; // Return the explorer at the front
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return currentSize == size; // Return true if full
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0; // Return true if empty
    }

    // Method to display all explorers in the queue
    public void displayQueue() {
        System.out.println("Explorers in the queue:");
        for (int i = 0; i < currentSize; i++) {
            System.out.println(queue[(front + i) % size]); // Print each explorer
        }
    }

    // Main method for testing the ExplorerQueue class
    public static void main(String[] args) {
        ExplorerQueue explorerQueue = new ExplorerQueue(5); // Create a queue with capacity of 5

        // Enqueue explorers
        explorerQueue.enqueue("Explorer A");
        explorerQueue.enqueue("Explorer B");
        explorerQueue.enqueue("Explorer C");

        // Display the queue
        explorerQueue.displayQueue();

        // Peek at the next explorer in line
        System.out.println("Next explorer in line: " + explorerQueue.peek());

        // Dequeue an explorer
        explorerQueue.dequeue();

        // Display the queue after dequeueing
        explorerQueue.displayQueue();

        // Enqueue more explorers
        explorerQueue.enqueue("Explorer D");
        explorerQueue.enqueue("Explorer E");
        explorerQueue.enqueue("Explorer F"); // This should indicate the queue is full

        // Display the final state of the queue
        explorerQueue.displayQueue();
    }
}
