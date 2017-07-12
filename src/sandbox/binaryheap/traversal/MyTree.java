package sandbox.binaryheap.traversal;

import sandbox.myqueue.Queue;
import sandbox.myqueue.QueueOnLinkedList;

/**
 * Created by alterG on 12.07.2017.
 */
public class MyTree<E extends Comparable> {
    public Node<E> root;

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


    public void init() {
        int pos = 0;
        Node current = root;
        while (pos < 15) {
            current.left = new Node(++pos);
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
