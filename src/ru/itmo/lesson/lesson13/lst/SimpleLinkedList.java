package ru.itmo.lesson.lesson13.lst;

public class SimpleLinkedList<T> {
    private Node<T> head;

    public void add(T value) {
        if (head == null) {
            head = new Node<T>(value);
            return;
        }
        find(-1).next = new Node(value);
    }

    public T get(int ind) { // 1
        Node<T> result = find(ind);
        return result == null ? null : result.value;
    }

    private Node find(int ind) { // 1
        if (ind == 0) return head;
        int cnt = 0;

        Node node = head;

        while (node != null) {
            if (cnt++ == ind) return node;
            if (ind < 0 && node.next == null) return node;
            node = node.next;
        }
        return null;
    }
}


class Node<T> {

    T value;
    Node next; // null

    public Node(T value) {
        this.value = value;
    }
}