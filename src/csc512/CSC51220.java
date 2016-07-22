package csc512;

import csc512.datastructures.linkedlist.LinkedList;
import csc512.datastructures.stack.Stack;

/**
 * @author Vimukthi
 */
public class CSC51220 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        checkLinkedList();
        checkStack();
        displayInBinary(8);
    }

    public static void checkLinkedList() {
        LinkedList<Integer> dataList = new LinkedList();
        dataList.insertFirst(1);
        dataList.insertFirst(2);
        dataList.insertFirst(3);

        dataList.displayList();
        System.out.print("\n find 2 : ");
        dataList.find(2).displayNode();
        System.out.println("\ndelete first");
        System.out.print(" deleted : ");
        dataList.deleteFirst().displayNode();
        System.out.println("\nfull list : ");
        dataList.displayList();

        System.out.println("\nadd : 123");
        dataList.insertFirst(123);
        System.out.println("display : ");
        dataList.displayList();

        System.out.println("\n add 345");
        dataList.insertFirst(345);
        System.out.println("display ");
        dataList.displayList();

        System.out.println("\n find 123");
        dataList.find(123).displayNode();
        System.out.println("\n delete 345");
        int del = 345;
        dataList.delete(del).displayNode();
        System.out.println("full list");
        dataList.displayList();

        System.out.println("delete 789");
        System.out.println("deleted : " + dataList.delete(789));

        System.out.println("insert after 2");
        dataList.insertAfter(2, 456);
        System.out.println("full list");
        dataList.displayList();
        System.out.println("insert after 11");
        dataList.insertAfter(11, 159);
        System.out.println("full list");
        dataList.displayList();

        System.out.println("insert before 123");
        dataList.insertBefore(123, 159);
        System.out.println("full list");
        dataList.displayList();

        System.out.println("insert before 1");
        dataList.insertBefore(1, 753);
        System.out.println("full list");
        dataList.displayList();

        System.out.println("create a string list");
        LinkedList<String> tmp = new LinkedList<>();
        tmp.insertFirst("test 1");
        tmp.insertFirst("test 2");
        tmp.displayList();
        System.out.println("find test 1 : " + tmp.find("test 1"));

    }

    public static void checkStack() {
        Stack<Integer> numberStack = new Stack<>();
        System.out.println("pop : " + numberStack.pop());

        numberStack.push(1);
        numberStack.push(2);
        numberStack.push(3);

        System.out.println("display stack");
        numberStack.displayStack();

        System.out.println("pop : " + numberStack.pop());

        System.out.println("display stack");
        numberStack.displayStack();

        System.out.println("peek : " + numberStack.peek());

        System.out.println("display stack");
        numberStack.displayStack();
    }

    /**
     * Converts the given number in to binary and print it in console
     *
     * @param number
     */
    public static void displayInBinary(int number) {
        Stack<Integer> binaryValue = new Stack<>();
        int remainder = 0;
        if (number == 0) {
            binaryValue.push(0);
        } else {
            while (number > 0) {
                remainder = number % 2;
                number = number / 2;
                binaryValue.push(remainder);
            }
        }
        System.out.println("=============================================");
        while (!binaryValue.isEmpty()) {
            System.out.print(binaryValue.pop());
        }
        System.out.println("\n=============================================");
    }

}
