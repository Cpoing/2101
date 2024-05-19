package lab7;

import java.util.Iterator;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 
import java.util.LinkedList;

///////////////////////////////////////////////////////////////////////////
//Full Name : Ted Lee
//Yorku Email : ted04@my.yorku.ca
//Date : May 16, 2024
//Authenticity Declaration :
//I declare this submission is the result of my own work and has not been
//shared with any other student or 3rd party content provider.This submitted
//piece of work is entirely of my own creation.
//////////////////////////////
/*
* <p>
* Your implementation of this class or methods should not contains:
* 1. No System.out.println statements should appear here. Instead, you need to
* return the result. 2. No Scanner operations should appear here (e.g.,
* input.nextInt()). Instead, refer to the input parameters of this method.
* </p>
*/

/**
 * The YorkLinkedBinaryTree tree is an ordered binary tree that supports the
 * preorder traversal algorithm to visit tree position or elements.
 * 
 * In a YorkLinkedBinaryTree tree, we adopt a convention in which we set a node
 * parent pointer to itself when removed from a tree to recognize it as an
 * invalid position later on. Thus, in your implementation for the
 * YorkLinkedBinaryTree tree, you must validate the received input position
 * every time to ensure that it is a valid tree node.
 * 
 * Note: You are responsible for creating and running the tests necessary to
 * ensure
 * that you have correct implementation of YorkLinkedBinaryTree tree.
 * 
 *
 */
public class YorkLinkedBinaryTree<E> implements BinaryTree<E> {

	// -------------- nested Node Class ------------------
	protected static class Node<E> implements Position<E> {
		// ALREADY IMPLEMENTED; DO NOT MODIFY
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		// ----------------------------

		/**
		 * Constructs a node with the given element and neighbors.
		 */
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			// TODO: Your implementation of this method starts here
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;

		}

		public Node<E> getParent() {
			// TODO: Your implementation of this method starts here
			return parent;
		}

		public Node<E> getLeft() {
			// TODO: Your implementation of this method starts here
			return left;
		}

		public Node<E> getRight() {
			// TODO: Your implementation of this method starts here
			return right;
		}

		public void setElement(E e) {
			// TODO: Your implementation of this method starts here
			element = e;

		}

		public void setParent(Node<E> parentNode) {
			// TODO: Your implementation of this method starts here
			parent = parentNode;

		}

		public void setLeft(Node<E> leftChild) {
			// TODO: Your implementation of this method starts here
			left = leftChild;
		}

		public void setRight(Node<E> rightChild) {
			// TODO: Your implementation of this method starts here
			right = rightChild;
		}

