package list;

import org.junit.Assert;
import org.junit.Test;

public class NodeListIteratorTest {
    @Test
    public void emptyNode() {
        NodeListIterator<String> nodeListIterator = new NodeListIterator<>(null);

        Assert.assertFalse(nodeListIterator.hasNext());
    }

    @Test
    public void oneNodeTest() {
        String value = "test";
        Node<String> node = new Node<>(value);
        NodeListIterator<String> nodeListIterator = new NodeListIterator<>(node);

        Assert.assertTrue(nodeListIterator.hasNext());
        Assert.assertEquals(value, nodeListIterator.next());

        Assert.assertFalse(nodeListIterator.hasNext());
    }

    @Test
    public void manyNodesTest() {
        String value1 = "a";
        String value2 = "b";
        String value3 = "c";
        Node<String> node1 = new Node<>(value1);
        Node<String> node2 = new Node<>(value2);
        Node<String> node3 = new Node<>(value3);
        node1.setNext(node2);
        node2.setPrev(node1);
        node2.setNext(node3);
        node3.setPrev(node2);
        NodeListIterator<String> nodeListIterator = new NodeListIterator<>(node1);

        Assert.assertTrue(nodeListIterator.hasNext());
        Assert.assertEquals(value1, nodeListIterator.next());

        Assert.assertTrue(nodeListIterator.hasNext());
        Assert.assertEquals(value2, nodeListIterator.next());

        Assert.assertTrue(nodeListIterator.hasNext());
        Assert.assertEquals(value3, nodeListIterator.next());

        Assert.assertFalse(nodeListIterator.hasNext());
    }
}
