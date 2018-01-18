package treetest;

import java.io.Serializable;

public class BinaryNode<T extends Comparable> implements Serializable {

    private static final long serialVersionUID = -5791166716761713777L;

    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public T data;

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data){
        this(data,null,null);
    }

    /**
     * 判断是否为叶子节点
     * @return
     */
    public boolean isLeaf(){
        return this.left==null&&this.right==null;
    }
}
