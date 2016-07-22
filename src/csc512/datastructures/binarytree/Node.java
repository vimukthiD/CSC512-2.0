package csc512.datastructures.binarytree;

/**
 * @author Vimukthi
 */
public class Node {
    int data;
    Node leftNode;
    Node rightNode;

    public Node(int data) {
        this.data = data;
        leftNode = rightNode = null;
    }

    public static void preOrder(Node node) {
        if (node != null) {
            node.display();
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        } else {
            return;
        }
    }

    /**
     * Swap the immediate child nodes of the given node
     *
     * @param node the parent node
     */
    public static void swapChildren(Node node) {
        Node tempNode = node.leftNode;
        node.leftNode = node.rightNode;
        node.rightNode = tempNode;
    }

    /**
     * Change the sub tree starting from given node to its mirror image
     *
     * @param node the root node
     */
    public static void mirror(Node node) {
        if (node != null) {
            mirror(node.leftNode);
            mirror(node.rightNode);
            swapChildren(node);
        }
    }

    /**
     * Display the data value of this node
     */
    public void display() {
        System.out.println(data);
    }
}
