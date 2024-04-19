package AIPS.Labs.lab8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BNode<E> {

    public E info;
    public BNode<E> left;
    public BNode<E> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode() {
        this.info = null;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

}

class BTree<E extends Comparable<E>> {

    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode(elem);
    }

    public void makeRootNode(BNode<E> node) {
        root = node;
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {

        BNode<E> tmp = new BNode<E>(elem);

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

//    public int sumLeftSmaller(int targetValue) {
//        int sum = 0;
//        BNode<E> current = root.left;
//        while (current != null) {
//            if (Integer.parseInt(String.valueOf(current.info)) < targetValue) {
//                sum += Integer.parseInt(String.valueOf(current.info));
//            }
//            current = current.left;
//        }
//        return sum;
//    }
//
//    public int sumRightBigger(int targetValue) {
//        int sum = 0;
//        BNode<E> current = root.right;
//        while (current != null) {
//            if (Integer.parseInt(String.valueOf(current.info)) > targetValue) {
//                sum += Integer.parseInt(String.valueOf(current.info));
//            }
//            current = current.right;
//        }
//        return sum;
//    }

    public int sumLeftSmaller(int targetValue, BNode<E> currentNode) {

        int sum = 0;

        while (currentNode != null) {
            if (Integer.parseInt(String.valueOf(currentNode.info)) < targetValue) {
                sum += Integer.parseInt(String.valueOf(currentNode.info));
            }
            sumLeftSmaller(targetValue, currentNode.left);
            sumLeftSmaller(targetValue, currentNode.right);
        }

        return sum;

    }

    public int sumRightBigger(int targetValue, BNode<E> currentNode) {

        int sum = 0;

        while (currentNode != null) {
            if (Integer.parseInt(String.valueOf(currentNode.info)) > targetValue) {
                sum += Integer.parseInt(String.valueOf(currentNode.info));
            }
            sumLeftSmaller(targetValue, currentNode.left);
            sumLeftSmaller(targetValue, currentNode.right);
        }

        return sum;
    }

}

public class BinaryTreeSum {


    public static void main(String[] args) throws Exception {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        BNode<Integer>[] nodes = new BNode[N];
        BTree<Integer> tree = new BTree<Integer>();

        for (i = 0; i < N; i++)
            nodes[i] = new BNode<Integer>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = Integer.parseInt(st.nextToken());
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                // this node is the root
                tree.makeRootNode(nodes[index]);
            }
        }

        int baranaVrednost = Integer.parseInt(br.readLine());

        br.close();

        // vasiot kod ovde   // your code here

        System.out.println(tree.sumLeftSmaller(baranaVrednost, tree.root.left) + " " + tree.sumRightBigger(baranaVrednost, tree.root.right));


    }
}

