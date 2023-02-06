package org.example;

public class MyStore<T> {
    static class Node {
        int data;
        Node next;

    }
    static Node head;

    public static void BubbleSort(int[] data) {
        int size = getSize();
        for (int i = 0; i < size - 1; i++) {
            Node current = head;
            Node previous = null;
            for (int j = 0; j < size - i - 1; j++) {
                if (current.data > current.next.data) {
                    if (previous != null) {
                        previous.next = current.next;
                        current.next = current.next.next;
                        previous.next.next = current;
                    } else {
                        head = current.next;
                        current.next = head.next;
                        head.next = current;
                    }
                    previous = head;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        }
    }

    public static void selectionSort(int[] data) {
        Node current = head;
        Node tail = null;
        while (current.next != tail) {
            Node min = current;
            Node prev = current;
            Node temp = current.next;
            while (temp != tail) {
                if (temp.data < min.data) {
                    prev = min;
                    min = temp;
                }
                temp = temp.next;
            }
            prev.next = min.next;
            min.next = current.next;
            current.next = min;
            current = current.next;
        }
    }

    public static void insertionSort(int[] data) {
        Node current = head.next;
        while (current != null) {
            Node prev = head;
            while (prev != current) {
                if (prev.data > current.data) {
                    int temp = prev.data;
                    prev.data = current.data;
                    current.data = temp;
                }
                prev = prev.next;
            }
            current = current.next;
        }
    }

    public boolean contains(T item) {
        Node current = head;
        while (current != null) {
            if (current.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void add(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    static int getSize() {
        int size = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }

    static void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
