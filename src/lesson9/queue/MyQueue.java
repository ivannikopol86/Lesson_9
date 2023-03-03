package lesson9.queue;

import java.util.Arrays;

public class MyQueue<E> {
    private Node<E> firstElem;
    private Node<E> lastElem;
    int listSize = 0;

    public void add(E value) {
        Node<E> newElem = new Node<>(value);
        if (listSize == 0){
            newElem.nextElem = null;

            firstElem = newElem;
        } else {
            lastElem.nextElem = newElem;

        }
        lastElem = newElem;
        listSize++;
    }

    public E poll() {
        E returnElem = (E) firstElem.value;
        firstElem = firstElem.nextElem;
        listSize--;
        return returnElem;
    }

    public E peek() {

        return (E) firstElem.value;
    }

    public void clear() {
        firstElem = null;
        lastElem = null;
        listSize = 0;
    }

    public int size() {

        return listSize;
    }
    public String toString() {
        Object[] result = new Object[listSize];

        MyQueue.Node<E> node = firstElem;
        int cn = 0;

        while (node != null) {
            result[cn++] = node.value;
            node = node.nextElem;
        }

        return Arrays.toString(result);
    }

    private static class Node<E> {
        E value;
        Node<E> nextElem;

        Node(E value) {
            this.value = value;
        }

    }
}