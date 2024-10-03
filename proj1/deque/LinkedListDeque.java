package deque;

import java.util.Iterator;

public class LinkedListDeque<T> {
    public int size;
    public IntNode<T> head;

    public LinkedListDeque() {
        head = new IntNode<>(null, null, null);
        head.next = head;
        head.prev = head;
        size = 0;
    }

    public LinkedListDeque(T item) {
        head = new IntNode(null, null, null);
        head.next = new IntNode(item, head, head);
        head.prev = head.next;
        size = 1;
    }

    public void addFirst(T item) {
        head.next = new IntNode(item, head, head.next);
        head.next.next.prev = head.next;
        size++;
    }

    public void addLast(T item) {
        head.prev = new IntNode(item, head.prev, head);
        head.prev.prev.next = head.prev;
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() { return size; }

    public void printDeque() {
        IntNode<T> temp = head.next;
        while(temp != head) {
            System.out.print(head.next.item);
            System.out.print(" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = head.next.item;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = head.next.item;
        head.prev = head.prev.prev;
        head.prev.next = head;
        size--;
        return item;
    }

    public T get(int index) {
        IntNode<T> temp = head.next;
        while (temp != head) {
            if (index == 0) {
                return temp.item;
            }
            temp = temp.next;
            index--;
        }
        return null;
    }

    public Iterator<T> iterator(){
        return null;
    }

    public boolean equals(Object o){
        return false;
    }


    public static class IntNode<N> {
        public N item;
        public IntNode<N> prev;
        public IntNode<N> next;

        public IntNode(N item, IntNode<N> prev, IntNode<N> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}