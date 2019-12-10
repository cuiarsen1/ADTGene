
public class ArrayList<T> {
	
	private Node<T>[] list;
	
	int length;
	
	public ArrayList()
	{
		int listLength = 20005;
		
		list = new Node[listLength];
		
		length = 0;
	}
	
	public void addNode(Node<T> n) {
		
		/*Node<T>[] listTemp = list;
		
		int newSize = list.length + 1;
		
		list = new Node[newSize];
		
		for (int i = 0; i < listTemp.length; i += 1)
		{
			list[i] = listTemp[i];
		}
		
		list[newSize - 1] = n;*/
		
		list[length] = n;
		
		length += 1;
		
	}
	
	public void removeFirst() {
		
		/*Node<T>[] listTemp = list;
		
		int newSize = list.length - 1;
		
		list = new Node[newSize];
		
		for (int x = 0; x < list.length - 1; x += 1)
		{
			list[x] = listTemp[x + 1];
		}*/
		
		Node<T> n = list[0];
		
		for (int i = 0; i < length; i += 1)
		{
			list[i] = list[i + 1];
		}
		
		length -= 1;
		
		list[length] = null;
		

	}
	
	public Node<T> getNode(int i) {
	
		return list[i];
	}
	
	public void setValue(Node<T> n, int i) {
		
		list[i] = n;
	}

	public int size() {
		//return list.length;
		return length;
	}

}
