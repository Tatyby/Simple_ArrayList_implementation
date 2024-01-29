import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(5);
        list.add(0, 8);
        System.out.println("Добавлены элементы 8, 1, 5, 4, 5: " + Arrays.toString(list.getList()));
        System.out.println("Элемент с ндексом 0: " + list.get(0));
        list.deleteElement(5);
        System.out.println("Удалено первое вхождение элемента 5: " + Arrays.toString(list.getList()));
        list.deleteElement(9);
        list.sort();
        System.out.println("Список отсортирован: " + Arrays.toString(list.getList()));
        list.clear();
        System.out.println("Список очищен: " + Arrays.toString(list.getList()));
    }
}
