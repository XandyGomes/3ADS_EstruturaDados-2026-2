/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexandre.aulased3ads20262;

import com.alexandre.aulased3ads20262.lib.Queue;

/**
 *
 * @author Alexandre
 */
public class Fila {

    public static void main(String[] args) {
        Queue<String> fila = new Queue();
        System.out.println(fila.print());

        fila.enqueue("Alexandre");
        fila.enqueue("José");
        fila.enqueue("João");
        fila.enqueue("Maria");
        System.out.println(fila.print());

        String proximo = fila.peek();
        System.out.println("Próximo da fila: " + proximo);

        String atendimento = fila.dequeue();
        System.out.println("Chamar para atendimento: " + atendimento);

        proximo = fila.peek();
        System.out.println("Próximo da fila: " + proximo);

        System.out.println(fila.print());

    }

}
