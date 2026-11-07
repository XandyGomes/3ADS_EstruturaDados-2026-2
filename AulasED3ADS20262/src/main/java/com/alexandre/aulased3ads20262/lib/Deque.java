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
public class Deque<T> {

    private ArrayList<T> data;

    public Deque() {
        this.data = new ArrayList<T>();
    }

    //método para inserção no inicio da estrutura
    public void insertFront(T val) {
        this.data.add(0, val);
    }

    //método para inserção no final da estrutura
    public void insertBack(T val) {
        this.data.add(val);
    }

    //método para remoção no início da estrutura
    public T removeFront() {
        if (isEmpty()) {
            return null;
        }
        return this.data.remove(0);
    }

    //método para remoção no final da estrutura
    public T removeBack() {
        if (isEmpty()) {
            return null;
        }
        return this.data.remove(this.data.size() - 1);
    }

    //método para consultar o inicio da estrutura(sem remover)
    public T peekFront() {
        if (isEmpty()) {
            return null;
        }
        return this.data.get(0);
    }

    //método para consultar o inicio da estrutura(sem remover)
    public T peekBack() {
        if (isEmpty()) {
            return null;
        }
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
    
    //método que imprimi a estrutura (para efeitos de depuração)
    public String print() {
        StringBuilder output = new StringBuilder("[ ");
        for (int i = 0; i < this.data.size(); i++) {
            if (output.length() > 2) {
                output.append(", ");
            }
            output.append("(")
                    .append(i)
                    .append("): ")
                    .append(this.data.get(i));
        }
        output.append(" ]");
        return output.toString();
    }
}
