package com.alexandre.ordenacao;

/**
 * Bubble Sort visto em aula (mesma lógica de
 * com.alexandre.aulased3ads20262.BubbleSort), num pacote separado para
 * poder ser importada e reaproveitada em outros trabalhos.
 *
 * @author Alexandre
 */
public class BubbleSort {

    public static <BS extends Comparable<BS>>
            void bubbleSort(BS[] vetor) {
        boolean trocou;
        do {
            trocou = false;

            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i].compareTo(vetor[i + 1]) > 0) {
                    BS temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    trocou = true;
                }
            }
        } while (trocou);
    }
}
