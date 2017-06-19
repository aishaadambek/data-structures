/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Deque;


/**
 *
 * @author User
 */
public class LinkedListDeque<T> implements Deque<T> {

    private int size;
    private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;
    
    public LinkedListDeque(){
        size = 0;
        front = null;
        back = null;
    }
    
    @Override
    public void pushToFront(T value) {
        DoublyLinkedNode<T> n = new DoublyLinkedNode(value);
        if(size == 0) {
            front = n;
            back = n;
        }else {
            n.setNext(front);
            front.setPrevious(n);
            front = n;
        }
        size++;
    }

    @Override
    public void pushToBack(T value) {
        DoublyLinkedNode<T> n = new DoublyLinkedNode(value);
        if(size == 0) {
            front = n;
            back = n;
        } else {
            n.setPrevious(back);
            back.setNext(n);
            back = n;
        }
        size++;
    }

    @Override
    public T popFromFront() throws Exception {
        T result;
        if(size == 0) {
            throw new Exception("Empty Deque!");
        }else if(size ==1){
           result = front.getValue();
           back = null;
           front = null;
        }
        else{
            result = front.getValue();
            front = front.getNext();
            front.setPrevious(null);
        }
        size--;
        return result;
    }

    @Override
    public T popFromBack() throws Exception {
        T result;
        if(size == 0) {
            throw new Exception("Empty Deque!");
        }else if(size == 1) {
            result = back.getValue();
            back = null;
            front = null;
        }else {
            result = back.getValue();
            back = back.getPrevious();
            back.setNext(null);
        }
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
   public String toString() {
       String res = "Front [";
       DoublyLinkedNode<T> a = front;
       while(a != null) {
           res += " " + a.getValue() + " |";
           a = a.getNext();
       }
       return res + " ] Back";
   }
    
}
