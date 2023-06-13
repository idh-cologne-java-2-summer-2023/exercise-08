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
			child.dfs();
		}
	}

// identisch mit vorgegebener Funktion, nur Testzeilen hinzugefügt	
	public void dfsTest() {
		System.out.println("dfs() start");
		System.out.println(this.value);
		System.out.println("value printed");
		for (Tree<T> child : children) {
			System.out.println("started loop");
			child.dfsTest();
			System.out.println("finished dfs() in loop");
		}
		System.out.println("finished loop");
	}

// nicht geschafft, die Funktion so umzuschreiben, dass wie vorher kein Argument übergegenben wird
// verschiedene Ansätze, die ich versucht hatte, unten (keiner davon richtig)
	public void dfsVersion1() {
		int i = 0;
		System.out.println(this.value);
		for (Tree<T> child : children) {
			i++;
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			child.dfsVersion1();
		}
	}
	
	public void dfsVersion2() {
		System.out.println(this.value);
		for (Tree<T> child : children) {
			System.out.print("  ");
			child.dfsVersion2();
			System.out.print("  ");
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
		
		wheeled_vehicle.dfs();		
		wheeled_vehicle.dfsTest();
		wheeled_vehicle.dfsVersion1();
		wheeled_vehicle.dfsVersion2();
		
	}

}
