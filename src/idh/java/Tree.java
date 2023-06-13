package idh.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Tree<T>  {

	T value;
	Set<Tree<T>> children;
	
	public Tree(T value) {
		this.value = value;
		this.children = new HashSet<Tree<T>>();
	}
	
	public Tree(T value, Collection<Tree<T>> children) {
		this.value = value;
		this.children = new HashSet<Tree<T>>(children);
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
	
	
	public void dfs() {
		System.out.println(this.value);
		for (Tree<T> child : children) {
			System.out.print("\t");
			child.dfs();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Tree<String> ebike = new Tree<String>("\t e-bike");
		Tree<String> tandem = new Tree<String>("\t tandem");
		Tree<String> buggy = new Tree<String>("buggy");
		Tree<String> bike = new Tree<String>("bike");
		Tree<String> wheeled_vehicle = new Tree<String>("wheeled vehicle");

		wheeled_vehicle.children().add(buggy);
		wheeled_vehicle.children().add(bike);
		bike.children().add(tandem);
		bike.children().add(ebike);
		
		wheeled_vehicle.dfs();
	}

}
