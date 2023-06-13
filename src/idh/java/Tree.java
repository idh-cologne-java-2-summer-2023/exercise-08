package idh.java;

import java.util.*;

public class Tree<T>  {

	T value;
	Set<Tree<T>> children;
	List<Tree<T>> parents; //Referenz auf Elternknoten (wir wollen wissen wie viele hat das child)
	
	public Tree(T value) {
		this.value = value;
		this.children = new HashSet<Tree<T>>();
		this.parents = new ArrayList<Tree<T>>();
	}
	
	public Tree(T value, Collection<Tree<T>> children) {
		this.value = value;
		this.children = new HashSet<Tree<T>>(children);
		this.parents = new ArrayList<Tree<T>>();
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

	public void addChild(Tree<T> child) {
		child.parents.add(this);
		children.add(child);
	}
	/*public int countParents() {
		return parents.size();
	}*/

	public void dfs(int i) {

		String spaces = " ".repeat(i);
		System.out.println(spaces + this.value);
		for (Tree<T> child : children) {
			//i = child.countParents();
			child.dfs(i + 1);
		}
	}
	
	
	public static void main(String[] args) {
		
		Tree<String> ebike = new Tree<String>("e-bike");
		Tree<String> tandem = new Tree<String>("tandem");
		Tree<String> bike = new Tree<String>("bike");
		Tree<String> buggy = new Tree<String>("buggy");
		Tree<String> wheeled_vehicle = new Tree<String>("wheeled vehicle");

		/*wheeled_vehicle.children().add(bike);
		wheeled_vehicle.children().add(buggy);
		bike.children().add(tandem);
		bike.children().add(ebike);*/

		wheeled_vehicle.addChild(bike);
		wheeled_vehicle.addChild(buggy);
		bike.addChild(tandem);
		bike.addChild(ebike);
		
		wheeled_vehicle.dfs(0);
	}

}
