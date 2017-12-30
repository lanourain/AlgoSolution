package Assignment_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node head;

    private Node last;

    private int size;

    // helper linked list class
    private class Node {
        private final Item item;

        private Node next;

        private Node pre;

        Node(Item item) {
            this.item = item;
        }
    }

    // construct an empty deque
    public Deque() {
        size = 0;
        head = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        validate(item);
        Node node = new Node(item);
        if (head == null) {
            head = last = node;
        }
        else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        validate(item);
        Node node = new Node(item);
        if (last == null) {
            head = last = node;
        }
        else {
            node.pre = last;
            last.next = node;
            last = node;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = head.item;
        head = head.next;
        size--;
        if (head == null) {
            last = null;
        }
        else {
            head.pre = null;
        }
        return item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = last.item;
        last = last.pre;
        size--;
        if (last == null) {
            head = null;
        }
        else {
            last.next = null;
        }
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class DequeIterator implements Iterator<Item> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.isEmpty();
        deque.addFirst("a");
        System.out.println(deque.removeFirst());
        deque.addFirst("b");
        System.out.println(deque.removeFirst());
    }

    private void validate(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }
}
