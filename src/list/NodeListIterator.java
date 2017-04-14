package list;

import java.util.Iterator;

public class NodeListIterator<T> implements Iterator<T> {
    private Node<T> node;

    public NodeListIterator(Node<T> node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return node != null;
    }

    @Override
    public T next() {
        T value = node.getValue();
        node = node.getNext();
        return value;
    }
}
