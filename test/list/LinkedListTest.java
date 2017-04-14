package list;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {
    @Test
    public void sizeTest() {
        List<String> list = new LinkedList<>();
        Assert.assertEquals(0, list.getSize());
        Assert.assertTrue(list.isEmpty());

        list.addLast("a");
        Assert.assertEquals(1, list.getSize());
        Assert.assertFalse(list.isEmpty());

        list.addLast("b");
        Assert.assertEquals(2, list.getSize());
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void operatingInFirstTest() {
        String value1 = "a";
        String value2 = "b";
        String[] array = { value2, value1 };
        List<String> list = new LinkedList<>();

        Assert.assertNull(list.getFirst());

        list.addFirst(value1);
        Assert.assertEquals(value1, list.getFirst());

        list.addFirst(value2);
        Assert.assertEquals(value2, list.getFirst());

        Assert.assertArrayEquals(array, list.toArrray());

        Assert.assertEquals(value2, list.removeFirst());
        Assert.assertEquals(value1, list.removeFirst());
        Assert.assertNull(list.removeFirst());
    }

    @Test
    public void operatingInLastTest() {
        String value1 = "a";
        String value2 = "b";
        String[] array = { value1, value2 };
        List<String> list = new LinkedList<>();

        Assert.assertNull(list.getLast());

        list.addLast(value1);
        Assert.assertEquals(value1, list.getLast());

        list.addLast(value2);
        Assert.assertEquals(value2, list.getLast());

        Assert.assertArrayEquals(array, list.toArrray());

        Assert.assertEquals(value2, list.removeLast());
        Assert.assertEquals(value1, list.removeLast());
        Assert.assertNull(list.removeLast());
    }

    @Test
    public void operatingQueueTest() {
        String value1 = "a";
        String value2 = "b";
        List<String> list = new LinkedList<>();

        list.addLast(value1);
        list.addLast(value2);

        Assert.assertEquals(value1, list.removeFirst());
        Assert.assertEquals(value2, list.removeFirst());
        Assert.assertNull(list.removeLast());
    }

    @Test
    public void toArrayTest() {
        String value1 = "a";
        String value2 = "b";
        String[] array1 = {};
        String[] array2 = { value1 };
        String[] array3 = { value1, value2 };
        List<String> list = new LinkedList<>();

        Assert.assertArrayEquals(array1, list.toArrray());

        list.addLast(value1);
        Assert.assertArrayEquals(array2, list.toArrray());

        list.addLast(value2);
        Assert.assertArrayEquals(array3, list.toArrray());
    }
}
