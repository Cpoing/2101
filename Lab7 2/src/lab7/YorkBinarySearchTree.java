package lab7;

import java.util.LinkedList;
import java.util.Queue;

///////////////////////////////////////////////////////////////////////////
//Full Name : Ted Lee	
//Yorku Email : ted04@my.yorku.ca
//Date : May 17, 2024
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
 * The YorkBinarySearchTree tree is an binary search tree
 * 
 * 
 * In a YorkBinarySearchTree tree extends YorkLinkedBinaryTree
 * and adopts same convention in which we set a node
 * parent pointer to itself when removed from a tree to recognize it as an
 * invalid position later on. Thus, in your implementation for the
 * YorkLinkedBinaryTree tree, you must validate the received input position
 * every time to ensure that it is a valid tree node.
 * 
 * Note: You are responsible for creating and running the tests necessary to
 * ensure
 * that you have correct implementation of YorkBinarySearchTree tree.
 * 
 *
 */
public class YorkBinarySearchTree<E extends Comparable<E>> extends YorkLinkedBinaryTree<E> {

	/**
	 * Add any other private data members or methods that are necessary to manage
	 * the YorkLinkedBinaryTree
	 */
	protected Node<E> root2;
	private int size2;

	/**
	 * Constructs an empty binary search tree.
	 */
	public YorkBinarySearchTree() {
		// TODO: Your implementation of this method starts here
		root2 = null;
		size2 = 0;
	}

	/**
	 * Constructs a binary search tree with given element at root
	 */
	public YorkBinarySearchTree(E e) {
		// TODO: Your implementation of this method starts here
		root2 = new Node<>(e, null, null, null);
		size2 = 1;
	}

	/**
	 * 
	 * @param objects array of element to be added into this tree
	 */

	public YorkBinarySearchTree(E[] objects) {
		// TODO: Your implementation of this method starts here
		for (E obj : objects) {
			insert(obj);
		}
	}

	/**
	 * Search of element inside the tree
	 * if the element is found, then return the position of the element
	 * if the element is not found, return null
	 * 
	 * @param e input element
	 * @return position of element if element exist inside the tree or null if
	 *         element not exist
	 */

	public Position<E> search(E e) {
		return search2(root2, e);
	}

	private Position<E> search2(Node<E> root, E e) {
		if (root == null) {
			return null;
		}
		if (root.getElement() == e) {
			return root;
		}

		if (search2(root.getLeft(), e) != null) {
			return search2(root.getLeft(), e);
		}

		if (search2(root.getRight(), e) != null) {
			return search2(root.getRight(), e);
		}

		return null;
	}

	/**
	 * Remove element e from tree.
	 * if the element is found, remove its position and return the position of its
	 * parent
	 * if the element is not found, return null
	 * 
	 * 
	 * @param e the input element for remove
	 * @return parent position of the removed element or null
	 */

	public Position<E> remove(E k) {
		Node<E> v = removeHelp(root2, k);
		if (v != null) {
			size2--;
		}
		return v;
	}

	private Node<E> removeHelp(Node<E> n, E e) {
		if (n == null) {
			return null;
		}
		int eq = e.compareTo(n.getElement());

		if (eq > 0) {
			n.setRight(removeHelp(n.getRight(), e));
		} else if (eq < 0) {
			n.setLeft(removeHelp(n.getLeft(), e));
		} else {
			if (n.getLeft() == null) {
				return n.getRight();
			} else if (n.getRight() == null) {
				return n.getLeft();
			}

			Node<E> tmp = n;
			while (tmp.getLeft() != null) {
				tmp = tmp.getLeft();
			}

			n.setElement(tmp.getElement());
			n.setRight(removeHelp(n.getRight(), n.getElement()));
		}
		return n;

	}

	/**
	 * Adds the input element to the binary search tree in
	 * the appropriate position.
	 * Note that equal elements are added to the right.
	 * 
	 * @param e the element that will be added to binary search tree
	 * @return the Position of the newly added element
	 */
	public Position<E> insert(E e) {
		if (root2 != null) {
			size2++;
			return insertHelp(e, root2);
		}
		root2 = new Node<>(e, null, null, null);
		size2++;
		return root2;
	}

	private Node<E> insertHelp(E e, Node<E> n) {
		if (n == null) {
			return new Node<>(e, null, null, null);
		}
		int eq = e.compareTo(n.getElement());
		if (eq <= 0) {
			n.setLeft(insertHelp(e, n.getLeft()));
			n.getLeft().setParent(n);
		} else if (eq > 0) {
			n.setRight(insertHelp(e, n.getRight()));
			n.getLeft().setParent(n);
		}
		return n;

	}

