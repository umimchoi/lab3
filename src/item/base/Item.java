package item.base;

// you CAN modify the first line
public class Item {	
	public Item(String name, String description) {}
	
	@Override
	public String toString() {
		// You do NOT have to modify this function
		return new StringBuilder()
				.append("<")
				.append(this.getName())
				.append(">:[")
				.append(this.getDescription())
				.append("]")
				.toString();
	}
	
	public String getName() {}
	public String getDescription() {}
}
