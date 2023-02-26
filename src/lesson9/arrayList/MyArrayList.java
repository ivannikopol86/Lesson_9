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

    public void remove(int index) {
        arr[index] = null;
        Object newArr[] = new Object[arr.length - 1];

        clearElem(index);
        createResizeArr();
    }

    public void clear() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
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

    public Object get(int index) {

        return arr[index];
    }

    private void resizeArr() {

        arr = Arrays.copyOf(arr, arr.length * 2);
    }

    private Object clearElem(int index) {
        arr[index] = null;
        for (; index < arr.length - 1; index++) {
            arr[index] = arr[index + 1];
        }
        return arr;
    }

    private Object[] createResizeArr() {
        Object[] newArr = new Object[arr.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        return arr = newArr.clone();
    }

}

