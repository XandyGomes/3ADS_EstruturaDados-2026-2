/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexandre.aulased3ads20262;

import com.alexandre.aulased3ads20262.lib.Stack;

/**
 *
 * @author Alexandre
 */
public class Pilha1 {
    public static void main(String[] args) {
        String frase = "Socorram-me, subi no ônibus em Marrocos";
              
        System.out.println("Frase inicial: " + frase);
        
        Stack<Character> pilha = new Stack<>();
        
        System.out.println("A Pilha está vazia? " + (pilha.isEmpty() ? "Sim" : "Não"));
        
        System.out.println("Pilha inicial: " + pilha.print());
       
        
        for(int i = 0; i < frase.length(); i++){
            pilha.push(frase.charAt(i));
        }
        System.out.println("A Pilha está vazia? " + (pilha.isEmpty() ? "Sim" : "Não"));
        System.out.println("Pilha atual: " + pilha.print());
        
        String reverso = "";
        
        System.out.println("Qual é o último elemento da nossa pilha: " + pilha.peek());
        
        while(!pilha.isEmpty()){
            reverso += pilha.pop();
        }
        
        System.out.println("Pilha depois do reverso: "+ reverso);
        
    }
}
