package com.datastructures;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {

    int i;
    private LinkedList<T> linkedList = new LinkedList<>();

    public Stack() {}

    public Stack(T elem) {
        push(elem);
    }

    public int size() {return linkedList.size();}

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T elem) {
        linkedList.addLast(elem);

    }

    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
        return linkedList.removeLast();
    }


    @Override
    public Iterator<T> iterator() {
        return linkedList.iterator();
    }
}
