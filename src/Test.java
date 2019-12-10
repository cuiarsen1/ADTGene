import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	
	public static void main (String args[]) throws FileNotFoundException {
		
		File file = new File("InputFile.txt");
		
		Scanner scan = new Scanner(file);
		
		int L = Integer.parseInt(scan.nextLine());
		int V = Integer.parseInt(scan.nextLine());
		int D = Integer.parseInt(scan.nextLine());
		
		String[] validGenes = new String[V + D];
		
		for (int i = 0; i < validGenes.length; i += 1)
		{
			validGenes[i] = scan.nextLine();
		}
		
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
		
		System.out.println(L);
		System.out.println(V);
		System.out.println(D);
		for (int i = 0; i < validGenes.length; i += 1)
		{
			System.out.println(validGenes[i]);
		}
		
		System.out.println(M);
		System.out.println(G);
		for (int i = 0; i < testArray.length; i += 1)
		{
			System.out.println(testArray[i][0] + " " + testArray[i][1]);
		}
		
		
	}
	
}