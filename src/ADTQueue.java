
public class ADTQueue {

	private Gene head;
	private Gene tail;
	
	private int length;
	
	public ADTQueue()
	{
		head = new Gene();
		tail = new Gene();
		
		head.setNext(tail);
		tail.setPrev(head);
		
		length = 0;
	}
	
	@Override
	public void enqueue(NodeClass<T> n) {

		NodeClass<T> temp = head.getNext();
		
		head.setNext(n);
		n.setPrev(head);
		n.setNext(temp);
		temp.setPrev(n);
		
		length += 1;
	}

	@Override
	public NodeClass<T> dequeue() {
		
		NodeClass<T> temp = tail.getPrev();
		
		temp.getPrev().setNext(tail);
		tail.setPrev(temp);
		
		length -= 1;
		
		return temp;
	}

	@Override
	public NodeClass<T> peek() {

		return tail.getPrev();
	}

	@Override
	public int size() {

		return length;
	}

	@Override
	public boolean isEmpty() {

		if (length > 0)
			return false;
		else if (length == 0)
			return true;
		
		return true;
	}
	
	@Override
	public String toString() {
		
		String s = "";
		
		NodeClass<T> temp = tail;
		
		for (int i = length; i > 0; i -= 1)
		{
			temp = temp.getPrev();
			s += temp + " ";
		}
		
		return s;
	}
}
