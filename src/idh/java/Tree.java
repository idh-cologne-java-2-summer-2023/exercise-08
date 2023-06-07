package idh.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Tree<T> {

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

	public void addSpaces() {
		if (this.value instanceof String) {
			this.value = (T) ("  " + (String) this.value);
			for (Tree<T> child : children) 
				child.addSpaces();
		}
	}

	public Set<Tree<T>> children() {
		return children;
	}
	
	public void dfs() {
		System.out.println(this.value);
		for (Tree<T> child : children) {
			child.addSpaces();
			child.dfs();
		}
	}
	
	public static void main(String[] args) {

		Tree<String> ebike = new Tree<String>("e-bike");
		Tree<String> tandem = new Tree<String>("tandem");
		Tree<String> bike = new Tree<String>("bike");
		Tree<String> buggy = new Tree<String>("buggy");
		Tree<String> wheeled_vehicle = new Tree<String>("wheeled vehicle");
	//	Tree<String> batmobil = new Tree<String>("batmobil");
	//	Tree<String> fahrrad = new Tree<String>("fahrrad");
	//	Tree<String> einrad = new Tree<String>("einrad");

		wheeled_vehicle.children().add(bike);
		wheeled_vehicle.children().add(buggy);
		bike.children().add(tandem);
		bike.children().add(ebike);
	//	wheeled_vehicle.children().add(batmobil);
	//	bike.children().add(fahrrad);
	//	fahrrad.children().add(einrad);

		wheeled_vehicle.dfs();
	}

}
