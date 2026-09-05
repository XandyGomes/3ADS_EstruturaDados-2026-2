/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexandre.aulased3ads20262;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class MergeSort {

    public static <MS extends Comparable<MS>> void mergeSort(MS[] vetor) {
        //caso base: se o vetor tem  ou 1 elemento, já esta ordenado
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

    public static void main(String[] args) throws IOException {
        Integer[] nums = {77, 44, 22, 33, 99, 55, 88, 0, 66, 11};

        String[] nomesDesord = {"Maria", "Joao", "Ana", "Carlos", "Beatriz"};

        mergeSort(nums);
        System.out.println(Arrays.toString(nums));

        mergeSort(nomesDesord);
        System.out.println(Arrays.toString(nomesDesord));

        Path caminho = Path.of("data/nomes-desord.txt");

        List<String> lista = Files.readAllLines(caminho);

        String[] nomes = lista.toArray(new String[0]);

        mergeSort(nomes);

        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}
