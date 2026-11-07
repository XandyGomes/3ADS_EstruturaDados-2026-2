/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexandre.aulased3ads20262;

import com.alexandre.aulased3ads20262.lib.LinkedList;

/**
 *
 * @author Alexandre
 */
public class ListaEncadeada {

    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList();

        lista.insert(0, "Fusca");
        lista.insert(0, "Corcel");

        lista.insert(2, "Opala");
        lista.insert(3, "Chevette");
        lista.insert(4, "Maverick");

        System.out.println(lista.print());
        lista.insert(3, "Brasília");
        System.out.println(lista.print());

        lista.insertHead("Belina");
        lista.insertTail("Del Rey");
        System.out.println(lista.print());

        String removido = lista.remove(0);
        System.out.println("Removido 0:" + removido);
        System.out.println(lista.print());

        removido = lista.remove(4);
        System.out.println("Removido 4:" + removido);
        System.out.println(lista.print());

        int idxFusca = lista.indexOf("Fusca");
        int idxOpala = lista.indexOf("Opala");
        int idxChevette = lista.indexOf("Chevette");

        System.out.println("Índices: Fusca = " + idxFusca + ", Opala = " + idxOpala + ", Chevette = " + idxChevette);

        String pos0 = lista.peek(0);
        String pos3 = lista.peek(3);
        String pos20 = lista.peek(20);

        System.out.println("Peek: pos0 = " + pos0 + ", pos3 = " + pos3 + ", pos20 = " + pos20);
    }
}

