package Parte1.Ex3;

import BinaryTree.LinkedBinaryTree;
import Interfaces.HeapADT;
import Parte1.heapNode;

public class LinkedMinHeap<T> extends LinkedBinaryTree<T> implements HeapADT<T> {
    private int cnt;
    private heapNode<T> lastAdded;

    public LinkedMinHeap() {
        super();
        this.root = null;
        this.lastAdded = null;
        cnt = 0;
    }

    /**
     * Adds the specified element to this heap in the
     * appropriate position according to its key value
     * Note that equal elements are added to the right.
     * @param obj the element to be added to this head
     */
    @Override
    public void addElement(T obj) throws NullPointerException, IllegalArgumentException {
        if (obj == null){
            throw new NullPointerException("Elemento nulo");
        }else if (!(obj instanceof Comparable)){
            throw new IllegalArgumentException("Element must be comparable");
        }

        heapNode<T> node = new heapNode<T>(obj);
        if (root == null)
            root=node;
        else {
            heapNode<T> next_parent = getNextParentAdd();
            if (next_parent.getLeft() == null) {
                next_parent.setLeft(node);
            }
            else {
                next_parent.setRight(node);
            }

            node.setParent(next_parent);
        }
        lastAdded = node;
        cnt++;
        if (cnt>1)
            heapifyAdd();



    }

    /**
     * Returns the node that will be the parent of the new node
     *
     * @return the node that will be a parent of the new node
     */
    private heapNode<T> getNextParentAdd() {
        heapNode<T> result = lastAdded;
        while ((result != root) && (result.getParent().getLeft() != result))
            result = result.getParent();
        if (result != root) {
            if (result.getParent().getRight() == null)
                result = result.getParent();
            else {
                result = (heapNode<T>) result.getParent().getRight();
                while (result.getLeft() != null)
                    result = (heapNode<T>) result.getLeft();
            }
        }
        else {
            while (result.getLeft() != null) {
                result = (heapNode<T>) result.getLeft();
            }
        }

        return result;
    }

    /**
     * Reorders this heap after adding a node.
     */
    private void heapifyAdd() {
        T temp;
        heapNode<T> next = lastAdded;

        temp = next.getElement();

        while ((next != root) && (((Comparable)temp).compareTo(next.getParent().getElement()) < 0))
        {
            next.setElement(next.getParent().getElement());
            next = next.getParent();
        }
        next.setElement(temp);
    }

    /**
     * Removes element with the lowest value from this heap.
     *
     * @return the element with the lowest value from this heap
     */
    @Override
    public T removeMin() {
        return null;
    }

    /**
     * Returns a reference to the element with the lowest value in
     * this heap.
     *
     * @return a reference to the element with the lowest value
     * in this heap
     */
    @Override
    public T findMin() {
        return null;
    }
}
