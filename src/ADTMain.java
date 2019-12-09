import java.io.FileNotFoundException;

public class ADTMain {
	
	public static void main(String[] args) throws FileNotFoundException {

		// BFS, you know as soon as you find a possibility it is the biggest, as the more levels there are, 
		// the smaller the probability is for sure, as the probabilities are so small that basically the more 
		// levels, the smaller the probability

		// If number of steps reaches M, or gene reaches target gene, stop applying new mutations.
		
		// Go as deep as possible, if at one point you hit the target gene, calculate the probability of that sequence, save it to an array.
		// Then go back one step, then go as deep as possible again, repeat. Keep going back, then going deep until youve found all possible
		// sequences. Then find the one with the least amount of steps, or biggest probability.
		
		// Create list of genes you've already mutated into to show what you have already "visited"
		
		// Use DFS, create a string of the mutations you've done and the rule. EG:
		//AGT 1 TGA 3 TCGA
		
		// First big for loop is the 3 rules to apply, second for loop is applying the rules to all the adjacent indexes (rule 2 and 3)
		
		FileReader solver = new FileReader("InputFile.txt");

		String[] chemical = new String[] {"A", "G", "C", "T"}; // Array of the base chemicals
		
		
	}
	
	// Method used to mutate a gene using rule 1, 2 or 3
	public void Search(String P, String Q, int M) throws FileNotFoundException {
		
		ArrayQueue<Node> queue = new ArrayQueue(0);
		
		
		
		// Strings used for comparisons
		String part1;
		String part2;
		String part3;
		
		// Rule 1
	
		part1 = geneString.substring(0, 1);
		part2 = geneString.substring(1, geneString.length() - 1);
		part3 = geneString.substring(geneString.length() - 1);
		
		mutateTest = part3 + part2 + part1;
		
		// Adds all possible mutations to listMutate
		for (int i = 0; i < solver.validGenes.size(); i += 1)
		{
			if (mutateTest.equals(solver.validGenes.getNode(i)))
			{
				Node<Gene> mutation = new Node<Gene>(mutateTest, prob * 0.02);
				listMutate.addNode(mutation);
			}
		
		}
	
		
		// Rule 2
		for (int i = 0; i < geneString.length() - 1; i += 1)
		{	
			if (geneString.charAt(i) == geneString.charAt(i + 1))
			{
				// Checks if the mutated gene is valid
				
				part1 = geneString.substring(0, i);
				part2 = geneString.substring(i + 2);
				
				for (int x = 0; x < chemical.length; x += 1)
				{
					mutateTest = part1 + chemical[x] + part2;
					
					for (int j = 0; j < solver.validGenes.size(); j += 1)
					{
						if (mutateTest.equals(solver.validGenes.getNode(x)))
						{
							Node<String> mutation = new Node<String>(mutateTest);
							listMutate.addNode(mutation);
						}
					}
					
				}
			}
			
		}
		
		
		// Rule 3
		for (int i = 0; i < geneString.length() - 1; i += 1)
		{
			if ((geneString.charAt(i) == 'G' && geneString.charAt(i + 1) == 'T') || (geneString.charAt(i) == 'T' && geneString.charAt(i + 1) == 'G'))
			{
				part1 = geneString.substring(0, i + 1);
				part2 = geneString.substring(i + 1);
				
				for (int x = 0; x < chemical.length; x += 1)
				{
					mutateTest = part1 + chemical[x] + part2;
					
					for (int j = 0; j < solver.validGenes.size(); j += 1)
					{
						if (mutateTest.equals(solver.validGenes.getNode(x)))
						{
							Node<String> mutation = new Node<String>(mutateTest);
							listMutate.addNode(mutation);
						}
					}
				}
			}
		}
	}
	
}
