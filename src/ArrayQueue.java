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
	
	/*Tracks the amount of empty indexes at the front of the queue. This is used
	so that there is no need to recreate a new queue every time a node is removed*/
	private int frontRemoved; 
	
	public ArrayQueue()
	{
		int queueSize = 20000; // size of the array
		
		queue = new Node[queueSize];
		
		length = 0;
		
		frontRemoved = 0;
	}
	
	// adds a node to the end of the queue
	public void enqueue(Node<T> n) {
		
		queue[length + frontRemoved] = n;
		
		length += 1;
		
	}

	// removes the first node from the queue
	public Node<T> dequeue() {
		
		Node<T> node = queue[frontRemoved]; // node to be dequeued
		
		queue[frontRemoved] = null; // remove the node
		
		length -= 1;
		
		// increases the amount of indexes to skip at the beginning of the queue, as they are empty
		frontRemoved += 1; 
		
		return node;
		
	}
	
	// returns the first node of the queue
	public Node<T> peek() {
		
		return queue[frontRemoved];
	
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
