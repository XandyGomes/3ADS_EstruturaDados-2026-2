/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexandre.aulased3ads20262.lib;

import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class Stack<T> {
    
    private ArrayList<T> data; // Lista interna privada

    public Stack() {
        this.data = new ArrayList<T>(); // lista vazia
    }
    
    //método para inserção de dados na pilha
    public void push(T val){
        this.data.add(val);
    }
    
    //método para remoção de dados na pilha
    public T pop(){
        if(isEmpty()) return null;
        return this.data.remove(this.data.size() - 1);
    }
    
    //método para informar se a pailha está vazia
    public boolean isEmpty(){
        return this.data.isEmpty();
    }
    
    //método para consultar o topo (última posição) da pilha (sem remover)
    public T peek(){
        if(isEmpty()) return null;
        return this.data.get(this.data.size() - 1);
    }
    
    // método que imprime a pilha para efeitos de depuração
    public String print(){
        return this.data.toString();
    }
}


