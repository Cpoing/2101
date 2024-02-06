package lab2;

import java.util.*;
import java.lang.annotation.*;

//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name : Ted Lee
//Yorku Email :	219562040
//Date : 2/2/2024
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

public class YorkArrayList<E> implements List<E> {

	/**
	 * Initial size, default size, for the Array list
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;

	/**
	 * 
	 * Stores the elements of the array list Remember that you can not instantiate
	 * an array of E[], but you can instantiate an array of Object and then typecast
	 * it.
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private E[] data = (E[]) new Object[INITSIZE];

	/**
	 * current number of elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private int size = 0;

	/**
	 * No argument constructor
	 */
	public YorkArrayList() {
		// TODO: Your implementation of this method starts here
	}

	/**
	 * Constructor takes array of elements and then add then to
	 * the end of the Array list
	 * 
	 * @param objects
	 */

	public YorkArrayList(E[] objects) {
		// TODO: Your implementation of this method starts here
		size = objects.length;
		data = (E[]) new Object[size];
		for (int i = 0; i < size; i++) {
			data[i] = objects[i];
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

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(1)")
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if (i < 0 || i >= data.length) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		return data[i];
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(1)")
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		E temp = data[i];
		data[i] = e;
		return temp;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public void add(int i, E e) {
		// TODO: Your implementation of this method starts here
		sizeHelper();
		for (int j = size - 1; j >= i; j--) {
			data[j + 1] = data[j];
		}
		data[i] = e;
		size++;
	}

	private void sizeHelper() {
		if (size >= data.length) {
			E[] dataCopy = (E[]) (new Object[size * 2 + 1]);
			System.arraycopy(data, 0, dataCopy, 0, size);
			data = dataCopy;
		}
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if (i < 0 || i >= data.length) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		E temp = data[i];
		for (int k = i; k < size - 1; k++) {
			data[k] = data[k + 1];
		}
		size--;
		return temp;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (e == null) {
			throw new NullPointerException("null pointer");
		}
		for (int i = 0; i < size; i++) {
			if (data[i] == e) {
				return true;
			}
		}
		return false;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n2)")
	@Override
	public boolean remove(E e) throws NullPointerException {
		// TODO Your implementation of this method starts here
		if (e == null) {
			throw new NullPointerException("null pointer");
		}
		for (int i = 0; i < size; i++) {
			if (data[i] == e) {
				data[i] = null;
				for (int j = i; j < size - 1; j++) {
					data[j] = data[j + 1];
				}
				size--;
				return true;
			}
		}

		return false;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		// TODO Your implementation of this method starts here
		for (E element : otherList) {
			if (element == null) {
				throw new NullPointerException("null element");
			}
			add(size, element);
		}
		return true;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		// TODO Your implementation of this method starts here
		for (E element : otherList) {
			if (element == null) {
				throw new NullPointerException("null element");
			}
			remove(element);
		}
		return true;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean retainAll(List<E> otherList) throws NullPointerException {
		// TODO Your implementation of this method starts here
		for (int i = 0; i < size; i++) {
			for (E element : otherList) {
				if (get(i) != element) {
					remove(i);
					i--;
				}
			}
		}
		return true;
	}

	/**
	 * Return String value represent the content of list as
	 * example "[30, 110, -110, -2, 1322]"
	 */
	@Override
	public String toString() {
		String res = "[" + data[0];
		for (int i = 1; i < size; i++) {
			res += ", " + data[i];
		}
		res += "]";
		return res;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO: Your implementation of this method starts here
		Iterator<E> iterator = new Iterator<E>() {
			int curr = 0;

			@Override
			public boolean hasNext() {
				return curr < size;

			}

			@Override
			public E next() {
				return data[curr++];
			}

		};
		return iterator;
	}
}
