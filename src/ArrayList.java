
public class ArrayList<T> {
	
	private Node<T>[] list;
	
	private int length;

	public ArrayList()
	{
		int listLength = 30000;
		
		length = 0;
		
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
	
	public void removeNode(Node<T> n) {
		
		int index = 0;
		
		for (int i = 0; i < list.length; i += 1)
		{
			if (list[i].toString() == n.toString())
			{
				index = i;
				
				break;
			}
		}
		
		for (int x = index; x < list.length - 1; x += 1)
		{
			list[x] = list[x + 1];
		}
		
		list[list.length - 1] = null;

	}
	
	
	public Node<T> removeNode(int i) {
		
		Node<T> n = list[i];
		
		for (int x = i; x < list.length - 1; x += 1)
		{
			list[x] = list[x + 1];
		}
		
		list[list.length - 1] = null;
		
		return n;
	}
	
	
	public Node<T> getNode(int i) {
	
		return list[i];
	}

	
	public int size() {
		return list.length;
	}

}
