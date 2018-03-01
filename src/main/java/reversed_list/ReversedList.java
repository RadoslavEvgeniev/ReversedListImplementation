package reversed_list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReversedList<T> implements Iterable<T> {

    private static final int INITIAL_CAPACITY = 4;

    private int capacity;
    private int size;
    private T[] elements;

    @SuppressWarnings("unchecked")
    public ReversedList() {
        this.capacity = INITIAL_CAPACITY;
        this.elements = (T[]) new Object[this.capacity];
    }

    @SuppressWarnings("unchecked")
    public ReversedList(int capacity) {
        this.capacity = capacity;
        this.elements = (T[]) new Object[this.capacity];
    }

    public void add(T item) {
        if (this.size == this.capacity) {
            grow();
        }
        int index = this.capacity - 1 - this.size;
        this.elements[index] = item;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        T[] newArr = (T[]) new Object[this.capacity * 2];
        copyElements(newArr);
        this.elements = newArr;
        this.capacity *= 2;
    }

    private void copyElements(T[] newArr) {
        int index = this.capacity;
        for (T element : this.elements) {
            newArr[index] = element;
            index++;
        }
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        int indexToGet = this.capacity - this.size + index;
        if (index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException();
        }

        return this.elements[indexToGet];
    }

    public void set(int index, T element) {
        int indexToSet = this.capacity - this.size + index;
        if (index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException();
        }
        this.elements[indexToSet] = element;
    }

    public T removeAt(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException();
        }
        int indexToRemove = this.capacity - this.size + index;
        T element = this.elements[indexToRemove];
        this.elements[indexToRemove] = null;
        shift(indexToRemove);
        this.size--;
        return element;
    }

    private void shift(int indexToRemove) {
        for (int i = indexToRemove; i > 0; i--) {
            T temp = this.elements[i];
            this.elements[i] = this.elements[i - 1];
            this.elements[i - 1] = temp;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>();
    }

    private class MyIterator<T> implements Iterator<T>{

        private int index;

        @Override
        public boolean hasNext() {
            if (this.index < size) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            return (T) elements[index++];
        }

        @Override
        public void remove() {

        }
    }
}
