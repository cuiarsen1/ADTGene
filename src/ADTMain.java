// Arsen Cui
// ICS4U1-01
// December 9th, 2019
// Mr. Radulovic
// ICS4U1 ADT Assignment
/*This program uses the properties of how genes can mutate into other genes. It reads in a list of 
valid and diseased genes, and given input for test cases, the program outputs whether a given gene
P can mutate into a given gene Q in a specific amount of steps M, following 3 specific mutation 
rules. Each of the 3 rules have a different probability of occurring. If it is possible for P to 
mutate into Q, the program outputs "YES" along with the largest probability of that mutation 
sequence occurring. If it is not possible for P to mutate into Q, the program outputs "NO".*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ADTMain {
	
	private boolean[] visited; // Booleans that track if a valid gene has been visited already
	
	public static void main(String[] args) throws FileNotFoundException {

		ADTMain main = new ADTMain(); // Object used to access the methods in the ADTMain class
		
		File file = new File("FILE PATH HERE"); // initializes the file input
		
		Scanner scan = new Scanner(file); // scanner used to read the file
		
		/*Reads in maximum length of each gene, L, amount of
		valid genes, V, and amount of diseased genes, D*/
		int L = Integer.parseInt(scan.nextLine());
		int V = Integer.parseInt(scan.nextLine());
		int D = Integer.parseInt(scan.nextLine());
		
		// array storing all of the valid and disease genes a gene is able to mutate into
		String[] validGenes = new String[V + D];
		
		// Adds all the valid and disease genes to validGenes
		for (int i = 0; i < validGenes.length; i += 1)
		{
			validGenes[i] = scan.nextLine();
		}
		
		main.visited = new boolean[validGenes.length];
		
		// Reads in the maximum amount of allowable mutations, M, and amount of test cases, G
		int M = Integer.parseInt(scan.nextLine());
		int G = Integer.parseInt(scan.nextLine());
		
		/*Creates 2D array of the genes to test. The first item will be the gene 
		you start at, P, and the second item will be the target gene, Q*/
		String[][] testArray = new String[G][G]; 
		
		// Adds all the test cases to testArray
		for (int i = 0; i < testArray.length; i += 1)
		{
			String P = scan.next();
			String Q = scan.next();
			
			testArray[i][0] = P;
			testArray[i][1] = Q;
		}
		
		/*for each test case, find out if the starting gene P
		can mutate into the target gene Q within M steps*/
		for (int i = 0; i < G; i += 1)
		{
			// calculates the largest probability P can mutate into Q
			double probability = main.Search(testArray[i][0], testArray[i][1], M, validGenes);
			
			// If P can successfully mutate into Q, print the largest probability of doing so
			if (probability > 0)
			{
				System.out.println("YES");
				System.out.println(probability);
			}
			
			// If P cannot mutate into Q, print "NO"
			else if (probability == 0)
			{
				System.out.println("NO");
			}
			
			// resets the valid genes to be not visited for the next test case
			main.visited = new boolean[validGenes.length];
		}
		
	}
	
	/*Method used to find whether it is possible for gene P to mutate 
	into gene Q, and outputs the largest probability of it occurring*/
	public double Search(String P, String Q, int M, String[] validGenes) 
			throws FileNotFoundException {
		
		ArrayQueue<Node> queue = new ArrayQueue();
		
		int initialProb = 1; // the probability every starting gene is initialized with
		int initialSteps = 0; // the amount of steps every starting gene is initialized with
		
		Node start = new Node(P, initialProb, initialSteps); // Initializes P, the gene to test
		
		queue.enqueue(start); // Adds P to the queue as the root node
		
		// arraylist used to store all the mutations that were successful in going from P to Q
		ArrayList<Node> successList = new ArrayList();
		
		int numRules = 3; // Represents the total amount of rules for mutations
		
		// while there are still nodes in the queue
		while (!queue.isEmpty())
		{
			Node root = queue.peek(); // gets the current root node gene
			
			for (int i = 1; i <= numRules; i += 1) // runs through the 3 rules on the root gene
			{
				// creates list of valid genes the root gene can mutate into in one step
				ArrayList listMutations = Mutation(root, validGenes, i);
				
				if (listMutations.size() > 0) // If there are mutations possible for this root gene
				{
					// if the amount of steps taken hasn't exceeded M
					if (listMutations.getNode(0).getSteps() < M)
					{
						/*Compares the mutated genes with the target gene Q.
						If they are equal, add the gene to successList*/
						for (int j = 0; j < listMutations.size(); j += 1)
						{
							/*if one of the mutated genes is equal to 
							the target gene, store it in successList*/
							if (listMutations.getNode(j).getValue().equals(Q)) 
							{
								successList.addNode(listMutations.getNode(j));
							}
							
							// adds the valid gene mutations to the queue
							queue.enqueue(listMutations.getNode(j)); 
						}
					}
						
				}
				
			}
			
			/*Removes the current root node from the queue after you 
			have found every single mutation that branches off of it*/
			queue.dequeue();
			
		}
		
		double probability = 0;
		
		/*Finds the mutation with the largest probability of occurring
		among the genes that successfully mutated into Q*/
		for (int i = 0; i < successList.size(); i += 1)
		{
			if (successList.getNode(i).getProb() > probability)
			{
				probability = successList.getNode(i).getProb();
			}
		}
		
		// returns largest probability of mutating into Q
		return probability;
		
	}
	
	/*Method used to apply the 3 mutation rules to a given gene. Returns an arraylist 
	of all the valid genes the passed in gene can mutate into within one step*/
	public ArrayList<Node> Mutation(Node<String> gene, String[] validGenes, int n)
	{
		// List of possible valid/disease genes the passed in gene can change to in one step
		ArrayList<Node> listMutations = new ArrayList(); 
		
		String geneString = gene.getValue();// the string value of the passed in gene
		
		double prob = gene.getProb(); // the probability of the passed in gene
		
		String[] chemical = new String[] {"A", "G", "C", "T"}; // Array of the base chemicals
		
		// probability of each rule mutation occurring
		double rule1 = 0.02;
		double rule2 = 0.06;
		double rule3 = 0.08;

		// Strings used to create new genes to compare with the list of valid genes
		String part1;
		String part2;
		String part3;
		String mutationTest;
		
		// Rule 1
		if (n == 1)
		{
			// Swaps the first and last chemical, and compares it to the list of valid genes
			
			part1 = geneString.substring(0, 1);
			part2 = geneString.substring(1, geneString.length() - 1);
			part3 = geneString.substring(geneString.length() - 1);
			
			mutationTest = part3 + part2 + part1;
			
			/*If the mutation is equal to a valid gene, and it has 
			not been visited already, add it to listMutations*/
			for (int i = 0; i < validGenes.length; i += 1)
			{
				if (mutationTest.equals(validGenes[i]) && visited[i] == false)
				{
					Node mutation = new Node(mutationTest, prob * rule1, gene.getSteps() + 1);
					listMutations.addNode(mutation);
					
					// sets the valid gene to be visited to prevent repeated mutations
					visited[i] = true;
				}
			
			}
		}
		
		// Rule 2
		if (n == 2)
		{
			/*Checks if any 2 adjacent chemicals in the gene are equal, and if there are any, 
			replace them with a single chemical, and compare it to the list of valid genes*/
			
			for (int i = 0; i < geneString.length() - 1; i += 1)
			{	
				if (geneString.charAt(i) == geneString.charAt(i + 1))
				{	
					part1 = geneString.substring(0, i);
					part2 = geneString.substring(i + 2);
					
					// Goes through each of the 4 chemicals and tests them with this mutation
					for (int x = 0; x < chemical.length; x += 1)
					{
						mutationTest = part1 + chemical[x] + part2;
						
						for (int j = 0; j < validGenes.length; j += 1)
						{
							/*If the mutation is equal to a valid gene, and it has 
							not been visited already, add it to listMutations*/
							if (mutationTest.equals(validGenes[j]) && visited[j] == false)
							{
								Node mutation = 
										new Node(mutationTest, prob * rule2, gene.getSteps() + 1);
								listMutations.addNode(mutation);
								
								// sets the valid gene to be visited to prevent repeated mutations
								visited[j] = true;
							}
						}
						
					}
				}
				
			}
		}
		
		// Rule 3
		if (n == 3)
		{	
			/*Checks if any 2 adjacent chemicals in the gene are G or T, and if there are any,
			insert a chemical in between them, and compare it to the list of valid genes*/
			
			for (int i = 0; i < geneString.length() - 1; i += 1)
			{
				if ((geneString.charAt(i) == 'G' && geneString.charAt(i + 1) == 'T')
						|| (geneString.charAt(i) == 'T' && geneString.charAt(i + 1) == 'G'))
				{
					part1 = geneString.substring(0, i + 1);
					part2 = geneString.substring(i + 1);
					
					// Goes through each of the 4 chemicals and tests them with this mutation
					for (int x = 0; x < chemical.length; x += 1)
					{
						mutationTest = part1 + chemical[x] + part2;
						
						for (int j = 0; j < validGenes.length; j += 1)
						{
							/*If the mutation is equal to a valid gene, and it has 
							not been visited already, add it to listMutations*/
							if (mutationTest.equals(validGenes[j]) && visited[j] == false)
							{
								Node mutation = 
										new Node(mutationTest, prob * rule3, gene.getSteps() + 1);
								listMutations.addNode(mutation);
								
								// sets the valid gene to be visited to prevent repeated mutations
								visited[j] = true;
							}
						}
					}
				}
			}
		}
		
		return listMutations; // return the list of valid mutations
	
		
	}
	
}