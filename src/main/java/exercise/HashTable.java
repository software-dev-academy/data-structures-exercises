package exercise;

class Entry {
	Object o;
	String s;
	Entry next;

	Entry(Object o, String s) {
		this.o = o;
		this.s = s;
		this.next = null;
	}
}

// Key type: Object, value type: String
public class HashTable {

	int SIZE = 1024;
	Entry[] table = new Entry[SIZE];

	void put(Object key, String value) {
		int hashValue = key.hashCode();
		int index = hashValue % SIZE;
		Entry existing = table[index];
		if (existing == null) {
			Entry newEntry = new Entry(key, value);
			table[index] = newEntry;
		} else {
			// there may already be an entry
			// for object `key`!
			Entry current = existing;
			boolean updated = false;
			while (current != null && !updated) {
				if (current.o == key) {
					current.s = value;
					updated = true;
				}
				current = current.next;
			}
			if (!updated) {
				Entry newEntry = new Entry(key, value);
				newEntry.next = existing;
				table[index] = newEntry;
			}
		}

		// correctness test: just one entry for `key`
		boolean found = false;
		Entry current = table[index];
		if (current.o == key) {
			found = true;
		}
		while (current.next != null) {
			current = current.next;
			if (current.o == key) {
				if (found) {
					throw new RuntimeException("key occurs more than once");
				} else {
					found = true;
				}
			}
		}
	}

	String get(Object o) {
		int hashValue = o.hashCode();
		int index = hashValue % SIZE;
		Entry existing = table[index];
		if (existing == null) {
			throw new RuntimeException("entry does not exist");
		} else {
			Entry current = existing;
			while (current.o != o) {
				current = current.next;
			}
			return current.s;
		}
	}
}
