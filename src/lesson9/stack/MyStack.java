package lesson9.stack;

import java.util.EmptyStackException;
import java.util.Objects;

public class MyStack<E> {
    private Node<E> head;
    int size = 0;

    public void push(E value) {
        Node<E> node = new Node<>(value);
        if (value == null) {
            throw new NullPointerException();
        } else if (head != null) {
            node.nextElem = head;
        }

        head = node;
        size++;
    }
    public E remove(int index) {
        E removedValue;

        if (index == size - 1 && size > 0) {
            removedValue = head.element;
            head = head.nextElem;
        } else {
            Node<E> node = indexByPointer(index);
            removedValue = node.nextElem.element;
            node.nextElem = node.nextElem.nextElem;
        }

        size--;
        return removedValue;
    }
    public void clear() {
        head = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public E peek() {
        if (head == null) {
            throw new EmptyStackException();
        }

        return head.element;
    }
    public E pop() {
        if (head == null) {
            throw new EmptyStackException();
        }

        E element = head.element;
        head = head.nextElem;
        size--;
        return element;
    }
    private Node<E> indexByPointer(int index) {
        Objects.checkIndex(index, size);

        Node<E> node = head;
        for (int i = 0; i < size - index; i++) {
            node = node.nextElem;
        }

        return node;
    }






    private static class Node<E> {
        E element;
        Node<E> nextElem;

        Node (E element) {
            this.element = element;
        }

    }
}
