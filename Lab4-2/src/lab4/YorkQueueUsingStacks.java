package lab4;

import java.util.*;

//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

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
 * Implement the queue interface using two stacks 
 * 
 * @param <E>
 */

public class YorkQueueUsingStacks<E> implements Queue<E> {
	
	
	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkArrayStack stored
	 */
	
	
	

	public YorkQueueUsingStacks(){
		// TODO: Your implementation of this method starts here
	}
	
	
	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return 0;
	
	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return false;
		
	}

	@Override
	public void clear() {
		// TODO: Your implementation of this method starts here
		
		
	}

	@Override
	public void enqueue(E e) {
		// TODO: Your implementation of this method starts here
		
	}

	@Override
	public E first() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		return null;

	}

	@Override
	public E dequeue() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		return null;	
	}

	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;
	
		
	}
	
	
	/**
	 * 
	 *  Return String value represent the content of queue as 
	 * example "[30, 110, -110, -2, 1322]"
	 * 
	 * remember that you should displays the contents of the queue in insertion order (FIFO), so the
	 * most-recently inserted element should be the last element
	 * 
	 */
	@Override
	public String toString() {
		// TODO: Your implementation of this method starts here
		return "";
	}
	

}
