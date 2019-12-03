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
		
		// Skips past all the lines containing the valid and disease genes
		for (int i = 0; i < V + D; i += 1)
		{
			scan.nextLine();
		}
		
		int M = scan.nextInt();
		
		int G = scan.nextInt();
		
		String[] testArray = new String[G]; // Creates array of the genes to test
		
		for (int i = 0; i < testArray.length; i += 1)
		{
			testArray[i] = scan.nextLine();
		}
		
		
		

	}

}
