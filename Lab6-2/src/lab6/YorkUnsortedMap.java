package lab6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name : Ted Lee
//Yorku Email : ted04@my.yorku.ca	
//Date : 03/17/2024
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

public class YorkUnsortedMap<K, V> implements Map<K, V> {

	// -------------- nested MapEntry Class ------------------
	private static class MapEntry<K, V> implements Entry<K, V> {
		private K key;
		private V value;

		/**
		 * Constructor to set the key and value of this entry
		 * 
		 * @param key   the key
		 * @param value the value
		 */
		public MapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			// TODO: Your implementation of this method starts here
			return key;

		}

		@Override
		public V getValue() {
			// TODO: Your implementation of this method starts here
			return value;

		}

		/**
		 * Sets the value of this Entry with specified value
		 * 
		 * @param newValue the new value
		 * @return old value of this entry
		 */
		public V setValue(V newValue) {
			// TODO: Your implementation of this method starts here
			V prev = value;
			value = newValue;
			return prev;
		}

		/**
		 * String representation for map entry
		 */
		@Override
		public String toString() {
			return "<" + key + ", " + value + ">";
		}

	}

	// ---- end of nested MapEntry class----------------------
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// Define default load factor
	private static final double LOADFACTOR = 0.5;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// Define the default hash-table size. Must be a power of 2
	private static final int INITCAPACITY = 4;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// Define the maximum hash-table size. 1 << 30 is same as 2^30
	private static final int MAXCAPACITY = 1 << 30;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// The current hash-table capacity. Capacity must be a power of 2
	private int capacity;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// User specify a load factor used in this hash table
	private double loadFactor;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// The number of entries in the map
	private int size = 0;

	/**
	 * Add any other private data members or methods that are necessary to manage
	 * the YorkUnsortedMap You can use java.util.ArrayList or java.util.LinkedList
	 * (DoublyLinked) List to implement and store the map entries
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private List<MapEntry<K, V>> entries;

	/**
	 * no argument constructor Construct a map with the default capacity and load
	 * factor
	 */
	public YorkUnsortedMap() {
		// TODO: Your implementation of this method starts here
		this(INITCAPACITY, LOADFACTOR);
	}

	/**
	 * One argument constructor Construct a map with the specified initial capacity
	 * and default load factor
	 */
	public YorkUnsortedMap(int capacity) {
		// TODO: Your implementation of this method starts here
		this(capacity, LOADFACTOR);
	}

	/**
	 * Construct a map with the specified initial capacity and load factor. Note:
	 * the capacity of map must be power of 2 User/client can specify any value as
	 * map capacity. You should make sure that the map is created with the power of
	 * 2 capacity that is greater than the user's given capacity. For example, if
	 * the user specifies the input capacity as 13, you should create a map with a
	 * capacity of 16.
	 * 
	 * @param capacity   map capacity specified by client
	 * @param loadFactor map loading factor
	 */
	public YorkUnsortedMap(int capacity, double loadFactor) {
		// TODO: Your implementation of this method starts here
		this.capacity = capacity;
		this.loadFactor = loadFactor;
		entries = new ArrayList<>();
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
	public V get(K key) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (key == null) {
			throw new NullPointerException();
		}
		for (MapEntry<K, V> entry : entries) {
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		return null;
	}

	@Override
	public void clear() {
		// TODO: Your implementation of this method starts here
		entries.clear();

	}

	@Override
	public V put(K key, V value) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (key == null) {
			throw new NullPointerException();
		}

		for (MapEntry<K, V> entry : entries) {
			if (entry.getKey().equals(key)) {
				V prev = entry.getValue();
				remove(key);
				entries.add(new MapEntry<>(key, value));
				return prev;
			}
		}

		entries.add(new MapEntry<>(key, value));
		size++;
		return null;

	}

	@Override
	public V remove(K key) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (key == null) {
			throw new NullPointerException();
		}

		for (MapEntry<K, V> entry : entries) {
			if (entry.getKey().equals(key)) {
				V removed = entry.getValue();
				entries.remove(entry);
				size--;
				return removed;

			}
		}
		return null;
	}

	@Override
	public boolean containsKey(K key) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (key == null) {
			throw new NullPointerException();
		}

		for (MapEntry<K, V> entry : entries) {
			if (entry.getKey().equals(key)) {
				return true;
			}
		}
		return false;

	}

	@Override
	public boolean containsValue(V value) {
		// TODO: Your implementation of this method starts here
		for (MapEntry<K, V> entry : entries) {
			if (entry.getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterable<K> keySet() {
		// TODO: Your implementation of this method starts here
		List<K> keyList = new ArrayList<>();
		for (MapEntry<K, V> entry : entries) {
			keyList.add(entry.getKey());
		}
		return keyList;

	}

	@Override
	public Iterable<V> values() {
		// TODO: Your implementation of this method starts here
		List<V> valueList = new ArrayList<>();
		for (MapEntry<K, V> entry : entries) {
			valueList.add(entry.getValue());
		}
		return valueList;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO: Your implementation of this method starts here
		return new Iterable<Entry<K, V>>() {

			@Override
			public Iterator<Entry<K, V>> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<Entry<K, V>>() {
					private Iterator<MapEntry<K, V>> mapIter = entries.iterator();

					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return mapIter.hasNext();
					}

					@Override
					public Entry<K, V> next() {
						// TODO Auto-generated method stub
						return mapIter.next();
					}

				};
			}

		};
	}

	/**
	 * Return String value represent the content of map
	 * if Map contains only two entries
	 * put("A1", 124); and put("A2", 125);
	 * the output will be
	 * "[<A1, 124>,<A2, 125>]"
	 */
	@Override
	public String toString() {

		if (entries.isEmpty()) {
			return "[]";
		}

		StringBuilder ans = new StringBuilder("[");
		for (MapEntry<K, V> entry : entries) {
			ans.append(entry.toString()).append(",");
		}

		if (ans.length() > 1) {
			ans.deleteCharAt(ans.length() - 1);
		}

		ans.append("]");
		return ans.toString();

	}

}
