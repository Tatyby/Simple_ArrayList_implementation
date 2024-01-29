import java.util.Arrays;

/**
 * Класс MyArrayList представляет простую реализацию динамического массива.
 * Он предоставляет методы добавления , удаления и сортировки элементов.
 * Этот класс не является потокобезопасным, его использование в многопточной среде требует соотвествубщих мер предосторожности.
 *
 * @param <T> тип элементов, которые содержит массив.
 */
public class MyArrayList<T extends Comparable<? super T>> implements Sortable<T>, CommonOperations<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T element) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = element;
    }

    @Override
    public void add(int index, T element) {
        indexOutOfBounds(index);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        indexOutOfBounds(index);
        return (T) array[index];
    }

    @Override
    public void deleteElement(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                deleteElementAtIndex(i);
                return;
            }
        }
    }

    @Override
    public void clear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
    }

    @Override
    public void sort() {
        if (size > 1) {
            Object[] tempArray = new Object[size];
            mergeSort(0, size - 1, tempArray);
        }
    }

    /**
     * Метод выполняет сортировку элементов списка с использованием алгоритма сортировки слиянием.
     *
     * @param low       индекс нижней границы сортируемого участка.
     * @param high      индекс верхней границы сортируемого участка.
     * @param tempArray временный массив для хранения промежуточных результатов сортировки.
     */
    private void mergeSort(int low, int high, Object[] tempArray) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid, tempArray);
            mergeSort(mid + 1, high, tempArray);
            merge(low, mid, high, tempArray);
        }
    }

    /**
     * Выполняет слияние двух отсорированных участков массива, в естественном порядке.
     *
     * @param low       индекс нижней границы первого участка.
     * @param mid       индекс верхней границы первого участка и нижней границы второго участка.
     * @param high      индекс верхней границы второго участка.
     * @param tempArray временный массив для хранения промежуточных результатов слияния.
     */
    private void merge(int low, int mid, int high, Object[] tempArray) {
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (((T) array[i]).compareTo((T) array[j]) <= 0) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }
        while (i <= mid) {
            tempArray[k++] = array[i++];
        }
        while (j <= high) {
            tempArray[k++] = array[j++];
        }
        System.arraycopy(tempArray, low, array, low, high - low + 1);
    }

    /**
     * Метод, удаляющий элемент по заданному индексу.
     *
     * @param index индекс входящего элемента.
     */
    private void deleteElementAtIndex(int index) {
        indexOutOfBounds(index);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }

    @Override
    public Object[] getList() {
        return Arrays.copyOf(array, size);
    }

    /**
     * Метод, увеличивающий длинну массива в два раза.
     */
    private void increaseCapacity() {
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }

    /**
     * Метод, выбрасывающий исключение, если индекс выходит за пределы допустимого.
     *
     * @param index индекс элемента.
     */
    private void indexOutOfBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

}
