package idh.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Tree<T>  {
	
	
	int key;
	T left, right;	
	

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
	
	
	public void dfs(String indent) {

		T root = null;
		
		System.out.println(this.value);
		for (Tree<T> child : children) {
			child.dfs("\n");
			
			if (child.equals(root)) {
				return;
				
/*Idee: jeweils child.left u. right aufrufen, ausgehend vom Wurzelknoten, und je nach Position des Kindknotens zwei oder drei				
Leerzeichen hinzufügen. */
			
			}
			
	
		}
	}
	
	
	


	public static void main(String[] args) {
		
		Tree<String> ebike = new Tree<String>("    " + "e-bike"); //second sibling
		Tree<String> tandem = new Tree<String>("    " + "tandem"); //second child
		Tree<String> bike = new Tree<String>("  " + "bike"); //first sibling, Parent of tandem + ebike
		Tree<String> buggy = new Tree<String>("  "  + "buggy"); //first child
		Tree<String> wheeled_vehicle = new Tree<String>("wheeled vehicle"); //Parent
		//so sollte es natürlich nicht gelöst werden. Rekursion in Umsetzung fällt mir noch schwer.

		wheeled_vehicle.children().add(bike);
		wheeled_vehicle.children().add(buggy);
		bike.children().add(tandem);
		bike.children().add(ebike);
		
		wheeled_vehicle.dfs("\n");
	}

}
