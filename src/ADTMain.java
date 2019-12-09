import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ADTMain {
	
	String[] chemical = new String[] {"A", "G", "C", "T"}; // Array of the base chemicals
	
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

		ADTMain main = new ADTMain();

		
		File file = new File("InputFile.txt");
		
		Scanner scan = new Scanner(file);
		
		int L = scan.nextInt();
		
		int V = scan.nextInt();
		int D = scan.nextInt();
		
		ArrayList<String> validGenes = new ArrayList();
		
		for (int i = 0; i < validGenes.size(); i += 1)
		{
			validGenes.addNode(new Node(scan.nextLine(), 1));
		}
		
		int M = Integer.parseInt(scan.nextLine());
		
		int G = Integer.parseInt(scan.nextLine());
		
		ArrayList<String> testArray = new ArrayList(); // Creates array of the genes to test
		
		for (int i = 0; i < testArray.size(); i += 1)
		{
			String P = scan.next();
			String Q = scan.next();
		}
		
		
	}

	public void BFS(String P, String Q, int M, ArrayList<String> validGenes) throws FileNotFoundException {
		
		ArrayQueue<Node> queue = new ArrayQueue(0);
		
		Node start = new Node(P, 1, 0);
		
		queue.enqueue(start);
		
		ArrayList<String> successList = new ArrayList();
		
		while (!queue.isEmpty())
		{
			Node root = queue.peek(); // current root node
			
			for (int i = 1; i <= 3; i += 1) // runs through the 3 rules
			{
				ArrayList<String> listMutate = Mut(root, validGenes, i); // creates list of valid children
				
				if (listMutate.size() > 0)
				{
					if (listMutate.getNode(0).getSteps() < M) // if steps hasnt exceed M
					{
						for (int j = 0; j < listMutate.size(); j += 1) 
						{
							// if one of the children is equal to target gene, add it to the successList
							if (listMutate.getNode(j).getValue() == Q) 
							{
								successList.addNode(listMutate.getNode(i));
							}
							
							queue.enqueue(listMutate.getNode(j)); // 
						}
					}
				}
				
			}
			
			queue.dequeue();
			
			
		}
		
		/*public static void Mutation(){
			int num_mutation = 0;
			Node<String> start_gene = new Node<String>(test_case[0][0],1);
			Node<String> target_gene = new Node<String>(test_case[0][1],1);
			ArrayQueue <String> queue = new ArrayQueue <String>();
			ArrayList succeed = new ArrayList();
			queue.enqueue(start_gene);
			while(!queue.isEmpty()){
				Node<String> rootNode = queue.peek();
				for(int i = 1; i<=3;i++) {
					ArrayList<String> childrenList = rule(rootNode,i);
					for(int m = 0; m < childrenList.size(); m++) {
						if(childrenList.getNode(i).getValue() == target_gene.getValue()) {
							succeed.addNode(childrenList.getNode(i));
						}
						queue.enqueue(childrenList.getNode(i));
					}
				}queue.dequeue();
			}
			if(succeed.size()!=0) {
			System.out.println("Yes");
			double Largest_probability = succeed.getFirstNode().getChance();
			for(int m = 0; m < succeed.size(); m++) {
				if(Largest_probability < succeed.getNode(m).getChance()) {
					Largest_probability = succeed.getNode(m).getChance();
				}
			}
			System.out.println(Largest_probability);
			}else {
				System.out.println("No");
			}		
						
			}*/
		
		
	}
	
	public ArrayList<String> Mut(Node gene, ArrayList<String> validGenes, int n)
	{
		ArrayList<String> listMutate = new ArrayList(); // List of possible valid/disease mutations to change to in one step
		
		String geneString = gene.toString();
		
		double prob = gene.getProb();

		// Strings used for comparisons
		String part1;
		String part2;
		String part3;
		
		String mutateTest;
		
		if (n == 1)
		{
			part1 = geneString.substring(0, 1);
			part2 = geneString.substring(1, geneString.length() - 1);
			part3 = geneString.substring(geneString.length() - 1);
			
			mutateTest = part3 + part2 + part1;
			
			// Adds all possible mutations to listMutate
			for (int i = 0; i < validGenes.size(); i += 1)
			{
				if (mutateTest.equals(validGenes.getNode(i)))
				{
					Node mutation = new Node(mutateTest, prob * 0.02, gene.getSteps() + 1);
					listMutate.addNode(mutation);
				}
			
			}
		}
		
		if (n == 2)
		{
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
						
						for (int j = 0; j < validGenes.size(); j += 1)
						{
							if (mutateTest.equals(validGenes.getNode(x)))
							{
								Node mutation = new Node(mutateTest, prob * 0.06, gene.getSteps() + 1);
								listMutate.addNode(mutation);
							}
						}
						
					}
				}
				
			}
		}
		
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
						
						for (int j = 0; j < validGenes.size(); j += 1)
						{
							if (mutateTest.equals(validGenes.getNode(x)))
							{
								Node mutation = new Node(mutateTest, prob * 0.08, gene.getSteps() + 1);
								listMutate.addNode(mutation);
							}
						}
					}
				}
			}
		}
		
		return listMutate;
	
		
	}
	
}
