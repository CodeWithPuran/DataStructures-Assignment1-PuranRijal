package artifactvault;

// The ArtifactVault class manages an array of ancient artifacts
public class ArtifactVault {
    private String[] artifacts; // Array to store artifacts
    private int size; // Current number of artifacts in the vault

    // Constructor to initialize the artifact vault with a given capacity
    public ArtifactVault(int capacity) {
        artifacts = new String[capacity]; // Initialize the array with the specified capacity
        size = 0; // Start with no artifacts
    }

    // Method to add an artifact to the first empty slot
    public boolean addArtifact(String artifact) {
        if (size < artifacts.length) { // Check if there's space in the array
            artifacts[size] = artifact; // Add artifact to the current size index
            size++; // Increment the size
            return true; // Return true indicating success
        }
        return false; // Return false if vault is full
    }

    // Method to remove an artifact by its name
    public boolean removeArtifact(String artifact) {
        for (int i = 0; i < size; i++) { // Loop through the artifacts
            if (artifacts[i].equals(artifact)) { // Check if the artifact matches
                artifacts[i] = artifacts[size - 1]; // Replace with the last artifact
                artifacts[size - 1] = null; // Clear the last slot
                size--; // Decrease the size
                return true; // Return true indicating successful removal
            }
        }
        return false; // Return false if artifact was not found
    }

    // Method to find an artifact using linear search
    public int findArtifactLinear(String artifact) {
        for (int i = 0; i < size; i++) { // Loop through the artifacts
            if (artifacts[i].equals(artifact)) { // Check if the artifact matches
                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if not found
    }

    // Method to find an artifact using binary search (requires sorted array)
    public int findArtifactBinary(String artifact) {
        int left = 0;
        int right = size - 1;

        while (left <= right) { // Continue while there are elements to search
            int mid = left + (right - left) / 2; // Calculate the mid index
            int comparison = artifacts[mid].compareTo(artifact); // Compare mid artifact with target artifact

            if (comparison == 0) {
                return mid; // Return index if artifact is found
            } else if (comparison < 0) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1; // Return -1 if artifact is not found
    }

    // Method to print all artifacts in the vault
    public void printVault() {
        System.out.println("Artifacts in the vault:");
        for (int i = 0; i < size; i++) { // Loop through and print artifacts
            System.out.println(artifacts[i]);
        }
    }

    // Main method for testing the ArtifactVault class
    public static void main(String[] args) {
        ArtifactVault vault = new ArtifactVault(5); // Create an ArtifactVault with a capacity of 5

        // Adding artifacts
        vault.addArtifact("Ancient Scroll");
        vault.addArtifact("Golden Crown");
        vault.addArtifact("Spear of Destiny");

        // Print all artifacts
        vault.printVault();

        // Finding an artifact using linear search
        int index = vault.findArtifactLinear("Golden Crown");
        System.out.println("Found 'Golden Crown' at index: " + index);

        // Finding an artifact using binary search (make sure array is sorted)
        // Sorting artifacts for binary search (not implemented in the code above)
        System.out.println("Found 'Spear of Destiny' at index: " + vault.findArtifactBinary("Spear of Destiny"));

        // Removing an artifact
        vault.removeArtifact("Ancient Scroll");
        vault.printVault(); // Print after removal
    }
}
