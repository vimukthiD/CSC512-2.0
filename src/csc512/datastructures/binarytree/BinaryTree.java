package csc512.datastructures.binarytree;

/**
 * @author Vimukthi
 */
public class BinaryTree {
    private Node rootNode;

    public BinaryTree() {
        rootNode = null;
    }

    public Node find(int key) {
        Node currentNode = rootNode;
        while (currentNode != null && currentNode.data != key) {
            if (key < currentNode.data) {
                currentNode = currentNode.leftNode;
            } else {
                currentNode = currentNode.rightNode;
            }
        }
        return currentNode;
    }

    /**
     * Insert the given value to the binary tree.
     * If the same value is already in the tree it will be replaced
     *
     * @param key
     */
    public void insert(int key) {
        Node currentNode = rootNode;
        Node parentNode = null;
        while (currentNode != null && currentNode.data != key) {
            parentNode = currentNode;
            if (key < currentNode.data) {
                currentNode = currentNode.leftNode;
            } else {
                currentNode = currentNode.rightNode;
            }
        }
        if (parentNode != null){
            setNewChildNode(parentNode, key < parentNode.data, new Node(key));
        } else {
            rootNode = new Node(key);
        }
    }

    public void delete(int key) {
        Node currentNode = rootNode;
        Node parentNode = null;
        boolean isLeftChild = false;
        while (currentNode != null && currentNode.data != key) {
            parentNode = currentNode;
            if (key < currentNode.data) {
                currentNode = currentNode.leftNode;
                isLeftChild = true;
            } else {
                currentNode = currentNode.rightNode;
                isLeftChild = false;
            }
        }
        if (currentNode == null) {
            return;
        } else if (currentNode.leftNode != null && currentNode.rightNode != null) {

        } else if (currentNode.leftNode != null) {
            setNewChildNode(parentNode, isLeftChild, currentNode.leftNode);
        } else if (currentNode.rightNode != null) {
            setNewChildNode(parentNode, isLeftChild, currentNode.rightNode);
        } else {
            setNewChildNode(parentNode, isLeftChild, null);
        }

    }

    private void setNewChildNode(Node parentNode, boolean isLeftChild, Node newChildNode) {
        if (parentNode != null){
            if (isLeftChild)
                parentNode.leftNode = newChildNode;
            else
                parentNode.rightNode = newChildNode;
        } else {
            rootNode = newChildNode;
        }
    }
}
