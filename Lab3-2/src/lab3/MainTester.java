package lab3;

import java.util.Iterator;



/*
  The implementations of the methods contains(E e), get(int index),
  indexOf(E e), lastIndexOf(E e), and set(int index, E e) are omitted in the
  text. Implement these methods.
*/

public class MainTester {
  public static void main(String[] args) {
    String[] WeekMonthList = {"Monday", "Wednesday", "Tuesday", "Thursday","Monday", 
    		"Tuesday","Friday", "Tuesday","Saturday"};
    YorkLinkedList<String> list = new YorkLinkedList<>(WeekMonthList);
    System.out.println("=============================");
    System.out.println(list);
    System.out.println("contains(\"Wednesday\"): " + list.contains("Wednesday"));
    System.out.println("contains(\"July\"): " + list.contains("July"));
    System.out.println("get(0): " + list.get(0));
    System.out.println("get(5): " + list.get(5));    
    System.out.println("get(7): " + list.get(7));
    
    System.out.println("indexOf(\"June\"): " + list.indexOf("June"));
    System.out.println("indexOf(\"Saturday\"): " + list.indexOf("Saturday"));
    System.out.println("indexOf(\"Thursday\"): " + list.indexOf("Thursday"));
    System.out.println("indexOf(\"Tuesday\"): " + list.indexOf("Tuesday"));
    System.out.println("lastIndexOf(\"Monday\"): " + list.lastIndexOf("Monday"));
    System.out.println("Add another Monday");
    list.add(list.size(),"Monday");
    System.out.println("lastIndexOf(\"Monday\"): " + list.lastIndexOf("Monday"));
    System.out.println("set(6, \"May\"): " + list.set(6, "May"));
    System.out.println("=============================");
    System.out.println(list);
    System.out.println("set(1, \"August\"): " + list.set(1, "August"));
    System.out.println("=============================");
    System.out.println(list);
    System.out.println("list size is "+ list.size());
    try {
    System.out.println("set(17, \"September\"): " + list.set(17, "September"));
    }catch (IndexOutOfBoundsException e) {
    	System.out.println("should throw IndexOutOfBoundsException - "+ e.getMessage());
    }
    
//    ============================================
    YorkLinkedList<Integer> intLlist = new YorkLinkedList<>();
    System.out.println("After invoking no-arg constructor: " + intLlist);

    Integer[] array = {0, -5, 22, 3, 78};
    intLlist = new YorkLinkedList<>(array);
    System.out.println("After invoking array-arg constructor: " + intLlist);

    System.out.println("getFirst(): " + intLlist.getFirst());
    System.out.println("getLast(): " + intLlist.getLast());

    intLlist.add(0,new Integer(10));
    System.out.println("add(0, new Integer(10)): " + intLlist);
    intLlist.addFirst(13);
    System.out.println("addFirst(13): " + intLlist);
    intLlist.addLast(600);
    System.out.println("addLast(600): " + intLlist);
    intLlist.add(0, -7);
    System.out.println("add(0, -7): " + intLlist);
    intLlist.add(20, 6);
    System.out.println("add(20, 6): " + intLlist);
    intLlist.add(3, -98);
    System.out.println("add(3, -98): " + intLlist);

    System.out.println("removeFirst(): " + intLlist.removeFirst());
    System.out.println("after removeFirst(): " + intLlist);
    System.out.println("removeLast(): " + intLlist.removeLast());
    System.out.println("after removeLast(): " + intLlist);
    System.out.println("remove(new Integer(-98)): " +
      intLlist.remove(new Integer(-98)));
    System.out.println("after remove(new Integer(-98)): " + intLlist);
    System.out.println("remove(4): " + intLlist.remove(4));
    System.out.println("after remove(4): " + intLlist);

    System.out.println("contains(22): " + intLlist.contains(22));
    System.out.println("contains(-15): " + intLlist.contains(-15));

    System.out.println("get(5): " + intLlist.get(5));

    System.out.println("indexOf(13): " + intLlist.indexOf(13));
    System.out.println("indexOf(78): " + intLlist.indexOf(78));
    System.out.println("indexOf(302): " + intLlist.indexOf(302));

    intLlist.add(intLlist.size(),600);
    System.out.println("after add(size(), 600): " + intLlist);
    System.out.println("indexOf(600): " + intLlist.indexOf(600));
    System.out.println("lastIndexOf(600): " + intLlist.lastIndexOf(600));

    System.out.println("set(7, 500): " + intLlist.set(7, 500));
    System.out.println("after set(7, 500): " + intLlist);

    System.out.println("size(): " + intLlist.size());

    System.out.println("isEmpty(): " + intLlist.isEmpty());

    Iterator<Integer> iter = intLlist.iterator();
    System.out.println("test iter:");
    while (iter.hasNext()) {
      System.out.print(iter.next() + " ");
    }
    System.out.println();
    

    System.out.println("isEmpty(): " + intLlist.isEmpty());
    
  }
}
