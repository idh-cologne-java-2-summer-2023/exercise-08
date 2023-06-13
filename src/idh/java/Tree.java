package idh.java;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private T data; // Data stored in the node
    private List<Tree<T>> children; // List of child nodes

    // Constructor to initialize the node with data
    public Tree(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    // Getter for the data
    public T getData() {
        return data;
    }

    // Method to add a child node to the current node
    public List<Tree<T>> children() {
        return children;
    }

    // Depth-first search (DFS) traversal of the tree with indentation
 // Depth-first search (DFS) traversal of the tree with indentation
    public void dfs(int depth) {
        // Create the indentation string based on the current depth
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indentation.append("  "); // Add two spaces for each level of depth
        }

        // Print the indented data of the current node
        System.out.println(indentation.toString() + data);

        // Recursively traverse and print the children nodes with increased depth
        for (Tree<T> child : children) {
            child.dfs(depth + 1);
        }
    }


    public static void main(String[] args) {
        Tree<String> ebike = new Tree<String>("e-bike");
        Tree<String> tandem = new Tree<String>("tandem");
        Tree<String> bike = new Tree<String>("bike");
        Tree<String> buggy = new Tree<String>("buggy");
        Tree<String> wheeled_vehicle = new Tree<String>("wheeled vehicle");

        wheeled_vehicle.children().add(bike);
        wheeled_vehicle.children().add(buggy);
        bike.children().add(tandem);
        bike.children().add(ebike);

        wheeled_vehicle.dfs(0);
    }
}
