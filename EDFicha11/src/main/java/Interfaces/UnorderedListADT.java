package Interfaces;

public interface UnorderedListADT<T> extends ListADT<T> {
    /**
     * Adiciona um elemento no inicio da lista
     *
     * @param element elemento a adicionar
     */
    public void addToFront(T element);

    /**
     * Adiciona um elemento no fundo da lista
     *
     * @param element elemento a adicionar
     */
    public void addToRear(T element);

    /**
     * Adiciona um elemento após um elemento ja existente na lista
     *
     * @param element elemento a adicionar
     * @param target  elemento alvo que se deseja inserir o element após
     */
    public void addAfter(T element, T target);
}
