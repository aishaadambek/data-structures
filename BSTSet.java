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
public class BSTSet<T extends Comparable> implements Set<T> {

    private TreeNode<T> root;
    private int size;
    
    public BSTSet() {
        root = null;
        size = 0;
    }
    
    @Override
    public void add(T value) {
        if(root == null) {
            TreeNode<T> a = new TreeNode(value);
            root = a;
            size++;
        }else {
            addHelper(root, value);
            size++;
        }
    }

    private void addHelper(TreeNode<T> a, T value){
        if(value.compareTo(a.getValue()) == 0){
            // do nothing
        }
        else if(value.compareTo(a.getValue()) < 0) {
            if(a.getLeft() == null) {
                a.setLeft(new TreeNode(value));
            }else {
                addHelper(a.getLeft(), value);
            }
        }
        else {
            if(a.getRight() == null) {
                a.setRight(new TreeNode(value));
            }else{
                addHelper(a.getRight(), value);
            }
        }
    }
    
    @Override
    public boolean contains(T val) {
        return containsHelper(root, val);
    }

    private boolean containsHelper(TreeNode<T> a, T value) {
        if(a == null) {
            return false;
        }
        if(value.compareTo(a.getValue()) == 0) {
            return true;
        }
        else if(value.compareTo(a.getValue()) < 0) {
            a = a.getLeft();
            return containsHelper(a, value);
        }
        else {
            a = a.getRight();
            return containsHelper(a, value);
        }
    }
    
    @Override
    public boolean remove(T value) {
        if(!contains(value)){
            return false;
        }
        TreeNode<T> a = root;
        TreeNode<T> parent = root;
        boolean isLeftChild = true;
        size--;
        
        while(value.compareTo(a.getValue()) != 0){
            parent = a;
            if(value.compareTo(a.getValue()) < 0) {
                isLeftChild = true;
                a = a.getLeft();
            }else {
                isLeftChild = false;
                a = a.getRight();
            }
        }
        
        //case 1 - no children
        if(a.getLeft() == null && a.getRight() == null) {
            if(a == root) {
                root = null;
            }
            else if(isLeftChild) {
                parent.setLeft(null);
            }
            else {
                parent.setRight(null);
            }
        }
        
        //case 2 - one LEFT child
        else if(a.getRight() == null) {
            if(a == root) {
                root = a.getLeft();
            }
            else if(isLeftChild) {
                parent.setLeft(a.getLeft());
            }
            else {
                parent.setRight(a.getLeft());
            }
        }
        
        //case 2 - one RIGHT child
        else if(a.getLeft() == null){
            if(a == root) {
                root = a.getRight();
            }else if (isLeftChild){
                parent.setLeft(a.getRight());
            }else{
                parent.setRight(a.getRight());
            }
        }
        
        //case 3 - two CHILD cases
        else {
            TreeNode<T> repl = getReplacement(a);
            if(a == root) {
                root = repl;
            }
            else if(isLeftChild){
                parent.setLeft(repl);
            } else {
                parent.setRight(repl);
            }
            repl.setLeft(a.getLeft());
        }
        return true;
    }
    
    private TreeNode getReplacement(TreeNode<T> nodeToReplace) {
        TreeNode<T> replacement = nodeToReplace;
        TreeNode<T> replacementParent = nodeToReplace;
        TreeNode<T> a = nodeToReplace.getRight();
        while(a != null) {
            replacementParent = replacement;
            replacement = a;
            a = a.getLeft();
        }
        if(replacement != nodeToReplace.getRight()) {
            replacementParent.setLeft(replacement.getRight());
            replacement.setRight(nodeToReplace.getRight());
        }
        return replacement;
    }

    @Override
    public T removeAny() throws Exception {
        if(size == 0) {
            throw new Exception("Empty set!");
        }
       T result = root.getValue();
       remove(result);
       return result;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    
    @Override
    public String toString() {
        return toStringHelper(root);
    }
    
    //in-order traversal for toString
    private String toStringHelper(TreeNode<T> a) {
        if(a == null) {
            return "\n";
        }
        return toStringHelper(a.getLeft()) + a.getValue() + 
                toStringHelper(a.getRight());
    }

}
