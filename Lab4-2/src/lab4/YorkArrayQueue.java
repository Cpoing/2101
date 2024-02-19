package lab4;

//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 
import java.util.NoSuchElementException;

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
 * Queue using expandable circular Array of generic type E. This is called a
 * "circular" queue with expandable array. if the queue (array) is full, create
 * a new queue (array) of twice the size, and copy the elements.
 *
 * @param <E>
 */
public class YorkArrayQueue<E> implements Queue<E> {

	/**
	 * Initial size, default size, for the queue
	 * remember that an empty queue has zero elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;

	/**
	 * Add any other private data members or methods that are necessary
	 * to manage the YorkArrayStack stored
	 */
	private E[] data;
	private int size;
	private int front;

	/**
	 * No argument constructor
	 */
	public YorkArrayQueue() {
		// TODO: Your implementation of this method starts here
		this(INITSIZE);

	}

	public YorkArrayQueue(int capacity) {
		// TODO: Your implementation of this method starts here
		data = (E[]) new Object[capacity];
		front = 0;
		size = 0;
	}

	/**
	 * Constructor takes array of elements and then add then to the end of the Array
	 * list
	 * 
	 * @param objects
	 */

	public YorkArrayQueue(E[] objects) {
		// TODO: Your implementation of this method starts here
		data = (E[]) new Object[objects.length];
		size = objects.length;
		for (E object : objects) {
			enqueue(object);
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

	@Override
	public void clear() {
		// TODO: Your implementation of this method starts here
		data = (E[]) new Object[data.length];
		front = 0;
		size = 0;

	}

	@Override
	public void enqueue(E e) {
		// TODO: Your implementation of this method starts here
		if (size == data.length) {
			E[] newData = (E[]) (new Object[data.length * 2]);
			for (int i = 0; i < size; i++) {
				newData[i] = data[(front + i) % data.length];
			}
			front = 0;
			data = newData;

		}
		data[(front + size) % data.length] = e;
		size++;

	}

	@Override
	public E first() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			throw new NoSuchElementException("Cannot remove from an empty queue");
		}
		return data[front];

	}

	@Override
	public E dequeue() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			throw new NoSuchElementException("Cannot remove from an empty queue");
		}
		E deque = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;

		return deque;

	}

	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		for (int i = 0; i < size; i++) {
			if (data[(front + i) % data.length].equals(e)) {
				return true;
			}
		}
		return false;

	}

	/**
	 * 
	 * Return String value represent the content of queue as
	 * example "[30, 110, -110, -2, 1322]"
	 * 
	 * remember that you should displays the contents of the queue in insertion
	 * order (FIFO), so the
	 * most-recently inserted element should be the last element
	 * 
	 */
	@Override
	public String toString() {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			return "[]";
		}
		String res = "[";
		for (int i = 0; i < size; i++) {
			res += data[(front + i) % data.length];
			if (i < size - 1) {
				res += ", ";
			}

		}
		res += "]";
		return res;
	}

}
