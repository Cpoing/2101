package lab5;

import java.util.*;

/**
 * Note that this is not a comprehensive test scenario. The lab will be graded
 * not only by JUnit tests given to you (if any) but also by additional tests
 * covering some other input values. This is to encourage you to take more
 * responsibility for the correctness of your code by writing your tests using
 * custom testers that can handle the boundary cases and error conditions.
 *
 *
 */

public class MainTester {
	public static void main(String[] args) {

		Comparator<Integer> intComparator = new Comparator<>() {
			@Override
			public int compare(Integer e1, Integer e2) {
				return e1.compareTo(e2);
			}
		};
		Comparator<String> stringComparator = new Comparator<>() {
			@Override
			public int compare(String e1, String e2) {
				return e1.compareTo(e2);
			}
		};

		String[] WeekMonthList = { "Monday", "Wednesday", "Friday", "Tuesday", "Thursday", "Monday", "Tuesday",
				"Friday", "Tuesday", "Monday", "Saturday" };
		System.out.println("============Create new list of String =================");
		YorkSortedDoublyLinkedList<String> slist = new YorkSortedDoublyLinkedList<>(WeekMonthList);
		System.out.println("=============================");
		System.out.println(slist);

		System.out.println(slist);

		System.out.println(slist.size());

		System.out.println(" list contains Saturday true: " + slist.contains("Saturday"));

		System.out.println("============Remove First and last =================");
		System.out.println(slist.removeFirst());
		System.out.println(slist.removeLast());
		System.out.println(slist);

		System.out.println("index of \"Friday\" is 1 ==>" + slist.indexOf("Friday"));
		System.out.println("index of \"Monday\" is 4 ==>" + slist.indexOf("Monday"));
		System.out.println("Last index of \"Monday\" is 8 ==>" + slist.lastIndexOf("Monday"));
		System.out.println("Last index of \"Tuesday\" is 7 ==>" + slist.lastIndexOf("Tuesday"));
		System.out.println("=============================");
		System.out.println(slist);
		System.out.println("============Remove \"Monday\" =================");

		slist.remove("Monday");
		System.out.println(slist);
		System.out.println("============Remove \"Tuesday\" =================");
		System.out.println(slist.remove(slist.lastIndexOf("Tuesday")));
		System.out.println(slist);
		System.out.println(" list contains \"Saturday\" false : " + slist.contains("Saturday"));

		System.out.println("============ add \"Sunday\" at index = 0 =================");
		slist.add(0, "Sunday");
		System.out.println(slist);
		System.out.println("============ add \"Sunday\" at index = 2 =================");
		slist.add(2, "Sunday");
		System.out.println(slist);
		System.out.println("============ add \"Sunday\" at index = 200 =================");
		slist.add(200, "Sunday");
		System.out.println(slist);

		System.out.println("============ add \"Saturday\" after index = 0 =================");
		slist.addAfter(0, "Saturday");
		System.out.println(slist);
		System.out.println("============ add \"Saturday\" after index = 2 =================");
		slist.addAfter(2, "Saturday");
		System.out.println(slist);
		System.out.println("============ add \"Saturday\" after  index = 200 =================");
		slist.addAfter(200, "Saturday");
		System.out.println(slist);

		slist.sortAscending(stringComparator);
		System.out.println("Sorted Ascending list = " + slist);
		slist.sortDescending(stringComparator);

		System.out.println("Sorted descending list = " + slist);

		System.out.println("============Create new list of Integer =================");
		YorkSortedDoublyLinkedList<Integer> intlistA = new YorkSortedDoublyLinkedList<>();
		System.out.println("isEmpty(): " + intlistA.isEmpty());
		System.out.println("============Add first =================");
		intlistA.addFirst(40);
		intlistA.addFirst(50);
		intlistA.addFirst(60);
		System.out.println(intlistA);
		System.out.println(intlistA.size());
		System.out.println("============Add Last =================");
		intlistA.addLast(40);
		intlistA.addLast(50);
		intlistA.addLast(60);
		intlistA.addLast(70);
		intlistA.addLast(80);
		System.out.println(intlistA);
		System.out.println(intlistA.size());
		System.out.println("index of 40 is 2 ==>" + intlistA.indexOf(40));
		System.out.println("index of 50 is 1 ==>" + intlistA.indexOf(50));
		System.out.println("index of 60 is 0 ==>" + intlistA.indexOf(60));

		System.out.println("Last index of 40 is 3 ==>" + intlistA.lastIndexOf(40));
		System.out.println("Last index of 50 is 4 ==>" + intlistA.lastIndexOf(50));
		System.out.println("Last index of 60 is 5 ==>" + intlistA.lastIndexOf(60));
		System.out.println("============Create new list of Integer =================");
		Integer[] b = { 10, 20, 30, 40, 50, 60 };
		Integer[] a = { 40, 50, 60, 70, 80, 90, 100 };
		YorkSortedDoublyLinkedList<Integer> intlistB = new YorkSortedDoublyLinkedList<>(b);
		System.out.println("listB = " + intlistB);
		Iterator itrb = intlistB.iterator();
		while (itrb.hasNext()) {
			System.out.println(itrb.next());
			itrb.remove();
		}
		System.out.println("listB = " + intlistB);
		System.out.println("listB  isEmpty(): " + intlistB.isEmpty());

		intlistB = new YorkSortedDoublyLinkedList<>(b);
		System.out.println("listB = " + intlistB);
		System.out.println(intlistB.size());
		System.out.println("");

		System.out.println("============Run AddAll =================");
		System.out.println("listA = " + intlistA);
		System.out.println("listB = " + intlistB);
		System.out.println("intlistA.addAll(intlistB) true==> " + intlistA.addAll(intlistB));
		System.out.println("listA = " + intlistA);

		System.out.println("============Run removeAll =================");
		intlistB = new YorkSortedDoublyLinkedList<>(b);
		System.out.println("listB = " + intlistB);
		intlistA = new YorkSortedDoublyLinkedList<>(a);
		System.out.println("listA = " + intlistA);
		System.out.println("intlistA.removeAll(intlistB) true==> " + intlistA.removeAll(intlistB));
		System.out.println("listA = " + intlistA);

		System.out.println("============Run retainAll =================");
		intlistB = new YorkSortedDoublyLinkedList<>();
		System.out.println("listB = " + intlistB);
		intlistA = new YorkSortedDoublyLinkedList<>(a);
		System.out.println("listA = " + intlistA);
		System.out.println("intlistA.retainAll(intlistB) true==> " + intlistA.retainAll(intlistB));
		System.out.println("listA = " + intlistA);
		System.out.println("============ create new list =================");
		
		
		
		intlistA = new YorkSortedDoublyLinkedList<>();

		Random rand = new Random();
		for (int i = 3; i < 15; i++) {
			intlistA.add(i, rand.nextInt(100) + 30);
		}
		System.out.println("listA = " + intlistA);

		intlistA.sortAscending(intComparator);
		System.out.println("Sorted Ascending listA = " + intlistA);
		intlistA.sortDescending(intComparator);

		System.out.println("Sorted descending listA = " + intlistA);

		Iterator<Integer> iter = intlistA.iterator();
		System.out.println("test iter:");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();

		System.out.println("listA  isEmpty(): " + intlistA.isEmpty());

	}
}
