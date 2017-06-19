/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;

/**
 * Implementation for generic type T
 * @author User
 * @param <T>
 */
public class ArrayQueue<T> implements Queue<T> {

    private T[] values;
    private int size;
    private int front;
    private int back;
    
    public ArrayQueue(int s) {
        values = (T[])new Object[s];
        size = 0;
        front = 0;
        back = 0;
    }
    
   @Override
    public void enqueue(T value) {
       if(size < values.length) {
            values[back%values.length] = value;
            back++;
            size++;
        }
        else if(size == values.length){
            T[] newValues = (T[])new Object[3*values.length];
            for(int i = 0, j = front; i < values.length; i++, j++){
                newValues[i] = values[j%values.length];
            }
            values = newValues;
            front = 0;
            back = size;
            values[back%values.length] = value;
            back++;
            size++;
        }
    }

    @Override
    public T dequeue() throws Exception {
        if(size!=0) {
            T result = values[front];
            values[front] = null;
            front = (front+1)%values.length;
            size--;
            return result;
        }
        else{
            throw new Exception("Empty Queue!");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }
    
    
    @Override
    public String toString() {
        System.out.print("Front [ ");
        for(int i = front; i < back; i++) {
            System.out.print(values[i%values.length] + " | ");
        }
        return "] Back";
    }
    
}
