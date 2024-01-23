public interface CommonOperations<T> {
    void add(T element);

    void add(int index, T element);

    T get(int index);

    void deleteElement(T element);

    void clear();

    Object[] getList();
}
