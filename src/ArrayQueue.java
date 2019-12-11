// Arsen Cui
// ICS4U1-01
// December 9th, 2019
// Mr. Radulovic
// ICS4U1 ADT Assignment
/*This class is used to create Queue objects, usually of Nodes. It is used when storing mutations 
of genes when using Breadth First Search. The default size is set to 20000 because there can only 
be at most 20000 objects stored in the queue at once, as the maximum specified amount of valid
and diseased genes is 20000. */

public class ArrayQueue<T> {
	
	private Node<T>[] queue; // Array used to implement the Queue
	
	private int length; // tracks the amount of items in the queue
	
	public ArrayQueue()
	{
		int queueSize = 20000; // size of the array
		
		queue = new Node[queueSize];
		
		length = 0;
	}
	
	// adds a node to the end of the queue
	public void enqueue(Node<T> n) {
		
		queue[length] = n;
		
		length += 1;
		
	}

	// removes the first node from the queue
	public Node<T> dequeue() {
		
		Node<T> node = queue[0]; // node to be dequeued
		
		// Shifts all the nodes in the queue back by one to get rid of the first node, removing it
		for (int i = 0; i < length; i += 1)
		{
			queue[i] = queue[i + 1];
		}
		
		length -= 1;
		
		return node;
		
	}
	
	// returns the first node of the queue
	public Node<T> peek() {
		
		return queue[0];
	
	}

	// returns the size of the queue
	public int size() {
		
		return length;
	}

	// returns true if the queue is empty, false if it is not empty
	public boolean isEmpty() {
		
		if (length > 0)
			return false;
		else if (length == 0)
			return true;
		
		return true;
	}
	
}
