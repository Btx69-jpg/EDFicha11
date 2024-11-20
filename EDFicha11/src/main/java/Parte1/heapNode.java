package Parte1;

import BinaryTree.BinaryTreeNode;

public class heapNode<T> extends BinaryTreeNode<T> {
    protected heapNode<T> parent;

    public heapNode (T obj){
        super(obj);
        parent = null;
    }

    public heapNode<T> getParent() {
        return parent;
    }

    public void setParent(heapNode<T> parent) {
        this.parent = parent;
    }
}
