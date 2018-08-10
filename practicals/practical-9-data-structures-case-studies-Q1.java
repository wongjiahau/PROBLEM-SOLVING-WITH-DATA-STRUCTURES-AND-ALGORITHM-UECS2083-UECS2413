import java.util.HashMap;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello");
		ContainerStorageRegion x = new ContainerStorageRegion();
		
		// Initializing sample data
		x.load(new Container("1", "piano"), 1, 1);
		x.load(new Container("2", "car"), 1, 1);
		
		// Testing unload
		Container c = x.unload("2", 1, 1);
		System.out.println(c);
				
	}
}

class Container {
	String id;
	String description;
	public Container(String id, String description) {
		this.id = id;
		this.description = description;
	}
	public String toString() {
		return "Id: " + this.id + ", Description: " + this.description;
	}
}

class ContainerStorageRegion {
	private HashMap<String, Stack<Container>> cells;
	public static final int ROW = 10;
	public static final int COLUMN = 10;
	public static final int STACK_LIMIT = 10; 
	public static final String BUFFER_LOCATION = hash(0, 0); 
	public ContainerStorageRegion() {
		this.cells = new HashMap<String, Stack<Container>>();
		for(int i = 0; i < ROW; i ++) {
			for(int j = 0; j < COLUMN; j++) {
				cells.put(hash(i, j), new Stack<Container>());
			}
		}		
	}
	
	public Container unload(String id, int row, int column) {
		Stack<Container> cell = this.cells.get(hash(row, column));
		Stack<Container> temporaryStack = this.cells.get(hash(0, 0)); // We assume Cell[0,0] is the buffer stack
		while(!cell.isEmpty()) {
			Container currentContainer = cell.pop();
			if(currentContainer.id == id) {
				while(!temporaryStack.isEmpty()) { // Push back all the non-matching container to their original cell
					cell.push(temporaryStack.pop());
				}
				return currentContainer;
			} else {
				temporaryStack.push(currentContainer);
			}
		}
		return null;
	}
	
	public void load(Container container, int row, int column) {
		if(hash(row, column) == BUFFER_LOCATION) {
			throw new Error("Cell[0,0] is reserved as buffer.");
		}
		Stack<Container> cell = this.cells.get(hash(row, column));
		if(cell.size() == STACK_LIMIT) {
			throw new Error("The stack at " + hash(row, column) + " is already full.");
		} else {
			cell.push(container);
		}
	}
	
	private static String hash(int row, int column) {
		return row + "," + column;
	}
}
