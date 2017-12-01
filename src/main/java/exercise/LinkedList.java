package exercise;

class Node {
	Node next;
	int elem;
	public Node(Node next, int elem) {
		this.next = next;
		this.elem = elem;
	}
	/*int get(int index) {
	}*/
}

class IndexOutOfBoundsException extends
  RuntimeException {
}

public class LinkedList {

	Node first;
	
	void add(int elem) {
		Node newNode = new Node(null, elem);
		if (first == null) {
			first = newNode;			
		} else {
			// get the last node
			Node current = first;
			while (current.next != null) {
				current = current.next;
			}
			Node lastNode = current;
			// insert newNode in last node
			lastNode.next = newNode;
		}
	}

	int size() {
		int counter = 0;
		Node current = first;
		while (current != null) {
			current = current.next;
			counter++;
		}
		return counter;
	}

	int get(int index) {
		if (index == 0) {
			if (first == null)
				throw new IndexOutOfBoundsException();
			return first.elem;
		} else if (index > 0) {
			Node current = first;
			int i = 0;
			while (i < index) {
				if (current == null)
					throw new IndexOutOfBoundsException();
				current = current.next;
				i++;
			}
			if (current == null)
				throw new IndexOutOfBoundsException();
			return current.elem;
		} else {
			throw new IllegalArgumentException();
		}
	}

	// O(n^2)
	void printElements2() {
		int num = this.size();
		int i = 0;
		while (i < num) {
			int elem = this.get(i);
			System.out.println(elem);
			i++;
		}
	}

	// O(n)
	void printElements() {
		Node current = first;
		while (current.next != null) {
			System.out.println(current.elem);
			current = current.next;
		}
		System.out.println(current.elem);
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(4);
		list.add(2);
		
		System.out.println("size: " + list.size());
		
		System.out.println("result of printElements():");
		list.printElements();
		
		System.out.println("result of printElements2():");
		list.printElements2();
	}
}
