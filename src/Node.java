public class Node<T> {

	private T data;
	
	private double prob;
	
	int steps;
	
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

//FIGURE OUT A WAY TO COMBINE NODE AND GENE INTO ONE. THEY SEEM TO BE THE SAME THING