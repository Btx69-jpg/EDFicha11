package TESTES;

import Parte1.Ex1.arrayMinHeap;

public class arrayMinHeapDemo {
    public static void main(String[] args) {
        arrayMinHeap<Integer> h = new arrayMinHeap<>();
        h.addElement(5);
        h.addElement(3);
        h.addElement(7);
        h.addElement(1);
        h.addElement(9);

        System.out.println(h);

        System.out.println("minimo: " + h.findMin());

        System.out.println("removido minimo: " + h.removeMin());

        System.out.println("novo minimo: " + h.findMin());

        System.out.println("tamanho: " + h.size());

        System.out.println("esta vazio: " + h.isEmpty());

        System.out.println("contem 5: " + h.contains(5));

        System.out.println("contem 4: " + h.contains(4));

        System.out.println(h);
    }
}
