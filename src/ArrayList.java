// Arsen Cui
// ICS4U1-01
// December 9th, 2019
// Mr. Radulovic
// ICS4U1 ADT Assignment
/*This class is used to create ArrayList objects, usually of Nodes. It is used when storing 
mutations of genes during calculations. The default size is set to 20000 because there can only be 
at most 20000 objects stored in the arraylist at once, as the maximum specified amount of valid and 
diseased genes is 20000. */

public class ArrayList<T> {
	
	private Node<T>[] list; // Array used to implement the ArrayList
	
	int length; // tracks the amount of items in the arraylist
	
	public ArrayList()
	{
		int listLength = 20000; // size of the array
		
		list = new Node[listLength];
		
		length = 0;
	}
	
	// Adds a node to the end of the arraylist
	public void addNode(Node<T> n) {
		
		list[length] = n;
		
		length += 1;
		
	}
	
	// returns the node at the given index i
	public Node<T> getNode(int i) {
	
		return list[i];
	}
	
	// sets a value n to the current index i
	public void setValue(Node<T> n, int i) {
		
		list[i] = n;
	}

	// returns the length of the arraylist
	public int size() {
		
		return length;
	}

}
