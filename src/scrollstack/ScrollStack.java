package scrollstack;

// The ScrollStack class manages a stack of ancient scrolls
public class ScrollStack {
    private String[] stack; // Array to hold scrolls
    private int top; // Index of the top scroll

    // Constructor to initialize the stack with a given capacity
    public ScrollStack(int capacity) {
        stack = new String[capacity]; // Initialize the array with the specified capacity
        top = -1; // Start with an empty stack
    }

    // Method to push a new scroll onto the stack
    public boolean push(String scroll) {
        if (top < stack.length - 1) { // Check if there's space in the stack
            stack[++top] = scroll; // Increment top and add scroll
            return true; // Return true indicating success
        }
        return false; // Return false if stack is full
    }

    // Method to pop the top scroll off the stack
    public String pop() {
        if (top >= 0) { // Check if the stack is not empty
            return stack[top--]; // Return the top scroll and decrement top
        }
        return null; // Return null if stack is empty
    }

    // Method to peek at the top scroll without removing it
    public String peek() {
        if (top >= 0) { // Check if the stack is not empty
            return stack[top]; // Return the top scroll
        }
        return null; // Return null if stack is empty
    }

    // Method to check if a specific scroll title exists in the stack
    public boolean contains(String scroll) {
        for (int i = 0; i <= top; i++) { // Loop through the stack
            if (stack[i].equals(scroll)) { // Check if the scroll matches
                return true; // Return true if found
            }
        }
        return false; // Return false if not found
    }

    // Method to print all scrolls in the stack
    public void printStack() {
        System.out.println("Scrolls in the stack:");
        for (int i = top; i >= 0; i--) { // Loop backwards to show the top scroll first
            System.out.println(stack[i]); // Print scroll
        }
    }

    // Main method for testing the ScrollStack class
    public static void main(String[] args) {
        ScrollStack stack = new ScrollStack(3); // Create a ScrollStack with a capacity of 3

        // Pushing scrolls onto the stack
        stack.push("Scroll of Wisdom");
        stack.push("Scroll of Truth");
        stack.push("Scroll of Power");

        // Print the stack
        stack.printStack();

        // Peek at the top scroll
        System.out.println("Top scroll: " + stack.peek());

        // Pop the top scroll
        System.out.println("Popped scroll: " + stack.pop());
        stack.printStack(); // Print after popping

        // Check if a specific scroll is in the stack
        System.out.println("Contains 'Scroll of Wisdom': " + stack.contains("Scroll of Wisdom"));
    }
}
