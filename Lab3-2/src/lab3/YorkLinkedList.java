package lab3;

import java.util.Iterator;
import java.util.Objects;

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
public class YorkLinkedList<E> implements List<E> {

	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}

	///////////////////////////////////////////

	/**
	 * Need to use the variable head to refer to the first node in the list, and the
	 * variable tail to the last node.
	 * 
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private Node<E> head, tail;
	/**
	 * current number of elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private int size = 0;

	/////////////////////////////////////////

	public YorkLinkedList() {
		// TODO: Your implementation of this method starts here
	}

	public YorkLinkedList(E[] objects) {
		// TODO: Your implementation of this method starts here
		head = null;
		tail = null;
		size = 0;
		for (E object : objects) {
			addLast(object);
		}

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
	 * Add the newly created node to the beginning of this list
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @param e
	 */
	@TimeComplexity(value = "O(1)")
	public void addFirst(E e) {
		// TODO: Your implementation of this method starts here
		Node<E> newNode = new Node<>(e);
		newNode.next = head;
		head = newNode;
		if (size == 0) {
			tail = head;
		}
		size++;

	}

	/**
	 * return the element stored inside the first node of this list the method
	 * return null if this list is empty
	 * 
	 * @return
	 */
	public E getFirst() {
		// TODO: Your implementation of this method starts here
		if (head != null) {
			return head.element;
		} else {
			return null;
		}

	}

	/**
	 * Add the newly created node to the end of this list
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @param e
	 */
	@TimeComplexity(value = "O(1)")
	public void addLast(E e) {
		// TODO: Your implementation of this method starts here
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;
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
		if (tail != null) {
			return tail.element;
		} else
			return null;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> curr = head;
		for (int j = 0; j < i; j++) {
			curr = curr.next;
		}
		return curr.element;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> curr = head;
		for (int j = 0; j < i; j++) {
			curr = curr.next;
		}
		E prev = curr.element;
		curr.element = e;
		return prev;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public void add(int i, E e) {
		// TODO: Your implementation of this method starts here
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (i == 0) {
			addFirst(e);
		} else if (i == size) {
			addLast(e);
		} else {
			Node<E> newNode = new Node<>(e);
			Node<E> prev = head;
			for (int j = 0; j < i - 1; j++) {
				prev = prev.next;
			}
			newNode.next = prev.next;
			prev.next = newNode;
			size++;
		}
	}

	/**
	 * Remove the first node and then return the element stored inside this node the
	 * method return null if this list is empty
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @return
	 */
	@TimeComplexity(value = "O(1)")
	public E removeFirst() {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			return null;
		}
		E removed = head.element;
		head = head.next;
		size--;
		if (size == 0) {
			tail = null;
		}
		return removed;

	}

	/**
	 * Remove the last node in this list then return the element stored inside the
	 * last node. the method returns null if this list is empty
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @return
	 */
	@TimeComplexity(value = "O(n)")
	public E removeLast() {
		// TODO: Your implementation of this method starts here
		if (tail == null) {
			return null;
		}
		if (head == tail) {
			E removed = head.element;
			head = null;
			tail = null;
			size--;
			return removed;
		}
		Node<E> curr = head;
		while (curr.next != tail) {
			curr = curr.next;
		}
		E removed = tail.element;
		tail = curr;
		tail.next = null;
		size--;
		return removed;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (i == 0) {
			return removeFirst();
		} else if (i == size - 1) {
			return removeLast();
		} else {
			Node<E> prev = head;
			for (int j = 0; j < i - 1; j++) {
				prev = prev.next;
			}
			E removed = prev.next.element;
			prev.next = prev.next.next;
			size--;
			return removed;
		}

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
		Node<E> curr = head;
		for (int i = 0; i < size; i++) {
			if (Objects.equals(curr.element, e)) {
				return i;
			}
			curr = curr.next;
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
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @param e
	 * @return
	 */
	@TimeComplexity(value = "O(n)")
	public int lastIndexOf(E e) {
		// TODO: Your implementation of this method starts here
		int lastIndex = -1;
		Node<E> curr = head;
		for (int i = 0; i < size; i++) {
			if (Objects.equals(curr.element, e)) {
				lastIndex = i;
			}
			curr = curr.next;
		}
		return lastIndex;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		Node<E> curr = head;
		if (curr == null) {
			throw new NullPointerException();
		}
		while (curr != null) {
			if (Objects.equals(curr.element, e)) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n^2)")
	@Override
	public boolean remove(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		boolean removed = false;
		Node<E> curr = head;
		if (curr == null) {
			throw new NullPointerException();
		}
		while (curr != null) {
			if (Objects.equals(curr.element, e)) {
				remove(curr.element);
				removed = true;
			}
			curr = curr.next;
		}
		return removed;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		boolean added = false;
		for (E item : otherList) {
			if (item == null) {
				throw new NullPointerException();
			}
			addLast(item);
			added = true;
		}
		return added;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		boolean removed = false;
		for (E item : otherList) {
			if (item == null) {
				throw new NullPointerException();
			}
			while (remove(item) == true) {
				removed = true;
			}
		}
		return removed;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean retainAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		boolean retained = false;
		Node<E> curr = head;
		if (curr == null) {
			throw new NullPointerException();
		}
		while (curr != null) {
			if (!otherList.contains(curr.element)) {
				remove(curr.element);
				retained = true;
			}
			curr = curr.next;
		}
		return retained;
	}

	/**
	 * Return String value represent the content of list as
	 * example "[30, 110, -110, -2, 1322]"
	 */
	@Override
	public String toString() {
		// TODO: Your implementation of this method starts here
		String res = "[" + head.element;
		Node<E> curr = head.next;
		while (curr != null) {
			res += ", " + curr.element;
			curr = curr.next;
		}
		res += "]";
		return res;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO: Your implementation of this method starts here
		Iterator<E> iterator = new Iterator<>() {
			Node<E> curr = head;

			@Override
			public boolean hasNext() {
				if (curr != null) {
					return true;
				} else
					return false;
			}

			@Override
			public E next() {
				E element = curr.element;
				curr = curr.next;
				return element;
			}

		};
		return iterator;

	}

}
