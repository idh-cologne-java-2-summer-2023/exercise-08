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
	
	
//	public void dfs(int abstand) {
//		for (int i = 0; i < abstand; i++) {
//			System.out.println("\t");
//		}
//		
//		System.out.println(this.value);
//		for (Tree<T> child : children) {
//			child.dfs(abstand++);
//		}
//	}
	
	public void dfs(int abstand) {
        for (int i = 0; i < abstand; i++) {
            System.out.print(" ");//Leerzeichen
        }

        System.out.println(this.value);

        for (Tree<T> child : children) {
            child.dfs(abstand + 1);
        }
    }
	
	
	//Jedes Element eines Baumes ist wieder ein Baum. Daher ist es eine Rekursive Datenstruktur
	//B und C sind ein Set, dass in A gespeichert ist
//	public void childmove() {
//		
//	}
	
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
		
		//for-each Children ein Leerzeichen einfügen?
		
		/*
		 * ChatGPT schlägt vor, rekursiv zu arbeiten --> Das ergibt sinn
		 */
		
		
	
		
		wheeled_vehicle.dfs(0);
	}

}
