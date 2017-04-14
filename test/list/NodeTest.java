package list;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {
    @Test
    public void getValueTest() {
        String value = "test";
        Node<String> node = new Node<>(value);
        Assert.assertEquals(value, node.getValue());
    }

    @Test
    public void linksTest() {
        Node<String> node1 = new Node<>("node1");
        Node<String> node2 = new Node<>("node2");

        Assert.assertNull(node1.getNext());
        Assert.assertNull(node2.getPrev());

        node1.setNext(node2);
        node2.setPrev(node1);
        Assert.assertNull(node1.getPrev());
        Assert.assertEquals(node2, node1.getNext());
        Assert.assertEquals(node1, node2.getPrev());
        Assert.assertNull(node2.getNext());
    }
}
