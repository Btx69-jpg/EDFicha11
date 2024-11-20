package LinkedList;

public class LinearNode<T> {
    private T element;         // Dado armazenado no nó
    private LinearNode<T> next; // Referência para o próximo nó

    // Construtor padrão que inicializa um nó vazio
    public LinearNode() {
        this.element = null;
        this.next = null;
    }

    // Construtor que inicializa o nó com um elemento
    public LinearNode(T elem) {
        this.element = elem;
        this.next = null;
    }

    // Retorna o elemento armazenado no nó
    public T getElement() {
        return element;
    }

    // Define o elemento do nó
    public void setElement(T elem) {
        this.element = elem;
    }

    // Retorna o próximo nó
    public LinearNode<T> getNext() {
        return next;
    }

    // Define o próximo nó
    public void setNext(LinearNode<T> nextNode) {
        this.next = nextNode;
    }


}