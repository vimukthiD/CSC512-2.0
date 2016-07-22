package csc512.datastructures.linkedlist;

/**
 * @param <E> type of the elements in this LinkedList
 * @author Vimukthi
 */
public class LinkedList<E> {

    private DataNode<E> head;

    /**
     *
     */
    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public DataNode getHead() {
        return head;
    }

    /**
     * add the given data as the first element of the list
     *
     * @param data the value to be inserted
     */
    public void insertFirst(E data) {
        if (isEmpty()) {
            head = new DataNode<>(data);
        } else {
            DataNode newNode = new DataNode(data);
            newNode.nextNode = head;
            head = newNode;
        }
    }

    private DataNode<E> getLastNode() {
        DataNode lastNode = head;
        while (lastNode.nextNode != null) {
            lastNode = lastNode.nextNode;
        }
        return lastNode;
    }

    /**
     * remove the first element from the list
     *
     * @return the element which was removed, null if the list is empty
     */
    public DataNode deleteFirst() {
        DataNode deletedNode = null;
        if (!isEmpty()) {
            deletedNode = head;
            head = head.nextNode;
        }
        return deletedNode;
    }

    /**
     * display the list
     */
    public void displayList() {
        DataNode currentNode = head;
        while (currentNode != null) {
            currentNode.displayNode();
            System.out.println("");
            currentNode = currentNode.nextNode;
        }
    }

    /**
     * search the list for a given searchKey
     *
     * @param searchKey the key to search
     * @return the DataNode which is the first occurrence of the searchKey
     */
    public DataNode<E> find(E searchKey) {
        DataNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(searchKey)) {
                break;
            }
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    /**
     * delete first occurrence of the DataNode which have the deleteKey
     *
     * @param deleteKey key to delete
     * @return deleted DataNode, null if deleteKey is not in the list.
     */
    public DataNode delete(E deleteKey) {
        DataNode currentNode = head;
        DataNode previousNode = head;
        while (currentNode != null) {
            if (head.data.equals(deleteKey)) {
                return deleteFirst();
            }
            if (currentNode.data.equals(deleteKey)) {
                previousNode.nextNode = currentNode.nextNode;
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    /**
     * Add the given data after the itemKey element specified.
     *
     * @param itemKey key of the previous element
     * @param data data to be insert
     */
    public void insertAfter(E itemKey, E data) {
        DataNode currentNode = find(itemKey);
        if (currentNode != null) {
            DataNode node = new DataNode<>(data);
            node.nextNode = currentNode.nextNode;
            currentNode.nextNode = node;
        } else {
            System.out.println("The key is not in the list");
        }
    }

    /**
     * insert the given data item before the itemKey specified
     *
     * @param itemKey
     * @param data
     */
    public void insertBefore(E itemKey, E data) {
        if (itemKey.equals(head.data)) {
            insertFirst(data);
        } else {
            DataNode currentNode = head.nextNode;
            DataNode previousNode = head;
            while (currentNode != null) {
                if (currentNode.data.equals(data)) {
                    DataNode newNode = new DataNode(data);
                    previousNode.nextNode = newNode;
                    newNode.nextNode = currentNode;
                    break;
                }
            }
            if (currentNode == null) {
                System.out.println("The key is not in the list");
            }
        }
    }
}
