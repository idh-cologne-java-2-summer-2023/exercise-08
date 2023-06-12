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
	
	//Aufgabe 1
	//dfs soll Knoten steuern, damit die Ausgabe strukturiert stattfinden kann 
	public void dfs(int knotenSteuern) {
		  StringBuilder knoten = new StringBuilder();
			for (int i = 0; i < knotenSteuern; i++) {
		        knoten.append("  "); // Fügt zwei Leerzeichen pro Hierarchieebene hinzu
		    }
			//toString soll die Ausgabe ermöglichen 
		    System.out.println(knoten + this.value.toString());
		    for (Tree<T> child : children) {
		        child.dfs(knotenSteuern + 1);
		    }
		    
		    //Leider habe ich es nicht hinbekommen, die Aussagebe so anzuordnen wie vorgegeben
		    //In meinem Code kommen buggy und bike als erstes 
		    //Ich habe versucht die Anordnung zu ändern, doch leider war diese ebenfalls fehlerhaft
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
		
		//Null wurde eingefügt, da dfs nicht statisch ist 
		wheeled_vehicle.dfs(0);
	}

}
