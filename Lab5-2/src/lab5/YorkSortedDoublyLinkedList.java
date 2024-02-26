package lab5;

//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

///////////////////////////////////////////////////////////////////////////
//Full Name :
//Yorku Email :
//Date :
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
 * 
 * You need to complete the implementation of a YorkSortedDoublyLinkedList class
 * The YorkSortedDeoublyLinkedList uses sentinel nodes, header and trailer.
 * Therefore, you need to keep in mind that the first element of a nonempty list
 * is stored in the node just after the header (not in the header itself), and
 * similarly that the last element is stored in the node just before the
 * trailer.
 * 
 * @param <E>
 */
public class YorkSortedDoublyLinkedList<E> implements List<E> {
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> prev;

		public Node(E element) {
			this.element = element;
		}
	}

	/////////////////////////////////////
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private Node<E> header; // header sentinel
	private Node<E> trailer; // trailer sentinel
	private int size = 0; // number of elements in the list
	//////////////////////////////////

	/**
	 * Add any other private data members or methods that are necessary
	 * to manage the YorkSortedDoublyLinkedList
	 */

	public YorkSortedDoublyLinkedList() {
		// TODO: Your implementation of this method starts here
		header = new Node<>(null);
		trailer = new Node<>(null);
		header.next = trailer;
		trailer.prev = header;
	}

	/**
	 * 
	 * Take the elements from the input array one by one and then insert them into
	 * the list. you should insert the elements at the end of the list
	 */
	public YorkSortedDoublyLinkedList(E[] objects) {
		// TODO: Your implementation of this method starts here
		this();
		for (E object : objects) {
			addLast(object);
		}

	}

	/**
	 * Returns (but does not remove) the first element stored in the first node of
	 * the list. if the list is empty return null otherwise return the first element
	 * stored inside the first node of the list
	 * 
	 * @return
	 */
	public E getFirst() {
		if (isEmpty()) {
			return null;
		}
		return header.next.element;
	}

	/**
	 * Add the newly created node to the beginning of this list
	 * 
	 * 
	 * @param e
	 */
	public void addFirst(E e) {
		// TODO: Your implementation of this method starts here
		add(0, e);
	}

	/**
	 * Add the newly created node to the end of this list
	 * 
	 * 
	 * 
	 * @param e
	 */

	public void addLast(E e) {
		// TODO: Your implementation of this method starts here
		add(size, e);

	}

	/**
	 * Return the last element stored inside the last node in this list if the list
	 * is empty returns null.
	 * 
	 * 
	 * @return
	 */
	public E getLast() {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			return null;
		}
		return trailer.prev.element;

	}

	/**
	 * Remove the first node and then return the element stored inside this node the
	 * method return null if this list is empty
	 * 
	 * 
	 * @return
	 */

	public E removeFirst() {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			return null;
		}
		return remove(0);

	}

	/**
	 * Remove the last node in this list then return the element stored inside the
	 * last node. the method returns null if this list is empty
	 * 
	 * 
	 * @return
	 */
	public E removeLast() {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			return null;
		}
		return remove(size - 1);
	}

	/**
	 * 
	 * Search this list and return the first match index. If this list does not
	 * contain the element, it is unchanged and return -1 . More formally, returns
	 * the the lowest index {@code i} such that {@code equals(e, get(i))} (if such
	 * an element exists). Returns {@code i} if this list contained the specified
	 * element .
	 * 
	 * @param e
	 * @return
	 */
	public int indexOf(E e) {
		// TODO: Your implementation of this method starts here
		int i = 0;
		Node<E> curr = header.next;

		while (curr != trailer) {
			if (curr.element.equals(e)) {
				return i;
			}
			curr = curr.next;
			i++;
		}
		return -1;
	}

	/**
	 * Search this list and return the last match index. If this list does not
	 * contain the element, it is unchanged and return -1 . More formally, returns
	 * the the largest index {@code i} such that {@code equals(e, get(i))} (if such
	 * an element exists). Returns {@code i} if this list contained the specified
	 * element .
	 * 
	 * @param e
	 * @return
	 */

	public int lastIndexOf(E e) {
		// TODO: Your implementation of this method starts here
		int i = size - 1;
		Node<E> curr = trailer.prev;
		while (curr != header) {
			if (curr.element.equals(e)) {
				return i;
			}
			curr = curr.prev;
			i--;
		}
		return -1;

	}

	/**
	 * Sorts a list in ascending order by using a Comparator object
	 * 
	 * @param comparator
	 */
	public void sortAscending(Comparator<E> comparator) {
		// TODO: Your implementation of this method starts here

	}

	/**
	 * 
	 * Sorts a list in descending order by using a Comparator object
	 * 
	 * 
	 * @param comparator
	 */
	public void sortDescending(Comparator<E> comparator) {
		// TODO: Your implementation of this method starts here

	}

	///////

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

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> curr = header.next;
		for (int j = 0; j < i; j++) {
			curr = curr.next;
		}
		return curr.element;

	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> curr = header.next;
		for (int j = 0; j < i; j++) {
			curr = curr.next;
		}
		E last = curr.element;
		curr.element = e;
		return last;

	}

	@Override
	public void add(int i, E e) {
		// TODO: Your implementation of this method starts here
		if (i < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> curr = header;

		for (int j = 0; curr.next != trailer && j < i; j++) {
			curr = curr.next;
		}
		Node<E> nodeE = new Node<>(e);
		nodeE.next = curr.next;
		nodeE.prev = curr;
		curr.next.prev = nodeE;
		curr.next = nodeE;
		size++;

	}

	/**
	 * 
	 * Inserts the new element e after the specified index i in this list. Shifts
	 * the elements after the index i (if any)
	 * 
	 * Remember that You need if the index i is greater than the list size then you
	 * need to add the element e at the end of the list
	 * 
	 * @param i the index at which the new element should be stored
	 * @param e the new element to be stored
	 */

	public void addAfter(int i, E e) {
		// TODO: Your implementation of this method starts here
		if (i < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (i >= size) {
			addLast(e);
		}
		add(i + 1, e);

	}

	/**
	 * Removes all elements between the given lowerindex and upperindex inclusive.
	 * shifting all subsequent elements in the list closer to the front. Index: 0 1
	 * 2 3 4 5 6 Example: if list contains [ 1, 2, 3, 5, 6, 7, 8] you call
	 * removeBetween(2,4) then list will contains [1, 2, 7, 8] Hence, three elements
	 * are removed
	 * 
	 * Note: if the lower or upper index is greater than the size of the list then
	 * the lower or upper index will be updated to be the end of the list
	 * 
	 * 
	 * 
	 * 
	 * @param lowerindex the lower index
	 * @param upperindex the upper index,
	 * @throws IndexOutOfBoundsException if the index is negative or lowerindex is
	 *                                   greater than upperindex
	 * 
	 */

	public void removeBetween(int lowerindex, int upperindex) {
		// TODO: Your implementation of this method starts here
		if (upperindex > size) {
			upperindex = size - 1;
		}
		if (lowerindex > size) {
			lowerindex = size - 1;
		}
		if (lowerindex > upperindex || lowerindex < 0 || upperindex < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> leftNode = header.next;
		Node<E> rightNode = header.next;

		for (int i = 0; i < lowerindex; i++) {
			leftNode = leftNode.next;
		}

		for (int i = 0; i < upperindex; i++) {
			rightNode = rightNode.next;
		}

		leftNode.next = rightNode;
		rightNode.prev = leftNode;
		size -= (upperindex - lowerindex + 1);

	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}

		Node<E> curr = header.next;
		for (int j = 0; j < i; j++) {
			curr = curr.next;
		}
		E removedE = curr.element;

		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;

		size--;
		return removedE;

	}

	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO Auto-generated method stub
		if (e == null) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> curr = header.next;
		while (curr != trailer) {
			if (curr.element.equals(e)) {
				return true;
			}
			curr = curr.next;
		}
		return false;

	}

	@Override
	public boolean remove(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (e == null) {
			throw new NullPointerException();
		}
		Node<E> curr = header.next;
		while (curr != trailer) {
			if (curr.element.equals(e)) {
				curr.prev = curr.next;
				curr.next.prev = curr.prev;
				size--;
				return true;
			}
			curr = curr.next;
		}
		return false;

	}

	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (otherList == null) {
			throw new NullPointerException();
		}
		boolean changed = false;
		Iterator<E> iterator = otherList.iterator();

		while (iterator.hasNext()) {
			addLast(iterator.next());
			changed = true;
		}
		return changed;
	}

	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (otherList == null) {
			throw new NullPointerException();
		}
		boolean changed = false;

		Iterator<E> iterator = otherList.iterator();
		while (iterator.hasNext()) {
			changed |= remove(iterator.next());
		}
		return changed;

	}

	@Override
	public boolean retainAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (otherList == null) {
			throw new NullPointerException();
		}
		boolean changed = false;

		Node<E> curr = header.next;

		while (curr != trailer) {

			if (!otherList.contains(curr.element)) {
				Node<E> node = curr.next;
				curr.prev.next = curr.next;
				curr.next.prev = curr.prev;

				curr = node;
				size--;

				changed = true;

			} else {
				curr = curr.next;
			}
		}
		return changed;
	}

	/**
	 * Return String value represent the content of list as example "[30, 110, -110,
	 * -2, 1322]"
	 */
	@Override
	public String toString() {
		// TODO: Your implementation of this method starts here
		StringBuilder ans = new StringBuilder();
		ans.append("[");
		Node<E> curr = header.next;
		while (curr != trailer) {
			ans.append(curr.element);
			if (curr.next != trailer) {
				ans.append(", ");
			}
			curr = curr.next;
		}
		ans.append("]");
		return ans.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Node<E> curr = header.next;
			private Node<E> last = null;

			@Override
			public boolean hasNext() {
				return curr != trailer;
			}

			@Override
			public E next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				E currElement = curr.element;
				last = curr;
				curr = curr.next;
				return currElement;
			}

			@Override
			public void remove() {
				if (last == null) {
					throw new IllegalStateException();
				}

				Node<E> prev = last.prev;
				Node<E> next = last.next;

				prev.next = next;
				next.prev = prev;

				size--;
				last = null;
			}
		};
	}

}
