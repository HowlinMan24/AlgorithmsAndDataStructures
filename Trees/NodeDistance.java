package Trees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
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

    @Override
    public String toString() {
        return "" + info;
    }
}

class BTree<E> {

    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode<>(elem);
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

    public String findPath(String from, String to) {
        Stack<BNode<E>> stack = new Stack<>();
        BNode<E> current = root;

        int maxDistance = 0;
        while (true) {
            while (current != null) {
                stack.push(current);
                if (current.info.equals(from)) {
                    maxDistance = 1;
                    if (current.info.equals(to))
                        return String.valueOf(0);
                } else if (maxDistance >= 1) {
                    if (current.info.equals(to))
                        return String.valueOf(maxDistance*2);
                    maxDistance++;
                }
                current = current.left;
            }
            if (stack.isEmpty())
                break;

            current = stack.peek();
//            System.out.println(current.info.toString() + " ");
            stack.pop();
            current = current.right;
        }
//        System.out.println();
            return "ERROR";
    }

}

public class NodeDistance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        int i, j;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        BNode<String>[] nodes = new BNode[N];
        BTree<String> tree = new BTree<>();

        for (i = 0; i < N; i++)
            nodes[i] = new BNode<>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = st.nextToken();
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


        int cases = Integer.parseInt(br.readLine());
        for (int l = 0; l < cases; l++) {
            String[] split = br.readLine().split(" +");
            String from = split[0];
            String to = split[1];

            // Vasiot kod ovde
            System.out.println(tree.findPath(from, to));

        }

        br.close();


    }

}

