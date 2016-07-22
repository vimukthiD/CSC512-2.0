package csc512.datastructures.linkedlist;

/**
 * @param <T> type of the data this node hold
 * @author Vimukthi
 */
public class DataNode<T> {
    public T data;
    public DataNode nextNode;

    public DataNode(T data) {
        this.data = data;
        nextNode = null;
    }

    public void displayNode() {
        System.out.print(data.toString());
    }

    @Override
    public String toString() {
        String tmp = "";
        return tmp + data;
    }
}
