package ArrayBinaryTree;

import ArrayList.ArrayUnnorderedList;
import Interfaces.BinaryTreeADT;

import java.util.Iterator;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {
    protected int cnt;
    protected T[] tree;

    public ArrayBinaryTree() {
        cnt = 0;
        tree = (T[]) new Object[10]; // Inicializa a lista
    }

    public ArrayBinaryTree(T rootElement) {
        cnt = 1;
        tree = (T[]) new Object[10];
        tree[0] = rootElement;
    }

    @Override
    public T getRoot() {
        return tree[0];
    }

    @Override
    public boolean isEmpty() {
        return cnt == 0;
    }

    @Override
    public int size() {
        return cnt;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i <= cnt - 1; i++) {
            if (tree[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T find(T element) {
        for (int i = 0; i <= cnt - 1; i++) {
            if (tree[i].equals(element)) {
                return tree[i];
            }
        }
        return null; // ou lançar uma ElementNotFoundException
    }

    private void inOrderTraversal(int index, ArrayUnnorderedList<T> list) {
        if (index <= cnt - 1 && tree[index] != null) {
            inOrderTraversal(2 * index + 1, list); // Filho esquerdo
            list.addToRear(tree[index]); // Raiz
            inOrderTraversal(2 * index + 2, list); // Filho direito
        }
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnnorderedList<T> tempList = new ArrayUnnorderedList<T>();
        inOrderTraversal(0, tempList);
        return tempList.iterator();
    }

    private void preOrderTraversal(int index, ArrayUnnorderedList<T> list) {
        if (index <= cnt - 1 && tree[index] != null) {
            list.addToRear(tree[index]); // Raiz
            preOrderTraversal(2 * index + 1, list); // Filho esquerdo
            preOrderTraversal(2 * index + 2, list); // Filho direito
        }
    }
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnnorderedList<T> tempList = new ArrayUnnorderedList<T>();
        preOrderTraversal(0, tempList);
        return tempList.iterator();
    }

    private void postOrderTraversal(int index, ArrayUnnorderedList<T> list) {
        if (index <= cnt - 1 && tree[index] != null) {
            postOrderTraversal(2 * index + 1, list); // Filho esquerdo
            postOrderTraversal(2 * index + 2, list); // Filho direito
            list.addToRear(tree[index]); // Raiz
        }
    }
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnnorderedList<T> tempList = new ArrayUnnorderedList<T>();
        postOrderTraversal(0, tempList);
        return tempList.iterator();
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnnorderedList<T> tempList = new ArrayUnnorderedList<T>();
        for (int i = 0; i <= cnt - 1; i++) {
            if (tree[i] != null) {
                tempList.addToRear(tree[i]);
            }
        }
        return tempList.iterator();
    }
}
