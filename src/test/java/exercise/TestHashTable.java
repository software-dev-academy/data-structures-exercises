package exercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestHashTable {

	@Test
	public void putAndGet() {
		HashTable ht = new HashTable();
		Item item = new Item("shoe", 10);
		ht.put(item, "Solna");
		String result = ht.get(item);
		assertEquals(result, "Solna");
	}

}
