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
	
	
	public void dfs(int depth) {
			for(int i = depth; i > 0; i--) {
				System.out.print("  ");
			}
			System.out.println(this.value);
		    for (Tree<T> child : children) {
		        child.dfs(depth + 1);
		    }
	}
	
	
	public static void main(String[] args) {
		
		Tree<String> ebike = new Tree<String>("e-bike");
		Tree<String> tandem = new Tree<String>("tandem");
		Tree<String> bike = new Tree<String>("bike");
		Tree<String> unicyle = new Tree<String>("unicyle");
		Tree<String> wheeled_vehicle = new Tree<String>("wheeled vehicle");
		Tree<String> car = new Tree<String>("car");
		Tree<String> sedan = new Tree<String>("sedan");
		Tree<String> convertible = new Tree<String>("convertible");
		Tree<String> EV = new Tree<String>("EV");
		
		wheeled_vehicle.children().add(bike);
		wheeled_vehicle.children().add(unicyle);
		bike.children().add(tandem);
		bike.children().add(ebike);
		wheeled_vehicle.children().add(car);
		car.children().add(sedan);
		car.children().add(convertible);
		car.children().add(EV);
		
		wheeled_vehicle.dfs(0);
	}

}
