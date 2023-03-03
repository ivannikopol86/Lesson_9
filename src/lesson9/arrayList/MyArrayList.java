package lesson9.arrayList;


import java.util.Arrays;
import java.util.StringJoiner;



public class MyArrayList<T> {
    private static final int INIT_SIZE = 5;

    private Object[] arr;
    private int indexCounter;

    public MyArrayList() {

        arr = new Object[INIT_SIZE];
    }

    public void add(T value) {
        if (indexCounter == arr.length - 1) {
            resizeArr();
        }
        arr[indexCounter] = value;
        indexCounter++;
    }

    public T remove(int index) {
        T element = get(index);
        for (int i=index; i<indexCounter-1; i++) {
            arr[i] = arr[i+1];
        }
        indexCounter--;
        return element;

    }

    public void clear() {
        arr = (T[])new Object[1];
        indexCounter = 0;

    }

    public int size() {
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    public T get(int index) {
        if (index > 0 && index <= INIT_SIZE) {
             return (T) arr[index];
        }
        return null;
    }

    private void resizeArr() {

        arr = Arrays.copyOf(arr, arr.length * 2);
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", indexCounter=" + indexCounter +
                '}';
    }
}

