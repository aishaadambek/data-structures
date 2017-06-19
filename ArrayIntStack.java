/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;
import csci152.adt.IntStack;

/**
 *
 * @author User
 */
public class ArrayIntStack implements IntStack{
    
    private int[] values;
    private int size;
    private int[] newValues;
    
    public ArrayIntStack(int a) {
        values = new int[a];
        size = 0;
        newValues = new int[3*values.length];
    }
    
    @Override
    public void push(int num) {
        if(size < values.length ) {
            values[size] = num;
            size++;
        }
        else if(size == values.length) {
            for(int i = 0; i < values.length; i++) {
                newValues[i] = values[i];
            }
            values = newValues;
            values[size] = num;
            size++;
        }
        else {
            values[size] = num;
            size++;
        }
        
    }
    
    @Override
    public int pop() throws Exception {
        if(size > 0) {
            int result = values[size - 1];
            size--;
            return result;
        }
        else {
            throw new Exception("Empty Stack!");
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
        System.out.print("BOTTOM [[ ");
        for(int i = 0; i < size; i++) {
            System.out.print(values[i] + " | ");
        }
        return "]] TOP";
    }
   
    
}
