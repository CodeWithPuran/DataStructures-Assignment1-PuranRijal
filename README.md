# DataStructures-Assignment1-PuranRijal

Name: Puran Rijal <br>
Student ID: C0913528 <br>

### Overview

This repository contains the solutions to the coding challenges presented in the Data Structures Adventure assignment. Each challenge explores fundamental data structures and algorithms, focusing on their implementation and functionality. The challenges are as follows:

### Challenge 1: The Array Artifact

In this challenge, I implemented an `ArtifactVault` class to manage a collection of ancient artifacts using an array. The key functionalities include:

- Adding artifacts to the first empty slot in the array.
- Removing an artifact by its name, ensuring that the array remains organized.
- Searching for an artifact using linear and binary search techniques, where the binary search assumes the array is sorted by artifact age.

### Challenge 2: The Linked List Labyrinth

For the `LabyrinthPath` class, I utilized a singly linked list to represent a path through a labyrinth. This implementation allows for:

- Adding new locations to the path dynamically.
- Removing the last visited location, enabling backtracking.
- Checking for loops in the path to identify potential traps.
- Printing the entire path for review.

### Challenge 3: The Stack of Ancient Texts

The `ScrollStack` class was developed to manage a stack of ancient scrolls. The functionalities include:

- Pushing new scrolls onto the stack to store them.
- Popping the top scroll off the stack when it is no longer needed.
- Peeking at the top scroll without removing it for quick access.
- Checking if a specific scroll title exists in the stack for easy retrieval.

### Challenge 4: The Queue of Explorers

In the `ExplorerQueue` class, I implemented a circular queue to manage a lineup of explorers entering a temple. This class includes:

- Enqueuing new explorers to the back of the queue.
- Dequeuing explorers as they enter the temple.
- Displaying the next explorer in line for quick identification.
- Checking if the queue is full or empty to manage space effectively.

### Challenge 5: The Binary Tree of Clues

The `ClueTree` class represents a binary tree structure to store clues. The methods implemented include:

- Inserting new clues into the tree.
- Performing in-order, pre-order, and post-order traversals to explore the clues in various orders.
- Finding specific clues in the tree for retrieval.
- Counting the total number of clues stored in the tree.

## Assumptions and Design Decisions

- I assumed that the artifacts, scrolls, and clues would have unique identifiers (names or titles) to facilitate searching and removal operations.
- The data structures were chosen based on their suitability for the operations required: arrays for fixed-size collections, linked lists for dynamic paths, stacks for LIFO management, queues for FIFO management, and binary trees for hierarchical clue organization.
- I maintained clean and well-commented code to enhance readability and maintainability.

## Instructions to Run the Code

1. Clone the repository to your local machine:
