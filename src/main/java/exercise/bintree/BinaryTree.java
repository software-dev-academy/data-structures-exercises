package exercise.bintree;

import java.util.ArrayList;
import java.util.List;

class Node {
	private int data;
	private Node left;
	private Node right;

	// Construct a leaf node.
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// Template method
	// (see "Template Method design pattern)
	public List<Integer> toListTemplate(ElementAdder adder) {
		List<Integer> newList = new ArrayList<>();

		if (isLeaf()) {
			newList.add(data);
		} else {
			// left can be null!
			List<Integer> leftList =
					left == null ? new ArrayList<>() : left.toListTemplate(adder);
			// right can be null!
			List<Integer> rightList =
					right == null ? new ArrayList<>() : right.toListTemplate(adder);

			adder.addElements(newList, data, leftList, rightList);
		}
		
		return newList;
	}

	/**
	 * Creates a list using the in-order traversal of this
	 * binary tree.
	 * @return the created list
	 */
	public List<Integer> toList() {
		return toListTemplate((newList, data, leftList, rightList) -> {
			newList.addAll(leftList);
			newList.add(data);
			newList.addAll(rightList);
		});
	}

	/**
	 * Using pre-order traversal
	 * @return
	 */
	public List<Integer> toListPreOrder() {
		return toListTemplate(
				(newList, data, leftList, rightList) -> {
					newList.add(data);
					newList.addAll(leftList);
					newList.addAll(rightList);
				});
	}

	public void setLeft(Node child) {
		this.left = child;
	}
	
	public void setRight(Node child) {
		this.right = child;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}
	
	public String toString() {
		if (isLeaf())
			return "Leaf(" + data + ")";
		else {
			String leftString =
					left == null ? "null" : left.toString();
			String rightString =
					right == null ? "null" : right.toString();	
			return "Node(" + data + ", " +
		            leftString + ", " + rightString + ")";
		}
	}
}

// SAM class:
// it has a Single Abstract Method (SAM)
@FunctionalInterface
interface ElementAdder {
	void addElements(List<Integer> newList, int data, List<Integer> leftList, List<Integer> rightList);
}

/*
class InOrderAdder implements ElementAdder {
	public void addElements(List<Integer> newList, int data, List<Integer> leftList, List<Integer> rightList) {
		newList.addAll(leftList);
		newList.add(data);
		newList.addAll(rightList);
	}
}

class PreOrderAdder implements ElementAdder {
	public void addElements(List<Integer> newList, int data, List<Integer> leftList, List<Integer> rightList) {
		newList.add(data);
		newList.addAll(leftList);
		newList.addAll(rightList);
	}
}

class PostOrderAdder implements ElementAdder {
	public void addElements(List<Integer> newList, int data, List<Integer> leftList, List<Integer> rightList) {
		newList.addAll(leftList);
		newList.addAll(rightList);
		newList.add(data);
	}
}
*/

public class BinaryTree {
	private Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}

	public void insert(Node parent, Node child, boolean goLeft) {
		if (goLeft)
			parent.setLeft(child);
		else
			parent.setRight(child);
	}

	public String toString() {
		if (isEmpty())
			return "BinaryTree()";
		else
			return root.toString();
	}
}
