package exercise;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestHashTable {

	@Test
	public void testPutAndGet() {
		HashTable ht = new HashTable();
		Item item = new Item("shoe", 10);
		ht.put(item, "Solna");
		String result = ht.get(item);
		
		assertEquals("The value should have been Solna", result, "Solna");
	}
	
	@Test
	public void testMoreItems() {
		HashTable ht = new HashTable();

		Item item = new Item("shoe", 10);
		ht.put(item, "Solna");
		
		Item hat = new Item("hat", 30);
        ht.put(hat, "Kista");
        String result2 = ht.get(item);
        assertEquals(result2, "Solna");

        ht.put(item, "Solna2");
        String result3 = ht.get(item);
        assertEquals(result3, "Solna2");
	}
}
