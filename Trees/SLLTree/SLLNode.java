package Trees.SLLTree;

import org.w3c.dom.*;

public class SLLNode<T> {
    SLLNode<T> parent, sibling, firstChild;
    T element;

    public SLLNode(T element) {
        this.element = element;
        this.parent = sibling = firstChild = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

}
