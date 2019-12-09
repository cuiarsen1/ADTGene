import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	
	protected int L;
	
	protected int V;
	protected int D;
	
	protected ArrayList<String> validGenes; // List of all valid and diseased genes that can be mutated into
	
	protected int M;
	
	protected int G;
	
	protected ArrayList<String> testArray;

	public FileReader(String input) throws FileNotFoundException
	{
		File file = new File(input);
		
		Scanner scan = new Scanner(file);
		
		L = scan.nextInt();
		
		V = scan.nextInt();
		D = scan.nextInt();
		
		validGenes = new ArrayList<String>(V + D);
		
		for (int i = 0; i < validGenes.size(); i += 1)
		{
			validGenes.addNode(new Node<String>(scan.nextLine()));
		}
		
		M = Integer.parseInt(scan.nextLine());
		
		G = Integer.parseInt(scan.nextLine());
		
		testArray = new ArrayList<String>(G); // Creates array of the genes to test
		
		for (int i = 0; i < testArray.size(); i += 1)
		{
			String P = scan.next();
			String Q = scan.next();
		}
	}

	
	/*public double testing(Node starter, Node end, int maxMutations) {
        double chances = 0;
        ArrayQueue<String> lineup = new ArrayQueue();
        lineup.enqueue(starter);
        starter.setChance(1);
        int currentMutations = 0;
        int minimutations = 0;
        int oneMutation = 1;
        Node<String> Mutation1 = new Node(starter);
        ArrayList<Node> Mutation2s = new ArrayList();
        ArrayList<Node> Mutation3s = new ArrayList();
        while(!lineup.isEmpty()) {
            if(currentMutations < maxMutations) {
                if(minimutations == oneMutation) {
                    currentMutations++;
                    oneMutation = 1 + Mutation2s.size() + Mutation3s.size();
                }
                    Mutation1 = Mutation1(lineup.peek().toString());
                    Mutation1.setChance(lineup.peek().getChance()*0.02);
                    if(Mutation1 != null) {
                        lineup.enqueue(Mutation1);
                    }
                    Mutation2s = Mutation2(lineup.peek().toString());
                    if(Mutation2s.size() > 0) {
                        for(int i = 0; i < Mutation2s.size(); i++) {
                            Mutation2s.getNode(i).setChance(lineup.peek().getChance()*0.06);
                            lineup.enqueue(Mutation2s.getNode(i));
                        }
                    }
                    if(Mutation2s.size() > 0) {
                    Mutation3s = Mutation3(lineup.peek().toString());
                        for(int i = 0; i < Mutation3s.size(); i++) {
                            Mutation3s.getNode(i).setChance(lineup.peek().getChance()*0.08);
                            lineup.enqueue(Mutation3s.getNode(i));
                        }
                    }
                
            }*/
	
}
