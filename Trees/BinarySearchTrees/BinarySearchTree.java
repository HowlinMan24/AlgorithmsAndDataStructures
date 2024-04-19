package Trees.BinarySearchTrees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {

    private BNode<E> root;

    public BinarySearchTree() {
        root = null;
    }

    private BNode<E> insert(E info, BNode<E> node) {
        if (node == null) {
            node = new BNode<>(info, null, null);
        } else if (info.compareTo(node.info) < 0) {
            node.left = insert(info, node.left);
        } else if (info.compareTo(node.info) > 0) {
            node.right = insert(info, node.right);
        }
        return node;
    }

    public void insert(E info) {
        this.root = insert(info, root);
    }

    public E findMin() {
        return findMinNode(root).info;
    }

    private BNode<E> findMinNode(BNode<E> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        return findMinNode(node.left);
    }

    private BNode<E> findMaxNode(BNode<E> t) {
        if (t == null) {
            return null;
        } else if (t.right == null) {
            return t;
        }
        return findMaxNode(t.right);
    }

    public E findMax() {
        return findMaxNode(root).info;
    }

    private BNode<E> findNode(E x, BNode<E> t) {
        if (t == null)
            return null;
        if (x.compareTo(t.info) < 0) {
            return findNode(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            return findNode(x, t.right);
        } else {
            return t; // Match
        }
    }

    public BNode<E> find(E x) {
        return findNode(x, root);
    }

    @SuppressWarnings("unchecked")
    private BNode<E> removeNode(Comparable x, BNode<E> t) {
        if (t == null)
            return t; // Item not found; do nothing
        if (x.compareTo(t.info) < 0) {
            t.left = removeNode(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            t.right = removeNode(x, t.right);
        } else if (t.left != null && t.right != null) { // Two childrent.info = findMin(t.right).info;
            t.right = removeNode(t.info, t.right);
        } else {
            if (t.left != null)
                return t.left;
            else
                return t.right;
        }
        return t;
    }

    public void remove(E x) {
        root = removeNode(x, root);
    }

    public void inorderNonRecursive() {
        Stack<BNode<E>> stack = new Stack<>();
        BNode<E> current = root;

        while (true) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (stack.isEmpty())
                break;

            current = stack.peek();
            System.out.println(current.info.toString() + " ");
            stack.pop();
            current = current.right;
        }
        System.out.println();
    }


    public static void main(String args[]) throws Exception {
        int i, j, k;
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            tree.insert(num);
        }
        br.close();
        tree.inorderNonRecursive();
    }


}
