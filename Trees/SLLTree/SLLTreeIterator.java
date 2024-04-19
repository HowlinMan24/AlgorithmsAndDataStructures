package Trees.SLLTree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SLLTreeIterator<T> implements Iterator<T> {
    SLLNode<T> start, current;

    public SLLTreeIterator(SLLNode<T> node) {
        this.start = node;
        this.current = node;
    }


    @Override
    public boolean hasNext() {
        return (current != null);
    }

    @Override
    public T next() throws NoSuchElementException {
        if (current != null) {
            SLLNode<T> temp = current;
            current = current.sibling;
            return temp.getElement();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove() {
        if (current != null)
            current = current.sibling;
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        Iterator.super.forEachRemaining(action);
    }
}
