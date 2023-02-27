package lesson9.stack;

public class MyStack<E> {
    private Node<E> firstElem;
    private Node<E> lastElem;
    int listSize = 0;

    public void push(Object value) {
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

    public void remove(int index) {
        Node<E> currentElem = lastElem;
        Node<E> prev;
        Node<E> next;
        int indexElem = 1;

        for (int i = 1; i < listSize; i++) {
            if (index == 1) {
                firstElem = firstElem.nextElem;
                firstElem.setPrevElem(null);
                listSize--;
                break;
            } else if (index == listSize) {
                currentElem = lastElem.prevElem;
                currentElem.setNextElem(null);
                listSize--;
                break;
            } else if(index == indexElem) {
                prev = currentElem.prevElem;
                next = currentElem.nextElem;
                prev.setNextElem(next);
                next.setPrevElem(prev);
                listSize--;
                break;
            } else {
                currentElem = currentElem.nextElem;
                indexElem++;
            }
        }
    }

    public E peek() {
        return (E) lastElem.getValue();
    }

    public E pop() {
        E returnElem = (E) lastElem.getValue();
        lastElem = lastElem.prevElem;
        lastElem.setNextElem(null);
        listSize--;
        return returnElem;
    }

    public void clear() {
        firstElem = null;
        lastElem = null;
    }

    public int size() {
        return listSize;
    }

    private static class Node<E> {
        private E value;
        private Node<E> prevElem;
        private Node<E> nextElem;

        Node() {
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
