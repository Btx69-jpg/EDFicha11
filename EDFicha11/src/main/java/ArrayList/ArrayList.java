package ArrayList;
import Exceptions.ConcorrentModificationException;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.ListADT;

import java.util.Iterator;

public abstract class ArrayList<T> implements ListADT<T> {
    /**
     *  position of the first element in the list
     * */
    protected int first;

    /**
     * position of the last element in the list
     * */
    protected int last;

    /**
     * The list
     * */
    protected T[] list;

    /**
     * The list counter
     * */
    protected int count;

    /**
     * The modifications counter.
     * */
    protected int modCount;

    public ArrayList(){
        first = last = 0;
        list = (T[]) new Object[10];
    }

    /**
     * Remove the first element of the list
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        T removed;
        if (this.list[first] == null){
            throw new EmptyCollectionException("A lista esta vazia");
        }

        removed = this.list[first];

        removeNulls();

        /*
        for(int i = 0; i < count - 1; i++){
            list[i] = list[i + 1];
        }

         */

        this.count--;
        this.modCount++;
        this.last--;
        return removed;
    }

    /**
     * Remove the last element of the list
     */
    @Override
    public T removeLast() {
        T removed;
        if (this.list[last] == null){
            throw new EmptyCollectionException("A lista esta vazia");
        }

        removed = this.list[last];
        this.list[last] = null;
        count--;
        this.modCount++;
        this.last--;
        return removed;
    }

    /**
     * Remove a determined element of the list
     *
     * @param element element to remove
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        boolean found = false;
        T removed = null;
        if (this.count == 0){
            throw new EmptyCollectionException("A lista esta vazia");
        }

        for (int i = 0; i < this.count; i++){
            if (list[i].equals(element)){
                removed = this.list[i];
                this.list[i] = null;
                removeNulls();
                found = true;
                break;
            }
        }

        if (!found){
            throw new ElementNotFoundException("O elemento não pertence a lista.");
        }
        this.count--;
        this.modCount++;
        this.last--;
        return removed;
    }

    /**
     * @return the first object of the list
     */
    @Override
    public T first() {
        return this.list[first];
    }

    /**
     * @return the last object of the list
     */
    @Override
    public T last() {
        return this.list[last];
    }

    /**
     * Returns true if this list contains the specified target
     * element.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    @Override
    public boolean contains(T target) throws EmptyCollectionException {


        if (this.count == 0){
            throw new EmptyCollectionException("A lista esta vazia");
        }

        for (int i = 0; i < this.count; i++){
            if (list[i].equals(target)){
                return true;
            }
        }

        return false;
    }

    /**
     * @return true if is empty and false if it isn't
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * @return the size of the list
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Implementação do método iterator, que retorna uma instância de MyIterator.
     * @return Iterator<T> para percorrer a lista.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /**
     * Classe interna MyIterator que implementa o iterador para ArrayList.
     */
    private class MyIterator implements Iterator<T> {

        /**
         *
         * */
        private int currentPosition; // Posição atual do iterador

        /**
         *Boolean variable
         * */
        //verificar necessidade
        private boolean hasNext = false;

        private int expectedModCount = 0;

        private MyIterator(){
            currentPosition = 0;
            expectedModCount = modCount;


        }
        @Override
        public boolean hasNext() {
            // Verifica se ainda há elementos na lista
            return currentPosition < count && list[currentPosition] != null;
        }

        @Override
        public T next() throws ConcorrentModificationException {
            if (this.expectedModCount != modCount){
                throw new ConcorrentModificationException("A lista foi modificada");
            }
            if (!hasNext()){
                throw new ElementNotFoundException("Não há mais elementos para iterar.");
            }
            // Retorna o próximo elemento da lista e incrementa a posição
            T element = list[currentPosition];
            currentPosition++;
            return element;
        }

        @Override
        public void remove() {
            // Remove o elemento atual
            throw new UnsupportedOperationException("Operação de remoção não suportada.");
        }
    }

    public T getFirst() {
        return this.list[this.first];
    }

    public T getLast() {
        return this.list[this.last];
    }

    public void setLast(int last) {
        this.last = last;
    }

    public T[] getList() {
        return this.list;
    }



    private void removeNulls() {
        int index = 0;
        T[] temp = (T[]) (new Object[list.length]);

        for (int i = 0; i < count; i++){
            if (this.list[i] != null){
                temp[index] = list[i];
                index++;
            }
        }

        this.list = temp;
    }

    protected void openspace(int position, T element) {

        for (int i = this.count; i > position; i--){
            this.list[i] = this.list[i-1];
        }
        this.list[position] = element;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.count; i++){
            sb.append(this.list[i]).append(" ");
        }
        return "Lista [ " + sb.toString() + "]";
    }
}
