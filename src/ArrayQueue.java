
public class ArrayQueue<T> {
	
	private Node<T>[] queue;
	
	private int length;
	
	public ArrayQueue()
	{
		int queueSize = 0;
		
		queue = new Node[queueSize];
	}
	
	public void enqueue(Node<T> n) {

		Node<T>[] temp = queue;
		
		queue = new Node[temp.length + 1];
		
		for (int i = 0; i < temp.length; i += 1)
		{
			queue[i + 1] = temp[i];
		}
		
		queue[0] = n;
	}

	public Node<T> dequeue() {
		
		Node<T> object = queue[queue.length - 1];
		
		Node<T>[] temp = queue;
		
		queue = new Node[temp.length - 1];
		
		for (int i = 0; i < queue.length; i += 1)
		{
			queue[i] = temp[i];
		}
		
		return object;
		
	}
	
	public Node<T> peek() {
		
		return queue[queue.length - 1];
		
		
	}

	public int size() {

		return queue.length;
	}

	public boolean isEmpty() {

		if (queue.length > 0)
			return false;
		else if (queue.length == 0)
			return true;

		return true;
	}

}
