package Parte1.Ex1;

import ArrayBinaryTree.ArrayBinaryTree;
import Exceptions.EmptyCollectionException;
import Interfaces.HeapADT;

import java.util.Arrays;

public class arrayMinHeap<T> extends ArrayBinaryTree<T> implements HeapADT<T> {


    private static final int DEFAULT_CAPACITY = 10;

    public arrayMinHeap() {
        super();
    }

    /**
     * Adds the specified object to this heap.
     *
     * @param obj the element to added to this head
     */
    @Override
    public void addElement(T obj) throws NullPointerException, IllegalArgumentException {
        if (obj == null) {
            throw new NullPointerException("Elemento nulo");
        }
        if (!(obj instanceof Comparable)) {
            throw new IllegalArgumentException("Element must be comparable");
        }
        if (cnt == tree.length) {
            tree = Arrays.copyOf(tree, tree.length * 2);
        }

        tree[cnt] = obj;
        cnt++;
        // Realiza a reorganização somente se houver mais de um elemento
        if (cnt > 1) {
            heapifyAdd();
        }
    }

    /**
     * Reorders this heap to maintain the ordering property after
     * adding a node.
     */
    private void heapifyAdd() {
        T temp;
        int next = cnt - 1; // Índice do último elemento

        temp = tree[next];

        while ((next != 0) && (((Comparable) temp).compareTo(tree[(next - 1) / 2]) < 0)) {
            tree[next] = tree[(next - 1) / 2];
            next = (next - 1) / 2;
        }
        tree[next] = temp;
    }

    /**
     * Removes element with the lowest value from this heap.
     *
     * @return the element with the lowest value from this heap
     */
    @Override
    public T removeMin() throws EmptyCollectionException {
        if (cnt == 0){
            throw new EmptyCollectionException("Heap vazio");
        }
        T min = tree[0];
        tree[0] = tree[cnt - 1];
        heapifyRemove();
        cnt--;
        tree[cnt] = null;
        return min;

    }

    /**
     * Reorders this heap to maintain the ordering property.
     */
    private void heapifyRemove() {
        T temp;
        int node = 0;
        int left = 1;
        int right = 2;
        int next;

        next = getNext(left, right);
        temp = tree[node];

        while ((next < cnt) && (((Comparable)tree[next]).compareTo(temp) < 0)) {

            tree[node] = tree[next];
            node = next;
            left = 2*node+1;
            right = 2*(node+1);
            next = getNext(left, right);

        }
        tree[node] = temp;
    }

    /**
     * Returns the index of the node with the lowest value.
     *
     * @param left the index of the left child
     * @param right the index of the right child
     * @return the index of the node with the lowest value
     */
    private int getNext(int left, int right) {
        int next;
        if ((tree[left] == null) && (tree[right] == null)) {
            next = cnt;
        }
        else if (tree[left] == null) {
            next = right;
        }
        else if (tree[right] == null) {
            next = left;
        }
        else if (((Comparable)tree[left]).compareTo(tree[right]) < 0) {
            next = left;
        }
        else {
            next = right;
        }
        return next;
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
        return tree[0];
    }
    @Override
    public String toString(){
        return Arrays.toString(tree);
    }
}
