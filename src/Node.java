// Arsen Cui
// ICS4U1-01
// December 9th, 2019
// Mr. Radulovic
// ICS4U1 ADT Assignment
/*Each Node object represents a gene. Each gene has to be initialized with 3 parameters: the string 
containing the gene sequence, the probability of getting to that gene through mutations, and the 
amount of steps it took to mutate to that gene.*/

public class Node<T> {

	private T data; // contains the string of the gene sequence
	
	private double prob; // tracks the probability of mutating to this specific gene
	
	private int steps; // tracks the amount of steps taken to mutate to this specific gene
	
	public Node(T n, double probability, int steps)
	{
		data = n;
		
		prob = probability;
		
		this.steps = steps;
	}

	// returns the string of the gene sequence
	public T getValue() {
		
		return data;
	}
	
	// returns the probability
	public double getProb() {
		
		return prob;
	}
	
	// returns the steps taken so far
	public int getSteps() {
		
		return steps;
	}
	
}