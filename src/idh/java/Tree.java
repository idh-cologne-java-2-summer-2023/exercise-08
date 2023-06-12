package idh.java;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class Tree<T> {

    T value;
    Set<Tree<T>> children;

    public Tree(T value) {
        this.value = value;
        this.children = new LinkedHashSet<>();
    }

    public Tree(T value, Collection<Tree<T>> children) {
        this.value = value;
        this.children = new LinkedHashSet<>(children);
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    public Set<Tree<T>> children() {
        return children;
    }

    public void dfs(int depth) {
        String indentation = "";
        for (int i = 0; i < depth; i++) {
            indentation += "  ";
        }
        System.out.println(indentation + this.value);
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
