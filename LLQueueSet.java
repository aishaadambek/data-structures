/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Set;

/**
 *
 * @author User
 * @param <T>
 */
public class LLQueueSet<T> implements Set<T>{
    
    LinkedListQueue<T> set;
    
    public LLQueueSet(){
        set = new LinkedListQueue<>();
    }

    @Override
    public void add(T value) {
        if(!contains(value)){
            set.enqueue(value);
        }
    }

    @Override
    public boolean contains(T value){
        for(int i = 0; i < set.getSize(); i++) {
            try {
                T x = set.dequeue();
                set.enqueue(x);
                if(x.equals(value)) {
                    return true;
                }
            } catch (Exception ex) {
                 System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if(contains(value)){
           for(int i = 0; i < set.getSize(); i++) {
               try{
                   T x = set.dequeue();
                   if(!x.equals(value)){
                       set.enqueue(x);
                   }
               }catch (Exception ex) {
                   System.out.println(ex.getMessage());
               }
           }
           return true;
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if(set.getSize() > 0) {
            return set.dequeue();
        }else {
            throw new Exception("Set is empty!");
        }
    }

    @Override
    public int getSize() {
        return set.getSize();
    }

    @Override
    public void clear() {
        set.clear();
    }
    
    @Override
    public String toString() {
        if (set.getSize() == 0) {
            return "Set is empty";
        }
        return set.toString();
    }
}
