public interface CommonOperations<T> {
    /**
     * Метод добавляет элемент в конец списка.
     *
     * @param element элемент для добавления.
     */
    void add(T element);

    /**
     * Метод добавляет элемен по указанному индексу, сдвигая остальные элементы.
     *
     * @param index   индекс, по которому нужно добавить элемент.
     * @param element элемент для добавления.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы допустимого диапазона.
     */
    void add(int index, T element);

    /**
     * Метод возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента.
     * @return элемент по указанному индексу.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы допустимого диапазона.
     */
    T get(int index);

    /**
     * Метод удаляет первое вхождение указанного элемента из списка.
     *
     * @param element элемент для удаления.
     */
    void deleteElement(T element);

    /**
     * Метод очищает весь список.
     */
    void clear();

    /**
     * Метод возвращающий массив значений.
     *
     * @return возвращает массив значений.
     */
    Object[] getList();
}
