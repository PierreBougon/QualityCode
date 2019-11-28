package com.company;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    private LinkedListElement<T> root;

    private class LinkedListElement<T> {
        public T data;
        public LinkedListElement<T> next;

        private LinkedListElement(T data, LinkedListElement next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedList() {
        this.root = null;
    }

    public void pushFront(T data) {
        LinkedListElement<T> oldRoot = this.root;
        this.root = new LinkedListElement<>(data, oldRoot);
    }

    public void pushBack(T data) {
        if (this.root == null) {
            pushFront(data);
            return;
        }
        LinkedListElement<T> lastElem = getTail();
        lastElem.next = new LinkedListElement<>(data, null);
    }

    public void insert(T data, int position) {
        if (position == 0) {
            pushFront(data);
            return;
        }
        LinkedListElement<T> prevElem = elemAt(position - 1);
        LinkedListElement<T> nextElem = prevElem.next;

        prevElem.next = new LinkedListElement<>(data, nextElem);
    }

    public T remove(int position) {
        LinkedListElement<T> prevElem;
        LinkedListElement<T> elem;

        if (position == 0) {
            prevElem = null;
            elem = elemAt(position);
        }
        else {
            prevElem = elemAt(position - 1);
            elem = prevElem.next;
        }


        if (prevElem != null) {
            prevElem.next = prevElem.next.next;
        }
        else {
            this.root = elem.next;
        }
        return elem.data;
    }

    public T remove(T data) throws NoSuchElementException {
        LinkedListElement<T> prevElem = findPrevious(data);
        LinkedListElement<T> elem;

        if (prevElem == null) {
            elem = find(data);
            this.root = elem.next;
        }
        else {
            elem = prevElem.next;
            prevElem.next = prevElem.next.next;
        }
        return elem.data;

    }

    private LinkedListElement<T> find(T data) {
        LinkedListElement<T> tmpElem = this.root;

        for (; tmpElem != null && !tmpElem.data.equals(data); tmpElem = tmpElem.next) {
        }
        if (tmpElem == null)
            throw new NoSuchElementException();

        return tmpElem;
    }

    private LinkedListElement<T> findPrevious(T data) {
        LinkedListElement<T> tmpElem = this.root;

        for (; tmpElem != null && tmpElem.next != null && !tmpElem.next.data.equals(data); tmpElem = tmpElem.next) {
        }
        if (tmpElem == null)
            return null;

        return tmpElem;
    }

    public T at(int position) {
        return elemAt(position).data;
    }

    private LinkedListElement<T> elemAt(int position) {
        LinkedListElement<T> tmpElem = this.root;
        int size = size();

        if (size < position || position < 0)
            throw new ArrayIndexOutOfBoundsException();
        for (int i = 0; i < position; ++i) {
            tmpElem = tmpElem.next;
        }
        return tmpElem;
    }

    public int getFirstElementPosition(T data) {
        return getElementPosition(data, true);
    }

    public int getLastElementPosition(T data) {
        return getElementPosition(data, false);
    }

    private int getElementPosition(T data, boolean findFirstElem) {
        LinkedListElement<T> tmpElem = this.root;
        int potentialElemPos = -1;

        for (int i = 0; tmpElem != null; tmpElem = tmpElem.next, ++i) {
            if (tmpElem.data.equals(data) && findFirstElem)
                return i;
            else if (tmpElem.data.equals(data) && !findFirstElem)
                potentialElemPos = i;
        }
        if (potentialElemPos > -1)
            return potentialElemPos;
        throw new NoSuchElementException();
    }

    public int size() {
        int i = 0;
        LinkedListElement<T> tmpElem = this.root;

        while (tmpElem != null) {
            tmpElem = tmpElem.next;
            ++i;
        }
        return i;
    }

    private LinkedListElement<T> getTail() {
        LinkedListElement<T> tmpElem = this.root;
        for (; tmpElem.next != null; tmpElem = tmpElem.next) {
        }
        return tmpElem;
    }
}
