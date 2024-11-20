package Parte1.Ex2;

import Parte1.Ex1.arrayMinHeap;

import java.util.Arrays;

public class PriorityQueueMinHeapArray<T> extends arrayMinHeap<PriorityQueueNode<T>> {

    /**
     * Creates an empty priority queue.
     */
    public PriorityQueueMinHeapArray() {
        super();
    }

    /**
     * Adds the given element to this PriorityQueue.
     *
     * @param object the element to be added to the priority queue
     * @param priority the integer priority of the element to be added
     */
    public void addElement (T object, int priority) {
        PriorityQueueNode<T> node = new PriorityQueueNode<T> (object, priority);
        super.addElement(node);
    }
    /**
     * Removes the next highest priority element from this priority
     * queue and returns a reference to it.
     *
     * @return a reference to the next highest priority element
     * in this queue
     */
    public T removeNext() {
        PriorityQueueNode<T> temp = (PriorityQueueNode<T>)super.removeMin();
        return temp.getElement();
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "tree=" + Arrays.toString(tree) +
                '}';
    }
}

