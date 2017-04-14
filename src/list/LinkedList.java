package list;

public class LinkedList<T> implements List<T> {
    private int size = 0;
    private Node<T> first = null;
    private Node<T> last = null;

    @Override
    public NodeListIterator<T> iterator() {
        return new NodeListIterator<T>(first);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    private void addInEmptyList(Node<T> node) {
        first = node;
        last = first;
    }

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            addInEmptyList(node);
        } else {
            first.setPrev(node);
            node.setNext(first);
            first = node;
        }
        size++;
    }

    @Override
    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            addInEmptyList(node);
        } else {
            node.setPrev(last);
            last.setNext(node);
            last = node;
        }
        size++;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return first.getValue();
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.getValue();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T value = first.getValue();

        first = first.getNext();
        if (first != null) {
            first.setPrev(null);
        }
        size--;

        return value;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T value = last.getValue();

        last = last.getPrev();
        if (last != null) {
            last.setPrev(null);
        }
        size--;

        return value;
    }

    @Override
    public T[] toArrray() {
        int i = 0;
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[size];

        for (T value : this) {
            array[i++] = value;
        }

        return array;
    }
}
