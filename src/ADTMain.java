

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ADTMain {
	
	String[] chemical = new String[] {"A", "G", "C", "T"}; // Array of the base chemicals
	
	boolean[] visited; // Tracks if a valid gene has been visited already
	
	public static void main(String[] args) throws FileNotFoundException {

		ADTMain main = new ADTMain(); // Object used to access the methods in the ADTMain class
		
		File file = new File("EthanTest.txt");
		
		Scanner scan = new Scanner(file);
		
		int L = Integer.parseInt(scan.nextLine());
		int V = Integer.parseInt(scan.nextLine());
		int D = Integer.parseInt(scan.nextLine());
		
		String[] validGenes = new String[V + D];
		
		for (int i = 0; i < validGenes.length; i += 1)
		{
			validGenes[i] = scan.nextLine();
		}
		
		main.visited = new boolean[validGenes.length];
		
		int M = Integer.parseInt(scan.nextLine());
		
		int G = Integer.parseInt(scan.nextLine());
		
		String[][] testArray = new String[G][G]; // Creates array of the genes to test. The first item will be the gene you start at, the second item will be the target gene.
		
		for (int i = 0; i < testArray.length; i += 1)
		{
			String P = scan.next();
			String Q = scan.next();
			
			testArray[i][0] = P;
			testArray[i][1] = Q;
		}

		for (int i = 0; i < G; i += 1)
		{
			double probability = main.BFS(testArray[i][0], testArray[i][1], M, validGenes);
			
			if (probability > 0)
			{
				System.out.println("YES");
				System.out.println(probability);
			}
			
			else if (probability == 0)
			{
				System.out.println("NO");
			}
		}
		
	}

	public double BFS(String P, String Q, int M, String[] validGenes) throws FileNotFoundException {
		
		ArrayQueue<Node> queue = new ArrayQueue();
		
		Node start = new Node(P, 1, 0); // Initializes P, the gene to test
		
		queue.enqueue(start);
		
		ArrayList<Node> successList = new ArrayList();
		
		while (!queue.isEmpty())
		{
			Node root = queue.peek(); // current root gene
			
			for (int i = 1; i <= 3; i += 1) // runs through the 3 rules
			{
				ArrayList listMutate = Mut(root, validGenes, i); // creates list of valid children
				
				if (listMutate.size() > 0) // If there are mutations possible for this root gene
				{
					if (listMutate.getNode(0).getSteps() < M) // if steps hasn't exceeded M
					{
						for (int j = 0; j < listMutate.size(); j += 1)
						{
							// if one of the mutated genes is equal to target gene, store it
							if (listMutate.getNode(j).getValue().equals(Q)) 
							{
								successList.addNode(listMutate.getNode(j));
							}
							
							queue.enqueue(listMutate.getNode(j)); // adds the valid gene mutations to the queue
						}
					}
					
					else 
						break;
				}
				
			}
			
			queue.dequeue();
		}
		
		double probability = 0;
		
		for (int i = 0; i < successList.size(); i += 1)
		{
			if (successList.getNode(i).getProb() > probability)
			{
				probability = successList.getNode(i).getProb();
			}
		}
		
		return probability;
		
	}
		
	public ArrayList<String> Mut(Node<String> gene, String[] validGenes, int n)
	{
		ArrayList<String> listMutate = new ArrayList(); // List of possible valid/disease mutations to change to in one step
		
		String geneString = gene.getValue();
		
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
			for (int i = 0; i < validGenes.length; i += 1)
			{
				if (mutateTest.equals(validGenes[i]) && visited[i] == false)
				{
					Node mutation = new Node(mutateTest, prob * 0.02, gene.getSteps() + 1);
					listMutate.addNode(mutation);
					visited[i] = true;
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
						
						for (int j = 0; j < validGenes.length; j += 1)
						{
							if (mutateTest.equals(validGenes[j]) && visited[j] == false)
							{
								Node mutation = new Node(mutateTest, prob * 0.06, gene.getSteps() + 1);
								listMutate.addNode(mutation);
								visited[j] = true;
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
						
						for (int j = 0; j < validGenes.length; j += 1)
						{
							if (mutateTest.equals(validGenes[j]) && visited[j] == false)
							{
								Node mutation = new Node(mutateTest, prob * 0.08, gene.getSteps() + 1);
								listMutate.addNode(mutation);
								visited[j] = true;
							}
						}
					}
				}
			}
		}
		
		return listMutate;
	
		
	}
	
}