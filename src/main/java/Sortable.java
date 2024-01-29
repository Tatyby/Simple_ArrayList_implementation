public interface Sortable<T extends Comparable<? super T>> {
    /**
     * Метод сортирует в естественном порядке (используется алгоритм сортировки слиянием).
     */
    void sort();
}
