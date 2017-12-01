package exercise;

class Item {
	public String name;
	public int price;
	Item(String n, int p) {
		name = n;
		price = p;
	}
}

public class Test {

	public static void main(String[] args) {
		HashTable ht = new HashTable();
		Item item = new Item("Shoe", 10);
		
		ht.put(item, "Solna");
		
		String result = ht.get(item);
		System.out.println(result);
        
        Item hat = new Item("hat", 30);
        ht.put(hat, "Kista");
        
        String result2 = ht.get(item);
        System.out.println(result2);

        ht.put(item, "Solna2");

        String result3 = ht.get(item);
        System.out.println(result3);
	}

}
