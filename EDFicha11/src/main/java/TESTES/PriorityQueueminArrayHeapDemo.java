package TESTES;

import Parte1.Ex2.PriorityQueueMinHeapArray;

public class PriorityQueueminArrayHeapDemo {
    public static void main(String[] args) {
        PriorityQueueMinHeapArray<Integer> pq = new PriorityQueueMinHeapArray<>();

        pq.addElement(1, 1);
        pq.addElement(9, 9);
        pq.addElement(5, 5);
        pq.addElement(7, 7);

        System.out.println(pq);

        System.out.println("minimo: " + pq.findMin());
    }
}
