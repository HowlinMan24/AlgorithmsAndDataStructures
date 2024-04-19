package Trees.BinaryTree;

public class BNode<T> {
    public T info;
    public BNode<T> left;
    public BNode<T> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode() {
        this.info = null;
        this.left = null;
        this.right = null;
    }

    public BNode(T info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public BNode(T info, BNode<T> left, BNode<T> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
}
