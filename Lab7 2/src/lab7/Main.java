package lab7;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        YorkBinarySearchTree<Integer> tree1 = new YorkBinarySearchTree<>(10);
        // System.out.println("Root of tree 1: " + tree1.root().getElement());
        tree1.insert(5);
        tree1.insert(20);
        tree1.insert(3);
        tree1.insert(9);
        tree1.insert(15);
        tree1.insert(25);
        LinkedList<Position<Integer>> tree1pre = (LinkedList<Position<Integer>>) tree1.preorder();
        System.out.printf("Tree 1 pre-order traversal: [");
        for (int i = 0; i < tree1pre.size(); i++) {
            if (i == tree1pre.size() - 1) {
                System.out.println(tree1pre.get(i).getElement() + "]");
            } else {
                System.out.printf(tree1pre.get(i).getElement() + ",");
            }
        }
        Iterator<Integer> it = tree1.iterator();
        System.out.println("Tree 1 in-order traversal: " + it.toString());
        LinkedList<Position<Integer>> tree1post = (LinkedList<Position<Integer>>) tree1.postorder();
        System.out.printf("Tree 1 post-order traversal: [");
        for (int i = 0; i < tree1post.size(); i++) {
            if (i == tree1pre.size() - 1) {
                System.out.println(tree1post.get(i).getElement() + "]");
            } else {
                System.out.printf(tree1post.get(i).getElement() + ",");
            }
        }

        System.out.println("Number of external nodes in tree 1: " + tree1.getNumberOfLeaves());
        System.out.println("Number of internal nodes in tree 1: " + tree1.getNumberofNonLeaves());

        LinkedList<Position<Integer>> tree1BFS = (LinkedList<Position<Integer>>) tree1.breadthfirst();
        System.out.printf("Tree 1 BF traversal: [");
        for (int i = 0; i < tree1BFS.size(); i++) {
            if (i == tree1BFS.size() - 1) {
                System.out.println(tree1BFS.get(i).getElement() + "]" + "\n");
            } else {
                System.out.printf(tree1BFS.get(i).getElement() + ",");
            }
        }

        YorkBinarySearchTree<Integer> tree2 = new YorkBinarySearchTree<>();
        try {
            System.out.println(tree2.root().getElement());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        tree2.insert(3);
        System.out.println("Root of tree 2: " + tree2.root().getElement());
        tree2.insert(4);
        tree2.insert(2);
        tree2.insert(5);
        Iterator<Integer> it3 = tree2.iterator();
        System.out.println("Tree 2 in-order traversal: " + it3.toString() + "\n");

        Integer[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        YorkBinarySearchTree<Integer> tree3 = new YorkBinarySearchTree<>(nums);
        System.out.println("Root of tree 3: " + tree3.root().getElement());
        Iterator<Integer> it2 = tree3.iterator();
        System.out.println("In-order traversal of tree 3: " + it2.toString());
        LinkedList<Position<Integer>> tree3BFS = (LinkedList<Position<Integer>>) tree3.breadthfirst();
        System.out.printf("Tree3 BFS: [");
        for (int i = 0; i < tree3BFS.size(); i++) {
            if (i == tree3BFS.size() - 1) {
                System.out.println(tree3BFS.get(i).getElement() + "]");
            } else {
                System.out.printf(tree3BFS.get(i).getElement() + ",");
            }
        }

        System.out.println("Tree 3 is valid BST: " + tree3.isFullBST());
        System.out.println("Number of external nodes in tree 3: " + tree3.getNumberOfLeaves());
        System.out.println("Number of internal nodes in tree 3: " + tree3.getNumberofNonLeaves());
        System.out.println("Value 5 is in tree 3? " + (tree3.search(5).getElement() == 5));

        Iterator<Integer> it4 = tree1.iterator();
        System.out.println("Tree 1 before removal of 3: " + it4.toString());
        tree1.remove(3);
        Iterator<Integer> it5 = tree1.iterator();
        System.out.println("Tree 1 after removal of 3: " + it5.toString());
        tree1.remove(15);
        Iterator<Integer> it6 = tree1.iterator();
        System.out.println("Tree 1 after removal of 15: " + it6.toString());

        tree1.root2.getLeft().setElement(11);
        System.out.println("Is tree still BST after breaking BST property? " + tree1.isFullBST());
    }
}