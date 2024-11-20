package BinaryTree;

import Exceptions.ElementNotFoundException;
import Interfaces.BinaryTreeADT;
import LinkedList.LinearLinkedUnnorderedList;
import Queue.LinkedQueue;

import java.util.Iterator;

public abstract class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
    /***
     * Size of the tree
     */
    protected int size;

    /**
     * The start point of the tree (the onlyone that we have acess)
     */
    protected BinaryTreeNode<T> root;


    public LinkedBinaryTree() {

    }

    public LinkedBinaryTree(T element) {

        root = new BinaryTreeNode<>();
        this.root.setElement(element);

    }


    @Override
    public T getRoot() {
        return this.root.getElement();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(T element) {
        try {
            find(element);
        }catch (ElementNotFoundException _){
            return false;
        }
        return true;
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree. Throws a NoSuchElementException if
     * the specified target element is not found in the binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @return a reference to the specified target
     * @throws ElementNotFoundException if an element not found
     *                                  exception occurs
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findAgain(targetElement, root);

        if (current == null) {

            throw new ElementNotFoundException("Elemento não encontrado");
        }

        return current.element;
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @param next          the element to begin searching from
     */

    public BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {

        if (next == null) {
            return null;
        }

        if (next.element.equals(targetElement)) {
            return next;
        }

        BinaryTreeNode<T> temp = findAgain(targetElement, next.left);

        if (temp == null) {
            temp = findAgain(targetElement, next.right);
        }

        return temp;
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with
     * the root.
     *
     * @return an in order iterator over this binary tree
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        LinearLinkedUnnorderedList<T> tempList = new LinearLinkedUnnorderedList<T>();
        inOrder(root, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node     the node to be used as the root
     *                 for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inOrder(BinaryTreeNode<T> node, LinearLinkedUnnorderedList<T> tempList) {
        if (node != null) {
            inOrder(node.left, tempList);
            tempList.addToRear(node.element);
            inOrder(node.right, tempList);
        }
    }


    @Override
    public Iterator<T> iteratorPreOrder() {
        LinearLinkedUnnorderedList<T> tempList = new LinearLinkedUnnorderedList<>();

        preOrder(root, tempList);
        return tempList.iterator();
    }

    protected void preOrder(BinaryTreeNode<T> node, LinearLinkedUnnorderedList<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.element);

            preOrder(node.left, tempList);

            preOrder(node.right, tempList);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        LinearLinkedUnnorderedList<T> tempList = new LinearLinkedUnnorderedList<>();

        postOrder(root, tempList);
        return tempList.iterator();
    }

    protected void postOrder(BinaryTreeNode<T> node, LinearLinkedUnnorderedList<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.element);

            preOrder(node.left, tempList);

            preOrder(node.right, tempList);

            tempList.addToRear(node.element);

        }
    }


    @Override
    public Iterator<T> iteratorLevelOrder() {
        LinkedQueue<BinaryTreeNode<T>> nodes = new LinkedQueue<>();
        LinearLinkedUnnorderedList<T> tempList = new LinearLinkedUnnorderedList<>();

        if (root != null) {
            nodes.enqueue(root);
        }

        while (!nodes.isEmpty()) {
            BinaryTreeNode<T> currentNode = nodes.dequeue();
            tempList.addToRear(currentNode.element);

            // Adiciona os filhos do nó atual na fila
            if (currentNode.left != null) {
                nodes.enqueue(currentNode.left);
            }
            if (currentNode.right != null) {
                nodes.enqueue(currentNode.right);
            }
        }

        return tempList.iterator();
    }

}
