package lab4;

import java.util.EmptyStackException;
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
 * Stack using expandable Array of generic type E.
 * if the stack (array) is full, create a new stack (array) of twice the size, and copy the elements.
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
	
	
	
	
	

	/**
	 * No argument constructor
	 */
	public YorkArrayStack() {
		// TODO: Your implementation of this method starts here
		
	}

	public YorkArrayStack(int capacity) {
		// TODO: Your implementation of this method starts here
		
	}

	/**
	 * Constructor takes array of elements and then add then to 
	 * the end of the Array list 
	 * @param objects
	 */
	
	public YorkArrayStack(E[] objects) {
		// TODO: Your implementation of this method starts here
	  }

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return -999;
		
	}

	@Override
	public void clear() {
		// TODO: Your implementation of this method starts here

	}
	
	
	
	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return false;

	}

	
	@Override
	public E top() throws EmptyStackException {
		//  TODO: Your implementation of this method starts here
				return null;

	
	}
	
	
	
	@Override
	public void push(E e) {
		// TODO: Your implementation of this method starts here
		


	}

	@Override
	public E pop() {
		// TODO: Your implementation of this method starts here
		return null;

	}
	



}
