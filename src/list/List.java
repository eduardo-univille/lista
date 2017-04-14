package list;

public interface List<T> extends Iterable<T> {
    public int getSize();

    public boolean isEmpty();

    public void addFirst(T value);

    public void addLast(T value);

    public T getFirst();

    public T getLast();

    public T removeFirst();

    public T removeLast();

    public T[] toArrray();
}
