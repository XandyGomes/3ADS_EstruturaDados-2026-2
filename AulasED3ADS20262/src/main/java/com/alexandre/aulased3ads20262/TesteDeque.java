/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexandre.aulased3ads20262;

import com.alexandre.aulased3ads20262.lib.Deque;

/**
 *
 * @author Alexandre
 */
public class TesteDeque {
    public static void main(String[] args) {
        Deque<String> listaCompras = new Deque();
        System.out.println(listaCompras.print());
        
        //Alimentícios = início
        listaCompras.insertFront("Arroz");
        listaCompras.insertFront("Feijão");
        listaCompras.insertFront("Macarrão");
        System.out.println(listaCompras.print());
                
        //Higiene/Limpeza = final
        listaCompras.insertBack("Sabão em pó");
        listaCompras.insertBack("Desodorante");
        listaCompras.insertBack("Água sanitária");
        System.out.println(listaCompras.print());
        
        listaCompras.insertFront("Café");
        listaCompras.insertBack("Amaciante");
        System.out.println(listaCompras.print());
        
        listaCompras.insertFront("Açúcar");
        System.out.println(listaCompras.print());
        
        String removido = listaCompras.removeFront();
        System.out.println("Removido: " + removido);
        
        System.out.println(listaCompras.print());
        
        removido = listaCompras.removeBack();
        System.out.println(listaCompras.print());
        
        String primeiro = listaCompras.peekFront();
        String ultimo = listaCompras.peekBack();
        
        System.out.println("Primeiro da lista: " + primeiro);
        System.out.println("Último da lista: " + ultimo);
    }
}
