package exercise;

class Item {
	public String name;
	public int price;
	Item(String n, int p) {
		name = n;
		price = p;
	}
}

class Chair {
	
	private static int numberOfChairs;

	public Chair() {
		numberOfChairs++;
	}
	
	public void sitDown() {
		System.out.println("OK, sitting down.");
	}
	
	public static int count() {
		return numberOfChairs;
	}
}

public class Test {

	public static void main(String[] args) {

		Chair c = new Chair();
		c.sitDown();
		
		System.out.println("Created " + Chair.count() + " chairs.");
	}

}
