package Queue;

import LinkedList.LinearNode;

public class LinkedQueue<T> {

    /**
     * first node of the queue
     */
    private LinearNode<T> front;

    /**
     * last node of the queue
     */
    private LinearNode<T> rear;

    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * method to add an element to the queue
     * print the element enqueued
     *
     * @param elem the element to add
     */
    public void enqueue(T elem) {
        LinearNode<T> newNode = new LinearNode<>(elem);
        if (isEmpty()) {
            front = newNode;

        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
        System.out.println("Enqueued: " + elem);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T elem = front.getElement();
        front = front.getNext();
        size--;

        return elem;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        } else {
            return front.getElement();
        }
    }

    public void print() {
        LinearNode<T> current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
