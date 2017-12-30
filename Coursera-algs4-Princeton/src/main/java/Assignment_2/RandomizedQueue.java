package Assignment_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Object[] elements;
    //private Object[] elements;

    private int n;

    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        elements = new Object[16];
        n = 0;
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (n == elements.length) {
            resize(2 * elements.length);
        }
        size++;
        elements[n++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index;
        do {
            index = StdRandom.uniform(n);
        } while (elements[index] == null);

        Object item = elements[index];
        elements[index] = null;
        size--;

        if (size > 0 && size == elements.length / 4) {
            resize(elements.length / 2);
        }
        return (Item) item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index;
        do {
            index = StdRandom.uniform(n);
        } while (elements[index] == null);
        return (Item) elements[index];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    private class RandomizedIterator implements Iterator<Item> {
        private final RandomizedQueue<Item> randomizedQueue;

        private int i;

        public RandomizedIterator() {
            i = 0;
            randomizedQueue = new RandomizedQueue<>();
            for (Object item : elements) {

                if (item != null) {
                    randomizedQueue.enqueue((Item) item);
                    i++;
                }
            }
        }

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            i--;

            return randomizedQueue.dequeue();
        }
    }

    // unit testing (optional)
    public static void main(String[] args) {

        RandomizedQueue<String> eQueue = new RandomizedQueue<String>();
        eQueue.enqueue("aaa");
        eQueue.enqueue("bbb");
        eQueue.enqueue("ccc");
        eQueue.enqueue("ddd");
        eQueue.enqueue("eee");
        System.out.println(eQueue.dequeue());
        System.out.println(eQueue.dequeue());
        System.out.println(eQueue.dequeue());
        System.out.println(eQueue.dequeue());
        System.out.println(eQueue.dequeue());
    }

    private void resize(int capacity) {
        // textbook implementation
        Object[] temp = new Object[capacity];
        int tempN = 0;
        for (int i = 0; i < n; i++) {
            if (elements[i] != null) {
                temp[tempN++] = elements[i];
            }
        }
        n = tempN;
        elements = temp;
    }
}