		@Override
		public E getElement() throws IllegalStateException {
			// TODO: Your implementation of this method starts here
			return element;

		}

	}
	// ---- end of nested Node class----------------------

	/**
	 * Add any other private data members or methods that are necessary to manage
	 * the YorkLinkedBinaryTree
	 */

	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private Node<E> root;

	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private int size;

	/**
	 * Constructs an empty tree
	 */
	public YorkLinkedBinaryTree() {
		// TODO: Your implementation of this method starts here
		size = 0;
		root = null;

	}

	@Override
	public Position<E> root() {
		// TODO: Your implementation of this method starts here
		return root;

	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E> curr = validate(p);
		return curr.getParent();
	}

	@Override
	public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E> curr = validate(p);
		LinkedList<Position<E>> cList = new LinkedList<>();

		if (curr.getLeft() != null) {
			cList.add(curr.getLeft());
		}
		if (curr.getRight() != null) {
			cList.add(curr.getRight());
		}
		return cList;
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E> curr = validate(p);
		int count = 0;

		if (curr.getLeft() != null) {
			count++;
		}
		if (curr.getRight() != null) {
			count++;
		}
		return count;

	}

	@Override
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> curr = validate(p);
		return (curr.getLeft() != null || curr.getRight() != null);

	}

	@Override
	public boolean isExternal(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> curr = validate(p);
		return (curr.getLeft() == null || curr.getRight() == null);

	}

	@Override
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> curr = validate(p);

		return curr.equals(root);

	}

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return size == 0;

	}

	/**
	 * Places element e at the root of an empty tree and returns its new Position.
	 * 
	 * @param e element of root
	 * @return position of root
	 * @throws IllegalStateException if the tree is not empty
	 */

	public Position<E> addRoot(E e) throws IllegalStateException {
		// TODO: Your implementation of this method starts here
		if (!isEmpty()) {
			throw new IllegalArgumentException("tree is not empty");
		}
		root = new Node<>(e, null, null, null);
		return root;
	}

	/**
	 * Compute the depth of any given valid position by returning the number of
	 * levels separating Position p from the root.
	 * 
	 * @param p A valid Position within the tree
	 * @return Returns the number of levels separating Position p from the root.
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 */
	public int depth(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> curr = validate(p);
		if (curr == root) {
			return 0;
		}
		return 1 + depth(curr.getParent());

	}

	/**
	 * 
	 * @param p A valid Position within the tree
	 * @return Returns the height of the subtree rooted at Position p.
	 * @throws IllegalArgumentException
	 */
	public int height(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> curr = validate(p);
		return heightFinder(curr);

	}

	private int heightFinder(Node<E> node) {
		if (node == null) {
			return -1;
		}
		int left = height(node.getLeft());
		int right = height(node.getRight());
		return Math.max(left, right) + 1;
	}

	/**
	 * Return the height of this binary tree
	 * 
	 * @return the height of this binary tree
	 */
	public int height() {
		// TODO: Your implementation of this method starts here
		return height(root);

	}

	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> curr = validate(p);
		return curr.getLeft();

	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> curr = validate(p);
		return curr.getRight();

	}

	@Override
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> curr = validate(p);
		Node<E> parent = curr.getParent();

		if (parent == null) {
			throw new IllegalArgumentException("Position has no parent");
		}

		if (curr == parent.getLeft()) {
			return parent.getRight();
		} else {
			return parent.getLeft();
		}

	}

	/**
	 * insert as the left child of P to contain the element e, return the newly
	 * inserted node,
	 * Creates a new left child of Position p storing element e; returns its
	 * Position.
	 * 
	 * @param p the position where the left child will be added
	 * @param e the element that will be added as the left child of position p
	 * @return the Position of the newly added left child
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 *                                  or
	 *                                  the given position has already a left child
	 */
	public Position<E> insertLeft(Position<E> p, E e) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> curr = validate(p);
		if (curr.getLeft() != null) {
			throw new IllegalArgumentException("Position already has a left child");
		}

		Node<E> left = new Node<>(e, curr, null, null);
		curr.setLeft(left);
		return left;
	}

	/**
	 * insert as the right child of P to contain the element e, return the newly
	 * inserted node
	 * 
	 * @param p the position where the right child will be added
	 * @param e the element that will be added as the right child of position p
	 * @return the Position of the newly added right child
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 *                                  or the given position has already a right
	 *                                  child
	 */
	public Position<E> insertRight(Position<E> p, E e) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> curr = validate(p);
		if (curr.getRight() != null) {
			throw new IllegalArgumentException("Position already has a left child");
		}

		Node<E> right = new Node<>(e, curr, null, null);
		curr.setRight(right);
		return right;
	}

	/**
	 * Replaces the element at Position p with element e and returns the old
	 * element.
	 *
	 * @param p the input Position need to be updated
	 * @param e the new element
	 * @return the old element
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> curr = validate(p);
		E tmp = curr.getElement();
		curr.setElement(e);
		return tmp;

	}

	/**
	 * Remove position p if p has at most one child and return p's parent
	 * 
	 * @param p the input position that needs to be removed from the tree
	 * @return the parent of the removed position
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 *                                  or
	 *                                  p has two children
	 */
	public Position<E> remove(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> curr = validate(p);

		if (numChildren(curr) == 2) {
			throw new IllegalArgumentException("p has two children");
		}
		Node<E> parent = curr.getParent();
		Node<E> child = (curr.getLeft() != null ? curr.getLeft() : curr.getRight());

		if (child != null) {
			child.setParent(curr.getParent());
		}
		if (curr == root) {
			root = child;
		} else {
			if (curr == parent.getLeft()) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		}
		size--;
		curr.setElement(null);
		curr.setLeft(null);
		curr.setRight(null);
		curr.setParent(curr);
		return parent;
	}

	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (!(p instanceof Node)) {
			throw new IllegalArgumentException("Not valid position type");
		}

		Node<E> node = (Node<E>) p;

		if (node.getParent() == node)
			throw new IllegalArgumentException("p is no longer in the tree");
		return node;
	}

	/**
	 * Attaches two sub-trees t1 and t2, respectively, as the left and right subtree
	 * of the leaf Position p. After you successfully added t1 and t2 to a new tree
	 * and became part of a big tree, the t1 and t2 are set to empty trees.
	 *
	 * @param p  a leaf of the tree
	 * @param t1 a completely independent tree whose structure becomes the left
	 *           child of p
	 * @param t2 a completely independent tree whose structure becomes the right
	 *           child of p
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 *                                  or p is not a leaf
	 * 
	 */
	public void attach(Position<E> p, YorkLinkedBinaryTree<E> t1, YorkLinkedBinaryTree<E> t2)
			throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		Node<E> node = validate(p);
		if (isInternal(p))
			throw new IllegalArgumentException("p must be a leaf");

		size += t1.size() + t2.size();
		if (!t1.isEmpty()) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if (!t2.isEmpty()) {
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}

	/**
	 * The YorkLinkedBinaryTree tree is an ordered binary tree that supports the
	 * preorder traversal algorithm to visit tree position or elements.
	 */
	@Override
	public Iterator<E> iterator() {
		// TODO: Your implementation of this method starts here
		Iterable<Position<E>> positions = positions();
		LinkedList<E> elements = new LinkedList<E>();
		for (Position<E> pos : positions) {
			elements.addLast(pos.getElement());
		}
		return elements.iterator();

	}

	/**
	 * The YorkLinkedBinaryTree tree is an ordered binary tree that supports the
	 * preorder traversal algorithm to visit tree position or elements.
	 */

	@Override
	public Iterable<Position<E>> positions() {
		// TODO: Your implementation of this method starts here
		LinkedList<Position<E>> positions = new LinkedList<Position<E>>();
		if (size != 0) {
			inorderPositions(root(), positions);
		}
		return positions;
	}

	public void inorderPositions(Position<E> p, LinkedList<Position<E>> positions) {
		if (left(p) != null) {
			inorderPositions(left(p), positions);
		}
		positions.add(p);

		if (right(p) != null) {
			inorderPositions(right(p), positions);
		}
	}

}
