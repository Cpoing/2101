package lab3;

import java.util.*;
import java.lang.annotation.*;
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


	}

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return -999;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return false;
		
	}

	/**
	 * Add the newly created node to the beginning of this list
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @param e
	 */
	@TimeComplexity(value = "")
	public void addFirst(E e) {
		// TODO: Your implementation of this method starts here
		

	}

	/**
	 * return the element stored inside the first node of this list the method
	 * return null if this list is empty
	 * 
	 * @return
	 */
	public E getFirst() {
		// TODO: Your implementation of this method starts here
		 return null;
	
	}

	/**
	 * Add the newly created node to the end of this list
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @param e
	 */
	@TimeComplexity(value = "")
	public void addLast(E e) {
		// TODO: Your implementation of this method starts here

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
		 return null;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		return null;
	
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		
		return null;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public void add(int i, E e) {
		// TODO: Your implementation of this method starts here

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
	@TimeComplexity(value = "")
	public E removeFirst() {
		// TODO: Your implementation of this method starts here
		return null;

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
	@TimeComplexity(value = "")
	public E removeLast() {
		// TODO: Your implementation of this method starts here
		return null;
		

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		return null;

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
		return 99;
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
	@TimeComplexity(value = "")
	public int lastIndexOf(E e) {
		// TODO: Your implementation of this method starts here
		
		return -99;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;
	
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean remove(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;
	
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean retainAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;
	}

	
	/**
	 * Return String value represent the content of list as 
	 * example "[30, 110, -110, -2, 1322]"
	 */
	@Override
	public String toString() {
		// TODO: Your implementation of this method starts here
		 return new String();
		
	}

	@Override
	public Iterator<E> iterator() {
		// TODO: Your implementation of this method starts here
		return null;
		
	}

	

}
