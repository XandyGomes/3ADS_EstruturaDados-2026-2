package com.alexandre.ordenacao;

import java.util.Arrays;

/**
 * Merge Sort visto em aula (mesma lógica de
 * com.alexandre.aulased3ads20262.MergeSort), num pacote separado para
 * poder ser importada e reaproveitada em outros trabalhos. Mais eficiente
 * que Bubble/Selection Sort para vetores maiores (O(n log n) contra O(n²)).
 *
 * @author Alexandre
 */
public class MergeSort {

    public static <MS extends Comparable<MS>> void mergeSort(MS[] vetor) {
        //caso base: se o vetor tem 0 ou 1 elemento, já esta ordenado
        if (vetor.length < 2) {
            return;
        }

        int meio = vetor.length / 2;

        MS[] vetEsq = Arrays.copyOfRange(vetor, 0, meio);
        MS[] vetDir = Arrays.copyOfRange(vetor, meio, vetor.length);

        //chamadas recursivas
        mergeSort(vetEsq);
        mergeSort(vetDir);

        //mesclagem (Merge)
        int posEsq = 0, posDir = 0, posRes = 0;

        while (posEsq < vetEsq.length && posDir < vetDir.length) {
            if (vetEsq[posEsq].compareTo(vetDir[posDir]) < 0) {
                vetor[posRes] = vetEsq[posEsq];
                posEsq++;
            } else {
                vetor[posRes] = vetDir[posDir];
                posDir++;
            }
            posRes++;
        }

        //se sobrou no vetor da ESQUERDA, copia para o final
        while (posEsq < vetEsq.length) {
            vetor[posRes] = vetEsq[posEsq];
            posEsq++;
            posRes++;
        }

        //se sobrou no vetor da DIREITA, copia para o final
        while (posDir < vetDir.length) {
            vetor[posRes] = vetDir[posDir];
            posDir++;
            posRes++;
        }
    }
}
