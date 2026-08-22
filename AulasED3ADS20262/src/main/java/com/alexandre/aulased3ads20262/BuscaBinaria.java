/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexandre.aulased3ads20262;

/**
 *
 * @author Alexandre
 */
public class BuscaBinaria {

    public static int buscaBinariaInt(Integer[] vetor, Integer valorBusca){
        int ini = 0;
        int fim = vetor.length -1;
        
        while(fim >= ini){
            int meio = (ini + fim) / 2;
           
            
            if(valorBusca == vetor[meio]){
                return meio;
            }else if(valorBusca > vetor[meio]){
                ini = meio + 1;
            }else{
                fim = meio - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Integer[] nums = {0,11,22,33,44,55,66,77,88,99};
        String[] names = {"ADAMASTOR", "ALEXANDRE", "ANA", "CARLOS",
            "DANIEL", "MARIA"};
        
        System.out.println("Posição de 66: " + buscaBinariaInt(nums, 66));
    }



}
