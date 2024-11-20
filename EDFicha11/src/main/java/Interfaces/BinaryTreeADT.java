package Interfaces;

import java.util.Iterator;

public interface BinaryTreeADT<T> {

    T getRoot();

    @Override
    String toString();

    boolean isEmpty();

    int size();

    boolean contains(T element);

    T find(T element);

    Iterator<T> iteratorInOrder();

    Iterator<T> iteratorPreOrder();

    Iterator<T> iteratorPostOrder();

    Iterator<T> iteratorLevelOrder();


}
