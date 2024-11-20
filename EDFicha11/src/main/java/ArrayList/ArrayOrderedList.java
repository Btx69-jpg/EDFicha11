package ArrayList;

import Interfaces.OrderedListADT;

import java.util.Arrays;

public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {

    /**
     * Método para adicionar um elemento à lista ordenada.
     * O elemento deve implementar a interface Comparable para poder comparar e ordenar.
     *
     * @param element elemento a ser adicionado
     */
    @Override
    public void add(T element) throws  NullPointerException, IllegalArgumentException{

        if (element == null){
            throw new NullPointerException("Element cannot be null");
        }

        if (!(element instanceof Comparable)) {
            throw new IllegalArgumentException("Element must be comparable");
        }

        Comparable<T> comparableElement = (Comparable<T>) element;

        // Expande a capacidade da lista se estiver cheia
        if (this.size() != 0  && this.size() == this.list.length) {
            this.list = Arrays.copyOf(this.list, this.list.length * 2);
        }

        // Encontra a posição correta para inserir o elemento
        int insertPosition = 0;
        while (insertPosition < this.size() && comparableElement.compareTo(this.list[insertPosition]) > 0) {
            insertPosition++;
        }

        // Move os elementos para a direita para abrir espaço para o novo elemento
        for (int i = this.size(); i > insertPosition; i--) {
            this.list[i] = this.list[i - 1];
        }

        // Insere o novo elemento na posição correta
        this.list[insertPosition] = element;

        // Atualiza o contador de elementos, o contador do ultimo elemento e o modCount (para controle de modificações)
        if (this.count != 0){
            this.last++;
        }
        this.count++;
        this.modCount++;

    }

}
