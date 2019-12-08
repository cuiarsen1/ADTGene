import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	
	protected int L;
	
	protected int V;
	protected int D;
	
	protected String[] validGenes; // List of all valid and diseased genes that can be mutated into
	
	protected int M;
	
	protected int G;
	
	protected String[] testArray;

	public FileReader(String input) throws FileNotFoundException
	{
		File file = new File(input);

		Scanner scan = new Scanner(file);
		
		L = scan.nextInt();
		
		V = scan.nextInt();
		D = scan.nextInt();
		
		String[] validGenes = new String[V + D];
		
		for (int i = 0; i < validGenes.length; i += 1)
		{
			validGenes[i] = scan.nextLine();
		}
		
		M = scan.nextInt();
		
		G = scan.nextInt();
		
		testArray = new String[G]; // Creates array of the genes to test
		
		for (int i = 0; i < testArray.length; i += 1)
		{
			String s = scan.nextLine();
			
			s.split(" ");
		}
	}
	
}
