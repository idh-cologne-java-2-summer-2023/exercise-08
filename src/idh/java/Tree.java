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
	
	
	//Tree Values first converted to Strings, a new lines is added on every Indentation. Space before Child Objects gets replaced with indentation.
	
	public String dfs() {
		StringBuilder sb = new StringBuilder(this.value.toString());
		for (Tree<T> child : children) {
			sb.append("\n");
			sb.append(child.dfs().replaceAll("(?m)^","   "));
		}
		return sb.toString();
	}
	// Class notes
//	public class Tree<T> {
//		T value;
//		Set<Tree<T>> children; 
//		
//		public tree(T value) {
//			this.value = value;
//			children = new HashSet<Tree<T>>();
//		}
//		
//		public set<<T>> children() {
//			return children;
//		}
// 	}
//	
// Class notes
	
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
		
		System.out.println(wheeled_vehicle.dfs());
		

	}

}
