package sandbox.binaryheap.traversal;

import sandbox.myqueue.Queue;
import sandbox.myqueue.QueueOnLinkedList;

/**
 * Created by alterG on 12.07.2017.
 */
public class MyTree<E extends Comparable> {
    public Node<E> root;

    public boolean delete(E key) {
        Node<E> parent = root;
        Node<E> current = root;
        boolean isLeftChild = true;

        // searching for node
        while (!key.equals(current.value)) {
            parent = current;
            if (current.less(key)) {
                current = current.right;
                isLeftChild = false;
            } else {
                current = current.left;
                isLeftChild = true;
            }
            if (current == null) return false;  // node isn't exist
        }
        // if node has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            return true;
        }
        // if node has one child
        if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else {
                if (isLeftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
            return true;
        }
        if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else {
                if (isLeftChild) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            }
            return true;
        }
        // if node has two children
        Node successor = getSuccessor(current);
        if (current == root) {
            root = successor;
        } else {
            if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
        }
        successor.left = current.left;
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node<E> successorParent = delNode;
        Node<E> successor = delNode;
        Node<E> current = delNode.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    public void horizontalTraverse() {
        Queue<Node> queue = new QueueOnLinkedList<>();
        if (root != null) {
            Node<E> current = root;
            boolean isEnd;
            do {
                isEnd = true;
                current.printInfo();
                if (current.left != null) queue.enqueue(current.left);
                if (current.right != null) queue.enqueue(current.right);
                if (queue.size() != 0) {
                    current = queue.deque();
                    isEnd = false;
                }
            } while (!isEnd);
        }
    }

    public void verticalTraverse() {
        inOrder(root);
    }

    // reverse vertical
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            node.printInfo();
            inOrder(node.right);
        }
    }

    // direct vertical
    private void preOrder(Node node) {
        if (node != null) {
            node.printInfo();
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // end vertical
    private void postOrdered(Node node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
            node.printInfo();
        }
    }


    public void insert(E key) {
        if (root == null) {
            root = new Node<E>(key);
        } else {
            Node<E> current = root;
            while (true) {
                if (current.less(key)) {
                    if (current.right == null) {
                        current.right = new Node<E>(key);
                        return;
                    } else {
                        current = current.right;
                    }
                } else {
                    if (current.left == null) {
                        current.left = new Node<E>(key);
                        return;
                    } else {
                        current = current.left;
                    }
                }
            }
        }
    }

    public Node find(E key) {
        Node<E> current = root;
        while (current.value != key) {
            if (current.less(key)) {
                current = root.right;
            } else {
                current = root.left;
            }
            if (current == null) return null;
        }
        return current;
    }

    class Node<T extends Comparable> {
        T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
        }

        private boolean less(E value) {
            return this.value.compareTo(value) < 0;
        }

        void printInfo() {
            System.out.println(value);
        }
    }


}
