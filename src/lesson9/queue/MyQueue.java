package lesson9.queue;

public class MyQueue<E> {
    private Node<E> firstElem;
    private Node<E> lastElem;
    int listSize = 0;

    public void add(Object value) {
        Node<E> newElem = new Node<>();
        if (listSize == 0){
            newElem.nextElem = null;
            newElem.prevElem = null;
            firstElem = newElem;
        } else {
            lastElem.nextElem = newElem;
            newElem.prevElem = lastElem;
        }
        lastElem = newElem;
        listSize++;
    }

    public E poll() {
        E returnElem = (E) firstElem.getValue();
        firstElem = firstElem.nextElem;
        firstElem.setPrevElem(null);
        listSize--;
        return returnElem;
    }

    public E peek() {
        return (E) firstElem.getValue();
    }

    public void clear() {
        firstElem = null;
        lastElem = null;
        listSize = 0;
    }

    public int size() {
        return listSize;
    }

    private static class Node<E> {
        private E value;
        private Node<E> prevElem;
        private Node<E> nextElem;

        public Node() {

        }

        public E getValue() {
            return value;
        }
        public void setNextElem(Node<E> nextElem) {
            this.nextElem = nextElem;
        }

        public void setPrevElem(Node<E> prevElem) {
            this.prevElem = prevElem;
        }
    }
}