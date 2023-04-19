package ua.hillel;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Implement a list that is based on array. This resizable data structure
 * is based on an array and is a simplified version of {@link java.util.ArrayList}.
 */
public class ArrayList<T> implements List<T> {
    private Object[] elements;
    private int size;

    private void resizeIfNeeded() {
        if (elements.length == size) {
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    @Override
    public void add(T element) {
        resizeIfNeeded();
        elements[size] = element;
        size++;
    }

    @Override
    public void add(int index, T element) {
        Objects.checkIndex(index, size);
        resizeIfNeeded();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elements[index];
    }

    @Override
    public T get(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size - 1);
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        elements[index] = element;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index > size - 1) {
            return false;
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return true;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
