package csc512.datastructures.stack;

import csc512.datastructures.linkedlist.LinkedList;

/**
 * @param <E> type of the elements in this stack
 * @author Vimukthi
 */
public class Stack<E> {

    private LinkedList<E> dataList;

    public Stack() {
        dataList = new LinkedList<>();
    }

    /**
     * insert the element in to the top of the stack
     *
     * @param element
     */
    public void push(E element) {
        dataList.insertFirst(element);
    }

    /**
     * get the last entered element from the stack and remove it.
     *
     * @return the top element of the stack
     */
    public E pop() {
        if (!isEmpty()) {
            return (E) dataList.deleteFirst().data;
        }
        return null;
    }

    /**
     * get the top element of the stack without removing it.
     *
     * @return the element on the top of this stack
     */
    public E peek() {
        if (!isEmpty()) {
            return (E) dataList.getHead().data;
        }
        return null;
    }

    /**
     * check if the stack has any elements in it
     *
     * @return true if the stack does not contain any elements, false otherwise
     */
    public boolean isEmpty() {
        return dataList.isEmpty();
    }

    public void displayStack() {
        dataList.displayList();
    }

}
