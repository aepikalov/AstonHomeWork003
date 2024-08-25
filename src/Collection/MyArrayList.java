package Collection;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<T> {
    private static final int DEFAULT_SIZE = 10;
    private Object[] capacity;
    private int size;

    public MyArrayList() {
        capacity = new Object[DEFAULT_SIZE];
    }

    public MyArrayList(Collection<? extends T> collection) {
        capacity = new Object[collection.size()];
        for (T element : collection) {
            this.add(element);
        }
    }

    public void add(T element) {
        if (size == capacity.length) {
            capacity = Arrays.copyOf(capacity, capacity.length * 2);
        }
        capacity[size++] = element;
    }

    public T get(int index) {
        if (checkingCorrectIndex(index)) {
            return null;
        }
        return (T) capacity[index];
    }

    public void remove(int index) {
        if (checkingCorrectIndex(index)) return;
        System.arraycopy(capacity, index + 1, capacity, index, size - index - 1);
        capacity[--size] = null;
    }

    public void addAll(Collection<? extends T> collection) {
        if (!collection.isEmpty()) {
            for (T element : collection) {
                this.add(element);
            }
        }
    }

    public static <E extends Comparable<E>> Object[] bubbleSort(Collection<E> collection) {
        Object[] array = collection.toArray();
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if (((E)array[i]).compareTo((E)array[i+1]) > 0) {
                    isSorted = false;

                    Object temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        return array;
    }

    private boolean checkingCorrectIndex(int index) {
        boolean notCorrect = index < 0 || index >= size;
        if (notCorrect) System.out.println("Такого элемента не существует");
        return notCorrect;
    }

    @Override
    public String toString() {
        return Arrays.toString(capacity);
    }
}
