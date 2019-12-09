
public class ArrayQueue<T> {
	
	private Node<T>[] queue;
	
	public ArrayQueue(int n)
	{
		queue = new Node[n];
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
	
	
	
	public String toString() {
		
		String s = "";
		
		for (int i = queue.length - 1; i >= 0; i -= 1)
		{
			s += queue[i] + " ";
		}
		
		return s;
	}

	/*public static void main(String[] args) {

		ArrayQueue<Integer> list = new ArrayQueue(0);
		
		list.enqueue(new Node(1));
		list.enqueue(new Node(2));
		list.enqueue(new Node(3));
		
		list.dequeue();
		
		System.out.println(list.size());
		
		System.out.println(list);
	}*/


}
