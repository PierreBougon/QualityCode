package com.company;

public class LinkedListElement<T> {
    public T data;
    public LinkedListElement<T> next;

    public LinkedListElement(T data, LinkedListElement next) {
        this.data = data;
        this.next = next;
    }
}
