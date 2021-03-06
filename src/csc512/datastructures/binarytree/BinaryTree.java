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
        if (parentNode != null) {
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
            Node successor = removeSuccessor(currentNode);
            successor.leftNode = currentNode.leftNode;
            successor.rightNode = currentNode.rightNode;
            setNewChildNode(parentNode, isLeftChild, successor);
        } else if (currentNode.leftNode != null) {
            setNewChildNode(parentNode, isLeftChild, currentNode.leftNode);
        } else if (currentNode.rightNode != null) {
            setNewChildNode(parentNode, isLeftChild, currentNode.rightNode);
        } else {
            setNewChildNode(parentNode, isLeftChild, null);
        }

    }

    public void printInOrder() {
        printInOrder(rootNode);
    }

    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.leftNode);
            System.out.print(" " + node.data);
            printInOrder(node.rightNode);
        }
    }

    public void printPreOrder() {
        printPreOrder(rootNode);
    }

    public void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.data);
            printPreOrder(node.leftNode);
            printPreOrder(node.rightNode);
        }
    }

    public void printPostOrder() {
        printPostOrder(rootNode);
    }

    public void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.leftNode);
            printPostOrder(node.rightNode);
            System.out.print(" " + node.data);
        }
    }

    public void mirror() {
        rootNode.mirror(rootNode);
    }

    private Node removeSuccessor(Node currentNode) {
        Node successor = currentNode.rightNode;
        Node parentNode = null;
        while (successor.leftNode != null) {
            parentNode = successor;
            successor = successor.leftNode;
        }
        parentNode.leftNode = successor.rightNode;
        return successor;
    }

    private void setNewChildNode(Node parentNode, boolean isLeftChild, Node newChildNode) {
        if (parentNode != null) {
            if (isLeftChild)
                parentNode.leftNode = newChildNode;
            else
                parentNode.rightNode = newChildNode;
        } else {
            rootNode = newChildNode;
        }
    }
}
