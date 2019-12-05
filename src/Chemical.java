
public class Chemical {
	
	private String type; // Type A, G, T, or C
	
	private Chemical next;
	private Chemical prev;
	
	public Chemical(String t)
	{
		type = t;
	}
	
	public void setNext() {
		
	}
	
	public String getValue() {
		return type;
	}
	
	public void setValue(String t) {
		type = t;
	}

	public void setNext(Chemical c) {
		next = c;
	}

	public void setPrev(Chemical c) {
		prev = c;
		
	}
	
	public Chemical getNext() {
		return next;
	}

	public Chemical getPrev() {
		return prev;
	}
	
	public String toString() {
		return type;
	}
}
