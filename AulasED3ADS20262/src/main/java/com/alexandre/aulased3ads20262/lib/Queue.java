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
public class Queue<T> {
    private ArrayList<T> data; // lista privada

    public Queue() {
        this.data = new ArrayList<T>();
    }
    
    //método para inserção de dados na fila
    public void enqueue(T val){
        this.data.add(val);
    }
    
    //método para remoção de dados na fila
    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        return this.data.remove(0);
    }
    
    //método para verificar se a fila está vazia ou não
    public boolean isEmpty(){
        return this.data.isEmpty();
    }
    
    //método para consultar o início da fila sem remover o elemento
    public T peek(){
        if(isEmpty()){
            return null;
        }
        return this.data.get(0);
    }
    
    //método que imprimi a fila (para efeitos de depuração)
    public String print(){
        StringBuilder output = new StringBuilder("[ ");
        for (int i = 0; i < this.data.size(); i++){
            if(output.length() > 2){
                output.append(", ");
            }
            output.append("(")
                  .append(i+1)
                  .append("º): ")
                  .append(this.data.get(i));
        }
        output.append(" ]");
        return output.toString();
    }
}