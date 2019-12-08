import java.io.FileNotFoundException;

public class ADTMain {
	
	public static void main(String[] args) throws FileNotFoundException {

		// BFS, you know as soon as you find a possibility it is the biggest, as the more levels there are, 
		// the smaller the probability is for sure, as the probabilities are so small that basically the more 
		// levels, the smaller the probability
		
		/*Generate a random mutation, compare to the list of valid and disease genes, if it doesnt exist, 
		get rid of it. If it does, add it to list of possible mutations for that gene.*/

		// If number of steps reaches M, or gene reaches target gene, stop applying new mutations.
		
		// Go as deep as possible, if at one point you hit the target gene, calculate the probability of that sequence, save it to an array.
		// Then go back one step, then go as deep as possible again, repeat. Keep going back, then going deep until youve found all possible
		// sequences. Then find the one with the least amount of steps, or biggest probability.
		
		// Create list of genes you've already mutated into to show what you have already "visited"
		
		// Use DFS, create a string of the mutations you've done and the rule. EG:
		//AGT 1 TGA 3 TCGA
		
		// First big for loop is the 3 rules to apply, second for loop is applying the rules to all the adjacent indexes (rule 2 and 3)
		
		// 2D array, first index is the parent gene, second index is the gene it mutates into.
		
		
	}

}
