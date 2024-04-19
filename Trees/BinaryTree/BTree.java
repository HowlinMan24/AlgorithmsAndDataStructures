package Trees.BinaryTree;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BTree<T> {

    public BNode<T> root;

    public BTree() {
        this.root = null;
    }

    public BTree(T info) {
        this.root = new BNode<>(info);
    }

    public void makeRoot(T element) {
        this.root = new BNode<>(element);
    }

    public BNode<T> addChild(BNode<T> node, int where, T element) {
        BNode<T> temp = new BNode<>(element);

        if (where == BNode.LEFT) {
            if (node.left != null)
                return null;
            node.left = temp;
        } else {
            if (node.left != null)
                return null;
            node.left = temp;
        }

        return temp;
    }


    public void inorder() {
        System.out.println("Inorder: ");
        inorderR(root);
        System.out.println();
    }

    public void inorderR(BNode<T> node) {
        if (node != null) {
            inorderR(node.left);
            System.out.println(node.info.toString() + " ");
            inorderR(node.right);
        }
    }

    public void preorder() {
        System.out.println("Preorder: ");
        preorderR(root);
        System.out.println();
    }

    public void preorderR(BNode<T> node) {
        if (node != null) {
            System.out.println(node.info.toString() + " ");
            preorderR(node.left);
            preorderR(node.right);
        }
    }

    public void postorder() {
        System.out.println("Postorder: ");
        postorderR(root);
        System.out.println();
    }

    public void postorderR(BNode<T> node) {
        if (node != null) {
            postorderR(node.left);
            postorderR(node.right);
            System.out.println(node.info.toString() + " ");
        }
    }

    public void inorderNonRecursive() {
        Stack<BNode<T>> stack = new Stack<>();
        BNode<T> current = root;

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

    public void preorderNonRecursive() {
        Stack<BNode<T>> stack = new Stack<>();
        stack.push(root);
        BNode<T> current = stack.peek();
        while (!stack.isEmpty()) {

            if (current != null) {

                System.out.println(current.info.toString());

                if (current.right != null) {
                    stack.push(current.right);
                }

                current = current.left;

            } else {

                current = stack.pop();

            }

        }

    }

    public void postorderNonRecursive() {
        Stack<BNode<T>> stack = new Stack<>();
        stack.push(root);
        BNode<T> current = stack.pop();
        BNode<T> lastVisited = null;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                BNode<T> topOfStack = stack.peek();
                if (topOfStack.right != null && lastVisited != topOfStack.right) {
                    current = topOfStack.right;
                } else {
                    // No right child or right child is already visited
                    lastVisited = stack.pop();
                    System.out.println(lastVisited.info.toString());
                }
            }
        }

    }

    public int insideNodesR(BNode<T> node) {
        if (node == null)
            return 0;
        if (node.right == null && node.left == null)
            return 0;
        return insideNodesR(node.left) + insideNodesR(node.right) + 1;
    }

    public int insideNodes() {
        return insideNodesR(root);
    }

    public int leavesR(BNode<T> node) {
        if (node != null) {
            if (node.left == null && node.right == null)
                return 1;
            else
                return leavesR(node.left) + leavesR(node.right);
        } else {
            return 0;
        }
    }

    public int leaves() {
        return leavesR(root);
    }

    public int depthR(BNode<T> node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 0;
        return 1 + Math.max(depthR(node.left), depthR(node.right));
    }

    public int depth() {
        return depthR(root);
    }

    public void mirrorR(BNode<T> node) {
        BNode<T> temp;
        if (node == null)
            return;
        mirrorR(node.left);
        mirrorR(node.right);

        temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public void mirror() {
        mirrorR(root);
    }




    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        BNode<String>[] nodes = new BNode[N];
        BTree<String> tree = new BTree<String>();

        for (i=0;i<N;i++)
            nodes[i] = new BNode<String>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = st.nextToken();
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChild(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index].info);
            } else if (action.equals("RIGHT")) {
                tree.addChild(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index].info);
            } else {
                // this node is the root
                tree.makeRoot(nodes[index].info);
            }
        }


        int cases = Integer.parseInt(br.readLine());
        for (int l = 0; l < cases; l++) {
            String split[] = br.readLine().split(" +");
            String from = split[0];
            String to = split[1];

            // Vasiot kod ovde

        }

        tree.inorder();

    }


}
