
public class ArrayList<T> {
	
	private Node<T>[] list;
	
	public ArrayList()
	{
		int listLength = 0;
		
		list = new Node[listLength];
	}
	
	public void addNode(Node<T> n) {
		
		Node<T>[] listTemp = list;
		
		int newSize = list.length + 1;
		
		list = new Node[newSize];
		
		for (int i = 0; i < listTemp.length; i += 1)
		{
			list[i] = listTemp[i];
		}
		
		list[newSize - 1] = n;
		
	}
	
	public void removeFirst(Node<T> n) {
		
		Node<T>[] listTemp = list;
		
		int newSize = list.length - 1;
		
		list = new Node[newSize];
		
		for (int x = 0; x < list.length - 1; x += 1)
		{
			list[x] = listTemp[x + 1];
		}

	}
	
	public Node<T> getNode(int i) {
	
		return list[i];
	}
	
	public void setValue(Node<T> n, int i) {
		
		list[i] = n;
	}

	public int size() {
		return list.length;
	}

}
