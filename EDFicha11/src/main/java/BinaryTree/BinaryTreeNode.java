package BinaryTree;

public class BinaryTreeNode<T> {
    /**
     * Elemento do nó
     */
    protected T element;
    /**
     * Pointer para o nó a esquerda
     */
    protected BinaryTreeNode<T> left;

    /**
     * Pointer para o nó a direita
     */
    protected BinaryTreeNode<T> right;

    public BinaryTreeNode(T obj) {
        this.element = obj;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode() {

    }

    public int numChildren() {
        int children = 0;

        if (this.left != null) {
            children = 1 + left.numChildren();
        }
        if (right != null) {
            children = children + 1 + right.numChildren();
        }

        return children;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

}
