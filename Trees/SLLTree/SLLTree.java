package Trees.SLLTree;

import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;
import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

public class SLLTree<T> {

    protected SLLNode<T> root; // The root of the tree

    public SLLTree() {
        this.root = null;
    }

    public SLLNode<T> root() {
        return root;
    }

    public SLLNode<T> parent(SLLNode<T> node) {
        return node.parent;
    }

    public int childCount(SLLNode<T> node) {
        SLLNode<T> temp = node.firstChild;
        int numChildren = 0;
        while (temp != null) {
            temp = temp.sibling;
            numChildren++;
        }
        return numChildren;
    }

    public void makeRoot(T element) {
        root = new SLLNode<>(element);
    }

    public SLLNode<T> addChild(SLLNode<T> node, T element) {
        SLLNode<T> temp = new SLLNode<>(element);
        temp.sibling = node.firstChild;
        node.firstChild = temp;
        temp.parent = node;
        return temp;
    }

    public Iterator<T> children(SLLNode<T> node) {
        return new SLLTreeIterator<T>(node.firstChild);
    }

    public void remove(SLLNode<T> node) {
        if (node.parent != null) {
            if (node.parent.firstChild == node) {
                node.parent.firstChild = node.sibling;
            } else {
                SLLNode<T> temp = node.parent.firstChild;
                while (temp.sibling != node) temp = temp.sibling;
                temp.sibling = node.sibling;
            }
        } else {
            root = null;
        }

    }

    public void printTreeRecursive(SLLNode<T> node, int level) {
        if (node == null)
            return;
        SLLNode<T> temp;
        for (int i = 0; i < level; i++) {
            System.out.println("   ");
        }
        System.out.println(node.getElement().toString());
        temp = node.firstChild;
        while (temp != null) {
            printTreeRecursive(temp, level + 1);
            temp = temp.sibling;
        }
    }

    public void printTree() {
        printTreeRecursive(root, 0);
    }

    public int countMacChildren() {
        return countMaxChildrenRecursive(root);
    }

    private int countMaxChildrenRecursive(SLLNode<T> node) {
        int t = childCount(node);
        SLLNode<T> temp = node.firstChild;
        while (temp != null) {
            t = Math.max(t, countMaxChildrenRecursive(temp));
            temp = temp.sibling;
        }
        return t;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] commands = new String[N];

        for (int i = 0; i < N; i++)
            commands[i] = br.readLine();

        br.close();

        SLLTree<String> tree = new SLLTree<String>();
        tree.makeRoot("c:");

        for (int i = 0; i < commands.length; i++) {

        }

    }

}
