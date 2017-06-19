/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

/**
 *
 * @author User
 */
public class TreeNode<T> {
    
    private T value;
    private TreeNode<T> right;
    private TreeNode<T> left;
    
    public TreeNode(T val){
        value = val;
        right = null;
        left = null;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    public TreeNode<T> getRight() {
        return right;
    }
    
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
    
    public TreeNode<T> getLeft() {
        return left;
    }
    
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }
    
    @Override
    public String toString() {
        return value.toString();
    }
}