	/**
	 * Returns true if the tree is a full binary tree
	 * 
	 * @return true if the tree is a full binary tree
	 */

	public boolean isFullBST() {
		return BSTHelp(root2);
	}

	private boolean BSTHelp(Node<E> node) {
		if (node == null) {
			return true;
		}

		if (node.getLeft() == null && node.getRight() == null) {
			return true;
		}

		if (node.getLeft() != null && node.getRight() != null) {
			return BSTHelp(node.getLeft()) && BSTHelp(node.getRight());
		}

		return false;
	}

	/**
	 * Returns the number of leaf nodes
	 * 
	 * @return Returns the number of leaf nodes
	 */
	public int getNumberOfLeaves() {
		// TODO: Your implementation of this method starts here
		return LeavesHelp(root2);

	}

	private int LeavesHelp(Node<E> n) {
		if (n == null) {
			return 0;
		}
		if (numChildren(n) == 0) {
			return 1;
		}

		return LeavesHelp(n.getRight()) + LeavesHelp(n.getLeft());
	}

	/**
	 * Returns the number of non-leaf nodes
	 * 
	 * @return Returns the number of non-leaf nodes
	 */
	public int getNumberofNonLeaves() {
		// TODO: Your implementation of this method starts here
		return nonLeaves(root2);

	}

	private int nonLeaves(Node<E> node) {
		if (node == null || numChildren(node) == 0) {
			return 0;
		}
		return 1 + nonLeaves(node.getLeft()) + nonLeaves(node.getRight());
	}

	/**
	 * Returns an iterable collection of positions of the tree, reported in inorder.
	 * 
	 * @return iterable collection of positions of the tree, reported in inorder
	 */
	public Iterable<Position<E>> inorder() {
		// TODO: Your implementation of this method starts here
		LinkedList<Position<E>> ans = new LinkedList<>();
		inOrder(root2, ans);
		return ans;
	}

	private void inOrder(Node<E> n, LinkedList<Position<E>> ans) {
		if (n == null) {
			return;
		}
		inOrder(n.getLeft(), ans);
		ans.add(n);
		inOrder(n.getRight(), ans);
	}

	/**
	 * Returns an iterable collection of positions of the tree, reported in preorder
	 * 
	 * @return iterable collection of positions of the tree, reported in preorder
	 */
	public Iterable<Position<E>> preorder() {
		// TODO: Your implementation of this method starts here
		LinkedList<Position<E>> ans = new LinkedList<>();

		preOrder(root2, ans);

		return ans;
	}

	private void preOrder(Node<E> n, LinkedList<Position<E>> ans) {
		if (n == null) {
			return;
		}

		ans.add(n);
		preOrder(n.getRight(), ans);
		preOrder(n.getLeft(), ans);
	}

	/**
	 * 
	 * Returns an iterable collection of positions of the tree, reported in
	 * postorder
	 * 
	 * @return iterable collection of positions of the tree, reported in postorder
	 */
	public Iterable<Position<E>> postorder() {
		// TODO: Your implementation of this method starts here
		LinkedList<Position<E>> ans = new LinkedList<>();

		postOrder(root2, ans);

		return ans;

	}

	private void postOrder(Node<E> n, LinkedList<Position<E>> ans) {
		if (n == null) {
			return;
		}
		postOrder(n.getRight(), ans);
		postOrder(n.getLeft(), ans);
		ans.add(n);
	}

	/**
	 * Returns an iterable collection of positions of the tree in breadth-first
	 * order.
	 * 
	 * @return iterable collection of positions of the tree in breadth-first order
	 */
	public Iterable<Position<E>> breadthfirst() {
		// TODO: Your implementation of this method starts here
		LinkedList<Position<E>> ans = new LinkedList<>();
		if (root2 == null) {
			return ans;
		}

		Queue<Node<E>> queue = new LinkedList<>();
		queue.add(root2);

		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			ans.add(node);

			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}

			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
		return ans;
	}

	/**
	 * Overrides positions to make inorder the default order for binary trees.
	 */
	@Override
	public Iterable<Position<E>> positions() {
		// TODO: Your implementation of this method starts here
		LinkedList<Position<E>> ans = new LinkedList<>();
		inOrder(root2, ans);
		return ans;
	}

}
