package BinaryTree;

import Exceptions.ElementNotFoundException;
import Interfaces.BinarySearchTreeADT;

public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

    public LinkedBinarySearchTree() {
        super();
    }

    public LinkedBinarySearchTree(T element) {
        super(element);
    }

    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its key value. Note that
     * equal elements are added to the right.
     *
     * @param element the element to be added to the binary search
     * tree
     */
    @Override
    public void addElement(T element) throws NullPointerException, IllegalArgumentException {
        if (element == null) {
            throw new NullPointerException("Elemento nulo");
        }
        if (!(element instanceof Comparable)) {
            throw new IllegalArgumentException("Element must be comparable");
        }
        BinaryTreeNode<T> temp = new BinaryTreeNode<>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;

        if (this.isEmpty()) {
            this.root = temp;
        } else {
            BinaryTreeNode<T> current = this.root;
            boolean added = false;

            while (!added) {
                if (comparableElement.compareTo(current.element) < 0) {
                    /*Se o elemento a adicionar for menor que o current e o current não tiver ninguem há esquerda
                    adiciona, se não atualiza o current para o porximo há esquerda
                    */
                    if (current.left == null) {
                        current.left = temp;
                        added = true;
                    } else {
                        current = current.left;
                    }
                } else {
                    /*Se o elemento a adicionar for maior que o current e o current não tiver ninguem há direita
                    adiciona, se não atualiza o current para o porximo há direita
                     */
                    if (current.right == null) {
                        current.right = temp;
                        added = true;
                    } else {
                        current = current.right;
                    }
                }
            }
        }

        size++;
        //Posso ter de meter algo para o iterator
    }

    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it. Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary
     * search tree
     * @throws ElementNotFoundException if an element not found
     * exception occurs
     */
    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;
        if (!isEmpty())
        {
            if (((Comparable)targetElement).equals(root.element)) {
                result = root.element;
                root = replacement (root);
                size--;
            }
            else {
                BinaryTreeNode<T> current, parent = root;
                boolean found = false;
                if (((Comparable)targetElement).compareTo(root.element) < 0) {
                    current = root.left;
                }
                else {
                    current = root.right;
                }
                while (current != null && !found) {

                    if (targetElement.equals(current.element)) {

                        found = true;
                        size--;
                        result = current.element;
                        if (current == parent.left) {
                            parent.left = replacement (current);
                        }
                        else {
                            parent.right = replacement (current);
                        }
                    }
                    else {
                        parent = current;
                        if (((Comparable)targetElement).compareTo(current.element) < 0)
                            current = current.left;
                        else
                            current = current.right;
                    }
                } //while
                if (!found)
                    throw new ElementNotFoundException("binary search tree");
            }
        } // end outer if
        return result;

    }

    /**
     * Returns a reference to a node that will replace the one
     * specified for removal. In the case where the removed node has
     * two children, the inorder successor is used as its replacement.
     *
     * @param node the node to be removeed
     * @return a reference to the replacing node
     */
    protected BinaryTreeNode<T> replacement (BinaryTreeNode<T> node) {

        BinaryTreeNode<T> result = null;
        if ((node.left == null)&&(node.right==null)) {
            result = null;
        }
        else if ((node.left != null)&&(node.right==null)) {
            result = node.left;
        }
        else if ((node.left == null)&&(node.right != null)) {
            result = node.right;
        }
        else {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;
            while (current.left != null) {
                parent = current;
                current = current.left;
            }

            if (node.right == current)
                current.left = node.left;
            else
            {
                parent.left = current.right;
                current.right = node.right;
                current.left = node.left;
            }
            result = current;
        }
        return result;
    }

    /**
     * Removes all occurences of the specified element from this tree.
     *
     * @param targetElement the element that the list will
     *                      have all instances of it removed
     */
    @Override
    public void removeAllOcurrences(T targetElement) {

        while (contains(targetElement)){
            removeElement(targetElement);
        }

    }

    /**
     * Removes and returns the smallest element from this tree.
     *
     * @return the smallest element from this tree.
     */
    @Override
    public T removeMin() {
        return removeElement(findMin());
    }

    /**
     * Removes and returns the largest element from this tree.
     *
     * @return the largest element from this tree
     */
    @Override
    public T removeMax() {
        return removeElement(findMax());
    }

    /**
     * Returns a reference to the smallest element in this tree.
     *
     * @return a reference to the smallest element in this tree
     */
    @Override
    public T findMin() {
        BinaryTreeNode<T> current = this.root;

        while (current.left != null){
            current = current.left;
        }

        return current.getElement();
    }

    /**
     * Returns a reference to the largest element in this tree.
     *
     * @return a reference to the largest element in this tree
     */
    @Override
    public T findMax() {
        BinaryTreeNode<T> current = this.root;

        while (current.right != null){
            current = current.right;
        }

        return current.getElement();    }
}
