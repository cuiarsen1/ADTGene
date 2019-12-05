import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ADTMain {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("InputFile.txt");

		Scanner scan = new Scanner(file);
		
		int L = scan.nextInt();
		
		int V = scan.nextInt();
		int D = scan.nextInt();
		
		String[] validGenes = new String[V];
		String[] diseaseGenes = new String[D];
		
		for (int i = 0; i < V; i += 1)
		{
			validGenes[i] = scan.nextLine();
		}
		
		for (int i = 0; i < D; i += 1)
		{
			diseaseGenes[i] = scan.nextLine();
		}
		
		int M = scan.nextInt();
		
		int G = scan.nextInt();
		
		String[] testArray = new String[G]; // Creates array of the genes to test
		
		for (int i = 0; i < testArray.length; i += 1)
		{
			String s = scan.nextLine();
			
			s.split(" ");
		}
		

		// BFS, you know as soon as you find a possibility it is the biggest, as the more levels there are, 
		// the smaller the probability is for sure, as the probabilities are so small that basically the more 
		// levels, the smaller the probability
		
		Generate a random mutation, compare to the list of valid and disease genes, if it doesnt exist, 
		get rid of it. If it does, add it to list of possible mutations for that gene.

	}

}
