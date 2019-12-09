public class Node<T> {

	private T data;
	
	private double prob;
	
	public Node(T n, double probability)
	{
		data = n;
		
		prob = probability;
	}

	public T getValue() {
		return data;
	}
	
}

FIGURE OUT A WAY TO COMBINE NODE AND GENE INTO ONE. THEY SEEM TO BE THE SAME THING