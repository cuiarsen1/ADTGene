import java.io.FileNotFoundException;

public class Gene {
	
	private String geneString; // String containing the gene itself
	
	private ArrayList<String> listMutate; // List of possible valid/disease mutations to change to in one step
	
	private String mutateTest; // String used to test possible mutations
	
	String[] chemical; // Array of the base chemicals
	
	FileReader solver; // Used to access variables of the Filesolver class
	
	public Gene(String s) throws FileNotFoundException // validGenes is list of valid and disease genes you get from file
	{
		geneString = s;
		
		listMutate = new ArrayList<String>(0);
		
		chemical = new String[] {"A", "G", "C", "T"};
		
		solver = new FileReader("InputFile.txt");
		
	}
	
	// Method used to mutate a gene using rule 1, 2 or 3
	public void BFS(String P, String Q, int M) throws FileNotFoundException {
		
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
				Node<String> mutation = new Node<String>(mutateTest);
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
		
	
	
	public String toString() {
		return geneString;
	}
	
}
