import java.io.FileNotFoundException;

public class Gene {
	
	private String geneString; // String containing the gene itself
	
	private ADTQueue listMutate; // List of possible valid/disease mutations to change to in one step
	
	private String mutateTest; // String used to test possible mutations
	
	String[] chemical; // Array of the base chemicals
	
	FileReader reader; // Used to access variables of the FileReader class
	
	public Gene(String s) throws FileNotFoundException // validGenes is list of valid and disease genes you get from file
	{
		geneString = s;
		
		listMutate = new ADTQueue();
		
		chemical = new String[] {"A", "G", "C", "T"};
		
		reader = new FileReader("InputFile.txt");
		
	}
	
	// Method used to mutate a gene using rule 1, 2 or 3
	public void mutateGene(String s, int n) throws FileNotFoundException {
		
		// Strings used for comparisons
		String part1;
		String part2;
		String part3;
		
		// Rule 1
		if (n == 1)
		{
			part1 = geneString.substring(0, 1);
			part2 = geneString.substring(1, geneString.length() - 1);
			part3 = geneString.substring(geneString.length() - 1);
			
			mutateTest = part3 + part2 + part1;
			
			// Adds all possible mutations to listMutate
			for (int i = 0; i < reader.validGenes.length; i += 1)
			{
				if (mutateTest.equals(reader.validGenes[i]))
				{
					Gene mutation = new Gene(mutateTest);
					listMutate.enqueue(mutation);
				}
			
			}
		}
		
		// Rule 2
		if (n == 2)
		{
			for (int i = 0; i < geneString.length() - 1; i += 1)
			{	
				if (geneString.charAt(i) == geneString.charAt(i + 1))
				{
					// Checks if mutated gene is valid in the case where the first two adjacent chemicals in the gene are equal
					/*if (i == 0)
					{
						// loops through all the base chemicals to perform the replacement 
						for (int x = 0; x < chemical.length; x += 1)
						{
							// loops through all the valid and diseased genes that can be converted into
							for (int j = 0; j < reader.validGenes.length; j += 1)
							{
								mutateTest = chemical[x] + geneString.substring(2, geneString.length());
								
								if (mutateTest.equals(reader.validGenes[j]))
								{
									Gene mutation = new Gene(mutateTest);
									listMutate.enqueue(mutation);
								}
							}
						}
						
						
					}*/
					
					// Checks if the mutated gene is valid
					
					part1 = geneString.substring(0, i);
					part2 = geneString.substring(i + 2);
					
					for (int x = 0; x < chemical.length; x += 1)
					{
						mutateTest = part1 + chemical[x] + part2;
						
						for (int j = 0; j < reader.validGenes.length; j += 1)
						{
							if (mutateTest.equals(reader.validGenes[x]))
							{
								Gene mutation = new Gene(mutateTest);
								listMutate.enqueue(mutation);
							}
						}
						
					}
				}
				
			}
		}
		
		// Rule 3
		if (n == 3)
		{
			for (int i = 0; i < geneString.length() - 1; i += 1)
			{
				if ((geneString.charAt(i) == 'G' && geneString.charAt(i + 1) == 'T') || (geneString.charAt(i) == 'T' && geneString.charAt(i + 1) == 'G'))
				{
					part1 = geneString.substring(0, i + 1);
					part2 = geneString.substring(i + 1);
					
					for (int x = 0; x < chemical.length; x += 1)
					{
						mutateTest = part1 + chemical[x] + part2;
						
						for (int j = 0; j < reader.validGenes.length; j += 1)
						{
							if (mutateTest.equals(reader.validGenes[x]))
							{
								Gene mutation = new Gene(mutateTest);
								listMutate.enqueue(mutation);
							}
						}
					}
				}
			}
		}
		
	}
	
	public String getValue() {
		return geneString;
	}
	
	/*public class Gene {
		public static ArrayList<String> rule(String G, int n){
			String[] valid = {"AGT","AGG","AC","GTT","GGC","GAC","GGA","CAG","GATT","TGG"};
			ArrayList<String> Gene = new ArrayList<String>();
			String[] base = {"A","G","C","T"};
			if(n == 1) {
			String result = G.charAt(G.length()-1) + G.substring(1, G.length()-1) + G.charAt(0);
			for (int j = 0; j < valid.length;j++) {
				if (valid[j].equals(result))
					Gene.add(result);
			}
			return Gene;
			}
			else if(n == 2) {
				for(int m = 0; m<G.length()-1;m++) {
					if(G.charAt(m) == G.charAt(m+1)) {
							for(int i = 0; i<base.length;i++) {
								String result = G.substring(0, m)+base[i]+G.substring(m+2, G.length());
								for (int j = 0; j < valid.length;j++) {
									if (valid[j].equals(result))
										Gene.add(result);
								}
							}
					}
				}
			
			return Gene;
			}
			else if(n == 3) {
				for(int m = 0; m<G.length()-1;m++) {
					if((G.charAt(m) == 'G')&& (G.charAt(m+1) == 'T')||(G.charAt(m) == 'T')&& (G.charAt(m+1) == 'G')) {
							for(int i = 0; i<base.length;i++) {
								String result = G.substring(0, m+1)+base[i]+G.substring(m+1, G.length());
								for (int j = 0; j < valid.length;j++) {
									if (valid[j].equals(result))
										Gene.add(result);
								}
							}
					}
				}
			return Gene;
			}
			return Gene;
		}
		public static void main(String[] args) {
			String G = "GTT";
			System.out.println(rule("GTT",2));
		} */
	
	
}
