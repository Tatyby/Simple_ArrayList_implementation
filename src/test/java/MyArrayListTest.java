import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MyArrayListTest {
    @Test
    public void add_whenAddWithoutIndex_thenSuccessTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(1);
        myArrayList.add(2);

        Object[] expected = {1, 2};
        Assert.assertArrayEquals(expected, myArrayList.getList());
    }

    @Test
    public void add_whenAddOnIndex_thenSuccessTest() {
        MyArrayList<String> myArrayList = new MyArrayList<>();

        myArrayList.add("One");
        myArrayList.add("Two");
        myArrayList.add(1, "Three");

        String[] expected = {"One", "Three", "Two"};
        Assert.assertArrayEquals(expected, myArrayList.getList());
    }

    @Test
    public void add_whenLargeIndex_thenThrowsIndexOutOfBoundException() {
        MyArrayList<String> myArrayList = new MyArrayList<>();

        myArrayList.add("One");

        Assert.assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.add(3, "Tree"));
    }

    @Test
    public void deleteElementTest() {
        MyArrayList<String> myArrayList = new MyArrayList<>();

        myArrayList.add("One");
        myArrayList.add("Two");
        myArrayList.add("Two");
        myArrayList.add(1, "Three");
        myArrayList.deleteElement("Two");

        String[] expected = {"One", "Three", "Two"};
        Assert.assertArrayEquals(expected, myArrayList.getList());
    }

    @Test
    public void clearTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.clear();

        Object[] expected = new Object[0];
        Assert.assertArrayEquals(expected, myArrayList.getList());
    }

    @Test
    public void sortTest() {
        MyArrayList<String> myArrayList = new MyArrayList<>();

        myArrayList.add("One");
        myArrayList.add("Two");
        myArrayList.add("Two");
        myArrayList.add("Four");
        myArrayList.add("Five");
        myArrayList.add("Six");
        myArrayList.sort();
        System.out.println(Arrays.toString(myArrayList.getList()));

        Object[] expected = {"Five", "Four", "One", "Six", "Two", "Two"};
        Assert.assertArrayEquals(expected, myArrayList.getList());
    }
}
