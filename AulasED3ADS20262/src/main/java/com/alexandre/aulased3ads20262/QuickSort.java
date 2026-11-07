/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexandre.aulased3ads20262;

import java.util.Arrays;

/**
 *
 * @author Alexandre
 */
public class QuickSort {

    //método público que facilita a chamada: o usuário só passa o vetor
    public static void quickSort(Comparable[] vetor) {
        //inicia a recursão passando o primeiro(0) e o último indice
        quickSort(vetor, 0, vetor.length - 1);
    }

    //metódo privado recursivo que define os limites atuais
    private static void quickSort(Comparable[] vetor, int inicio, int fim) {
        //caso base: se o início for menor que o fim, ainda há elementos para ordenar
        if (inicio < fim) {
            //reorganiza o vetor e encontra a posição correta do pivo
            int pivo = particionar(vetor, inicio, fim);

            //ordena a sub-lista à esquerda do pivô(menores)
            quickSort(vetor, inicio, pivo - 1);
            //ordena a sub-lista à direita do pivô(maiores)
            quickSort(vetor, pivo + 1, fim);
        }
    }

    //método privado que organiza os elementos em torno do pivô
    private static int particionar(Comparable[] vetor, int inicio, int fim) {
        //ecolha o último elemento como pivô (padrão)
        Comparable pivo = vetor[fim];
        //"i" rastreia a posição do último elemento menor que o pivô encontrado
        int i = inicio - 1;

        //"j" percorre o vetor do início até o penúltimo elemento
        for (int j = inicio; j < fim; j++) {
            //compara o elemento atual "i" com o pivô
            //comparaTo < 0 significa que o vetor[j] é menor que o pivô
            if (vetor[j].compareTo(pivo) < 0) {
                i++; //avançaa o índice do "limite dos menores"
                trocar(vetor, i, j); // joga o elemento menor para esquerda
            }
        }
        trocar(vetor, i + 1, fim);

        return i + 1;
    }

    private static void trocar(Comparable[] vetor, int i, int j) {
        Comparable temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] nums = {77, 44, 22, 33, 99, 55, 0, 66, 11};
        String[] nomesDesord = {"Maria", "João", "Ana",
            "Carlos", "Beatriz"};

        quickSort(nums);
        System.out.println("Números ordenados: " + Arrays.toString(nums));

        quickSort(nomesDesord);
        System.out.println("Nomes ordenados: " + Arrays.toString(nomesDesord));
    }

}
