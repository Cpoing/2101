package lab4;

import java.util.EmptyStackException;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name : Ted Lee
//Yorku Email : ted04@my.yorku.ca
//Date : 18/02/2024
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
 * Stack using expandable Array of generic type E.
 * if the stack (array) is full, create a new stack (array) of twice the size,
 * and copy the elements.
 *
 * @param <E>
 */
public class YorkArrayStack<E> implements Stack<E> {

	/**
	 * Initial size, default size, for the Array of stack
	 * remember that an empty stack has zero elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;

	/**
	 * Add any other private data members or methods that are necessary
	 * to manage the YorkArrayStack stored
	 */
	private E[] data;
	private int top;
	private int size;

	/**
	 * No argument constructor
	 */
	public YorkArrayStack() {
		// TODO: Your implementation of this method starts here
		data = (E[]) new Object[INITSIZE];
		size = 0;
		top = -1;

	}

	public YorkArrayStack(int capacity) {
		// TODO: Your implementation of this method starts here
		data = (E[]) new Object[capacity];
		size = 0;
		top = -1;

	}

	/**
	 * Constructor takes array of elements and then add then to
	 * the end of the Array list
	 * 
	 * @param objects
	 */

	public YorkArrayStack(E[] objects) {
		// TODO: Your implementation of this method starts here

		data = (E[]) new Object[objects.length];
		for (int i = 0; i < objects.length; i++) {
			data[i] = objects[i];
		}
		size = objects.length;
		top = size - 1;

	}

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return size;

	}

	@Override
	public void clear() {
		// TODO: Your implementation of this method starts here
		data = (E[]) new Object[INITSIZE];
		size = 0;
		top = -1;

	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return size == 0;

	}

	@Override
	public E top() throws EmptyStackException {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return data[top];

	}

	@Override
	public void push(E e) {
		// TODO: Your implementation of this method starts here
		if (size == data.length) {
			E[] newData = (E[]) new Object[data.length * 2];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
		top++;
		data[top] = e;
		size++;
	}

	@Override
	public E pop() {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			return null;
		}
		E ans = data[top];
		data[top] = null;
		top--;
		size--;
		return ans;

	}

}
