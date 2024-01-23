import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MyArrayListTest {
    @Test
    public void addElementAndGetElementTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        int[] expected = {1, 2};
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(myArrayList.getList()));
    }

    @Test
    public void addElementAtIndexTest() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("One");
        myArrayList.add("Two");
        myArrayList.add(1, "Three");
        String[] expected = {"One, Three, Two"};
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(myArrayList.getList()));
    }

    @Test
    public void addElementIndexOutOfBounds() {
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
        String[] expected = {"One, Three, Two"};
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(myArrayList.getList()));
    }

    @Test
    public void clearTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.clear();
        int[] expected = new int[0];
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(myArrayList.getList()));
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
        String[] expected = {"Five, Four, One, Six, Two, Two"};
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(myArrayList.getList()));
    }
}
