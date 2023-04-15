package ua.hillel;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Implement doubly linked list that is based on {@link Node<T>} class (you should implement it as well).
 * This is a simplified version of {@link java.util.LinkedList}.
 */
public class LinkedList<T> implements List<T> {
    private static class Node<T> {
        T element;
        Node<T> prev;
        Node<T> next;

        public Node(T element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private Node<T> getNode(int index) {
        Node<T> currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode;
    }

    @Override
    public void add(T element) {
        Node<T> newElement = new Node<>(element);
        if (head == null) {
            head = tail = newElement;
        } else {
            tail.next = newElement;
            tail = newElement;
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        Objects.checkIndex(index, size + 1);
        Node<T> newElement = new Node<>(element);
        if (head == null || index == size) {
            add(element);
        } else if (index == 0) {
            newElement.next = head;
            head = newElement;
        } else {
            Node<T> prevIndex = getNode(index - 1);
            newElement.next = prevIndex.next;
            prevIndex.next = newElement;
        }
        size++;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNode(index).element;
    }

    @Override
    public T get(T element) {
        Node<T> currElement = head;
        while (currElement != null) {
            if (currElement.element.equals(element)) {
                return element;
            }
            currElement = currElement.next;
        }
        return null;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.element;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.element;
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        Node<T> node = getNode(index);
        node.element = element;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index > size) {
            return false;
        }
        Node<T> currElement = getNode(index);
        if (size == 1) {
            head = null;
            tail = null;
        } else if (currElement == head) {
            head = head.next;
            head.prev = null;
        } else if (currElement == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            currElement.prev.next = currElement.next;
            currElement.next.prev = currElement.prev;
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(T element) {
        Node<T> currElement = head;
        while (currElement != null) {
            if (currElement.element.equals(element)) {
                return true;
            }
            currElement = currElement.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 && head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Node<T> currElement = head;
        while (currElement != null) {
            Node<T> nextEl = currElement.next;
            currElement.prev = null;
            currElement.next = null;
            currElement.element = null;
            currElement = nextEl;
        }
        head = tail = null;
        size = 0;
    }
}
