package utils;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @org.junit.jupiter.api.Test
    void pushFront() {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushFront(1);
        int res = list.at(0);
        assertEquals(1, res);
    }

    @org.junit.jupiter.api.Test
    void pushBack() {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushBack(1);
        int res = list.at(0);
        assertEquals(1, res);
    }

    LinkedList<Integer> createList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        return list;
    }

    @org.junit.jupiter.api.Test
    void insert() {
        LinkedList<Integer> list = createList();
        list.insert(42, 1);
        int res = list.at(1);
        assertEquals(42, res);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        LinkedList<Integer> list = createList();
        list.remove(1);
        int res = list.at(1);
        assertEquals(3, res);
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
        LinkedList<Integer> list = createList();
        list.remove(new Integer(1));
        int res = list.at(0);
        assertEquals(2, res);
    }

    @org.junit.jupiter.api.Test
    void at() {
        LinkedList<Integer> list = createList();
        int res = list.at(0);
        assertEquals(1, res);
    }

    @org.junit.jupiter.api.Test
    void getFirstElementPosition() {
        LinkedList<Integer> list = createList();
        int res = list.getFirstElementPosition(new Integer(1));
        assertEquals(0, res);
    }

    @org.junit.jupiter.api.Test
    void getLastElementPosition() {
        LinkedList<Integer> list = createList();
        list.pushBack(1);
        int res = list.getLastElementPosition(new Integer(1));
        assertEquals(4, res);
    }

    @org.junit.jupiter.api.Test
    void size() {
        LinkedList<Integer> list = createList();
        int res = list.size();
        assertEquals(4, res);
    }
}