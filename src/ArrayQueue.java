
public class ArrayQueue<T> {
	
	private ArrayList<T> queue;
	
	private int length;
	
	public ArrayQueue(int n)
	{
		queue = new ArrayList();
	}
	
	public void enqueue(Node<T> start) {

		ArrayList<T> temp = queue;
		
		queue = new ArrayList();
		
		for (int i = 0; i < temp.size(); i += 1)
		{
			queue[i + 1] = temp[i];
		}
		
		queue.addNode(start);
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
		
		return queue.getNode(queue.size() - 1);
		
	}

	
	public int size() {

		return queue.size();
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
