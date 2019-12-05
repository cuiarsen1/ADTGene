
public class Gene {
	
	private String geneString;
	
	private String[] listMutate; // List of possible valid/disease mutations to change to in one step
	
	private String mutateTest; // String used to test possible mutations
	
	public Gene(String s, String[] validGenes)
	{
		geneString = s;
		
		// Rule 1
		
		String part1 = s.substring(0);
		String part2 = s.substring(1, s.length());
		String part3 = s.substring(s.length() - 1);
		
		mutateTest = part3 + part2 + part1;
		
		for (int i = 0; i < validGenes.length; i += 1)
		{
			if (mutateTest.equals(validGenes[i]))
			{
				
			}
			
		}
		
	}
	
	public String getValue() {
		return geneString;
	}
	
}
