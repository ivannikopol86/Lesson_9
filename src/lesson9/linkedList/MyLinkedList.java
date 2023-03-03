package lesson9.linkedList;


import java.util.Arrays;
import java.util.Objects;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> last;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);

        if (size == 0) {
            head = last = node;
        } else {
            node.prev = last;
            last.next = node;
            last = node;
        }
        size++;
    }
    public T remove(int index) {
        T removedValue;

        if (index == 0 && size > 0) {
            removedValue = head.element;
            head = head.next;

            if (head == null) {
                last = null;
            }
        } else {
            Node<T> node = removeIndex(index);
            removedValue = node.element;
            if (node.next != null & node.prev != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            if (index == size - 1) {
                last = last.prev;
            }
        }

        size--;
        return removedValue;
    }

    public T get(int index) {
        return removeIndex(index).element;
    }

    public Node<T> removeIndex(int index) {
        Objects.checkIndex(index, size);

        Node<T> node;
        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }

        return node;
    }


        public int size () {
            return size;
        }
        public void clear () {
            head = null;
            size = 0;
        }
    public String toString() {
        Object[] result = new Object[size];

        Node node = head;
        int cn = 0;

        while (node != null) {
            result[cn++] = node.element;
            node = node.next;
        }

        return Arrays.toString(result);
    }


        private static class Node<T> {
             T element;
             Node<T> next;
             Node<T> prev;

            public Node(T element) {
                this.element = element;

            }

        }
    }
