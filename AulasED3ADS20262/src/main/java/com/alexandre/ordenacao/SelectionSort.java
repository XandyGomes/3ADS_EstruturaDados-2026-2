package com.alexandre.ordenacao;

/**
 * Selection Sort visto em aula (mesma lógica de
 * com.alexandre.aulased3ads20262.SelectionSort), num pacote separado para
 * poder ser importada e reaproveitada em outros trabalhos.
 *
 * @author Alexandre
 */
public class SelectionSort {

    public static <SS extends Comparable<SS>> void selectionSort(SS[] vetor) {
        for (int posSel = 0; posSel < vetor.length - 1; posSel++) {

            int posMenor = posSel;

            for (int i = posMenor + 1; i < vetor.length; i++) {
                if (vetor[i].compareTo(vetor[posMenor]) < 0) {
                    posMenor = i;
                }
            }
            if (vetor[posSel].compareTo(vetor[posMenor]) > 0) {
                SS temp = vetor[posSel];
                vetor[posSel] = vetor[posMenor];
                vetor[posMenor] = temp;
            }
        }
    }
}
