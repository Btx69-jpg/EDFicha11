package Parte1.Ex2;

public class PriorityQueueNode <T> implements Comparable<PriorityQueueNode<T>>{

    private static int nextorder = 0;
    private int priority;
    private int order;
    private T element;

    /**
     * Creates a new PriorityQueueNode with the specified data.
     *
     * @param obj the element of the new priority queue node
     * @param prio the integer priority of the new queue node
     */
    public PriorityQueueNode (T obj, int prio) {
        element = obj;
        priority = prio;
        order = nextorder;
        nextorder++;
    }

    /**
     * Returns the element in this node.
     *
     * @return the element contained within this node
     */

    public T getElement() {
        return element;
    }

    /**
     * Returns the priority value for this node.
     *
     * @return the integer priority for this node
     */

    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Returns the order for this node.
     *
     * @return the integer order for this node
     */
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Returns a string representation for this node.
     *
     */
    @Override
    public String toString() {
        String temp = ("element:" + element.toString()+ " priority: " + priority + " order: " + order);
        return temp;
    }
    @Override
    public int compareTo(PriorityQueueNode obj) {
        int result;
        PriorityQueueNode<T> temp = obj;
        if (priority > temp.getPriority()) {
            result = 1;
        }
        else if (priority < temp.getPriority()) {
            result = -1;
        }
        else if (order > temp.getOrder()) {
            result = 1;
        }
        else {
            result = -1;
        }
        return result;
    }

}
