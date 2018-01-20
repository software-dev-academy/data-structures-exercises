package exercise.bintree;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		System.out.println(tree);

		Node leaf1 = new Node(2);
		Node leaf2 = new Node(10);
		Node node1 = new Node(12, leaf1, leaf2);
		Node node2 = new Node(20, node1, new Node(30));

		System.out.println(node2);
		
		Node leaf3 = new Node(2);
		Node node3 = new Node(12);
		node3.setLeft(leaf3);
		// node3.right == null!
		System.out.println(node3);
		
		List<Integer> list = node3.toList();
		System.out.println(list);
		
		System.out.println("====");
		System.out.println("in-order traversal:");

		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n4 = new Node(4, n8, n9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n5 = new Node(5, n10, n11);
		Node n2 = new Node(2, n4, n5);
		
		System.out.println(n2.toList());
		
		
		
		
	}

}
