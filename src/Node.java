public class Node<T> {

	private T data;
	
	private double prob;
	
	private int steps;
	
	public Node(T n, double probability, int steps)
	{
		data = n;
		
		prob = probability;
		
		this.steps = steps;
	}

	public T getValue() {
		return data;
	}
	
	public double getProb() {
		
		return prob;
	}
	
	public int getSteps() {
		
		return steps;
	}
	
}