package cluetree;

// The TreeNode class represents each node in the binary tree
class TreeNode {
    String clue; // Clue stored in the node
    TreeNode left; // Pointer to the left child
    TreeNode right; // Pointer to the right child

    // Constructor to initialize a TreeNode
    TreeNode(String clue) {
        this.clue = clue; // Initialize the clue
        this.left = null; // Initialize left child as null
        this.right = null; // Initialize right child as null
    }
}

// The ClueTree class represents a binary tree of clues
public class ClueTree {
    private TreeNode root; // Root of the binary tree

    // Method to insert a new clue into the tree
    public void insert(String clue) {
        root = insertRec(root, clue); // Call recursive insert method
    }

    // Recursive method to insert a new clue
    private TreeNode insertRec(TreeNode node, String clue) {
        // If the current node is null, create a new TreeNode
        if (node == null) {
            return new TreeNode(clue); // Create a new node
        }

        // Insert the clue in the left or right subtree based on alphabetical order
        if (clue.compareTo(node.clue) < 0) {
            node.left = insertRec(node.left, clue); // Insert in the left subtree
        } else {
            node.right = insertRec(node.right, clue); // Insert in the right subtree
        }
        return node; // Return the unchanged node pointer
    }

    // Method for in-order traversal of the tree
    public void inOrder() {
        inOrderRec(root); // Call recursive in-order method
    }

    // Recursive method for in-order traversal
    private void inOrderRec(TreeNode node) {
        if (node != null) {
            inOrderRec(node.left); // Visit left child
            System.out.println(node.clue); // Print clue
            inOrderRec(node.right); // Visit right child
        }
    }

    // Method for pre-order traversal of the tree
    public void preOrder() {
        preOrderRec(root); // Call recursive pre-order method
    }

    // Recursive method for pre-order traversal
    private void preOrderRec(TreeNode node) {
        if (node != null) {
            System.out.println(node.clue); // Print clue
            preOrderRec(node.left); // Visit left child
            preOrderRec(node.right); // Visit right child
        }
    }

    // Method for post-order traversal of the tree
    public void postOrder() {
        postOrderRec(root); // Call recursive post-order method
    }

    // Recursive method for post-order traversal
    private void postOrderRec(TreeNode node) {
        if (node != null) {
            postOrderRec(node.left); // Visit left child
            postOrderRec(node.right); // Visit right child
            System.out.println(node.clue); // Print clue
        }
    }

    // Method to find a specific clue in the tree
    public boolean find(String clue) {
        return findRec(root, clue); // Call recursive find method
    }

    // Recursive method to find a clue
    private boolean findRec(TreeNode node, String clue) {
        if (node == null) {
            return false; // Return false if the node is null
        }
        if (node.clue.equals(clue)) {
            return true; // Return true if clue is found
        }
        // Search in left or right subtree based on alphabetical order
        return clue.compareTo(node.clue) < 0
                ? findRec(node.left, clue) // Search in left subtree
                : findRec(node.right, clue); // Search in right subtree
    }

    // Method to count total number of clues in the tree
    public int count() {
        return countRec(root); // Call recursive count method
    }

    // Recursive method to count nodes in the tree
    private int countRec(TreeNode node) {
        if (node == null) {
            return 0; // Return 0 if the node is null
        }
        return 1 + countRec(node.left) + countRec(node.right); // Count current node and subtrees
    }

    // Main method for testing the ClueTree class
    public static void main(String[] args) {
        ClueTree clueTree = new ClueTree(); // Create a new ClueTree

        // Insert clues into the tree
        clueTree.insert("Map of the Temple");
        clueTree.insert("Ancient Texts");
        clueTree.insert("Golden Idol");
        clueTree.insert("Mysterious Key");
        clueTree.insert("Sacred Scroll");

        // Display clues using different traversals
        System.out.println("In-order traversal:");
        clueTree.inOrder();

        System.out.println("\nPre-order traversal:");
        clueTree.preOrder();

        System.out.println("\nPost-order traversal:");
        clueTree.postOrder();

        // Search for a clue
        String searchClue = "Golden Idol";
        System.out.println("\nSearching for clue: " + searchClue);
        System.out.println("Clue found: " + clueTree.find(searchClue));

        // Count the total number of clues
        System.out.println("Total clues in the tree: " + clueTree.count());
    }
}
