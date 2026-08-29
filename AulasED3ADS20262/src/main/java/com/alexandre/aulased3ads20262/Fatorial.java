/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexandre.aulased3ads20262;

/**
 *
 * @author Alexandre
 */
public class Fatorial {
    //implementação ITERATIVA
    public static long fatorialIterativo(int n){
        long res = 1;
        for(int i = n; i > 1; i--){
            res *= i; 
        }
        return res;
    }
    
    public static long fatorialRecursivo(int n){
        if(n <= 1) return 1;
        return fatorialRecursivo(n-1);
    }
    
    public static void main(String[] args) {
        System.out.println("Fatorial de 5 ITERATIVO: " + fatorialIterativo(5));
        System.out.println("Fatorial de 5 RECURSIVO: " + fatorialRecursivo(5));
    }
}
