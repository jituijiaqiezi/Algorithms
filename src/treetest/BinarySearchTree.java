package treetest;


import edu.princeton.cs.algs4.LinkedQueue;

import java.util.EmptyStackException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BinarySearchTree<T extends Comparable> implements Tree<T> {

    protected BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(BinaryNode<T> subtree) {
        if (subtree == null)
            return 0;
        else {
            return size(subtree.left) + 1 + size(subtree.right);
        }
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(BinaryNode<T> subtree) {
        if (subtree == null)
            return 0;
        else {
            int l = height(subtree.left);
            int r = height(subtree.right);
            return (l > r) ? (l + 1) : (r + 1);
        }
    }

    @Override
    public String preOrder() {
        String sb = preOrder(root);
        if (sb.length() > 0)
            sb = sb.substring(0, sb.length() - 1);
        return sb;
    }

    private String preOrder(BinaryNode<T> subtree) {
        StringBuffer sb = new StringBuffer();
        if (subtree != null) {
            sb.append(subtree.data).append(",");
            sb.append(preOrder(subtree.left));
            sb.append(preOrder(subtree.right));
        }
        return sb.toString();
    }

    @Override
    public String inOrder() {
        String sb = inOrder(root);
        if (sb.length() > 0)
            sb = sb.substring(0, sb.length() - 1);
        return sb;
    }

    public String inOrder(BinaryNode<T> subtree) {
        StringBuffer sb = new StringBuffer();
        if (subtree != null) {
            sb.append(inOrder(subtree.left));
            sb.append(subtree.data).append(",")
                    .append(inOrder(subtree.right));
        }
        return sb.toString();
    }

    @Override
    public String postOrder() {
        String sb = postOrder(root);
        if (sb.length() > 0)
            sb = sb.substring(0, sb.length() - 1);
        return sb;
    }

    public String postOrder(BinaryNode<T> subtree) {
        StringBuffer sb = new StringBuffer();
        if (subtree != null) {
            sb.append(postOrder(subtree.left));
            sb.append(postOrder(subtree.right));
            sb.append(subtree.data).append(",");
        }
        return sb.toString();
    }

    @Override
    public String levelOrder() {
        ConcurrentLinkedQueue<BinaryNode<T>> queue = new ConcurrentLinkedQueue<>();
        StringBuffer sb = new StringBuffer();
        BinaryNode<T> p = this.root;
        while (p != null) {
            sb.append(p.data);
            if (p.left != null)
                queue.add(p.left);
            if (p.right != null)
                queue.add(p.right);

            p = queue.poll();
        }
        return sb.toString();
    }

    @Override
    public void insert(T data) {
        if (data == null)
            throw new RuntimeException("data can \'Comparable be null !");
        root = insert(data, root);
    }

    /**
     * 插入操作，递归实现
     *
     * @param data
     * @param p
     * @return
     */
    private BinaryNode<T> insert(T data, BinaryNode<T> p) {
        if (p == null)
            p = new BinaryNode<>(data, null, null);
        int compareResult = data.compareTo(p.data);
        if (compareResult < 0)
            p.left = insert(data, p.left);
        else if (compareResult > 0)
            p.right = insert(data, p.right);
        return p;
    }

    @Override
    public void remove(T data) {
        if (data == null)
            throw new RuntimeException("data can \'Comparable be null !");
        root = remove(data, root);
    }

    private BinaryNode<T> remove(T data, BinaryNode<T> p) {
        if (p == null)
            return p;
        int compareResult = data.compareTo(p.data);
        if (compareResult < 0)
            p.left = remove(data, p.left);
        else if (compareResult > 0)
            p.right = remove(data, p.right);
        else if (p.left != null && p.right != null) {
            p.data = findMin(p.right).data;
            p.right = remove(p.data, p.right);
        } else {
            p = (p.left != null) ? p.left : p.right;
        }
        return p;
    }

    @Override
    public T findMin() {
        if (isEmpty())
            throw new RuntimeException("BinarySearchTree is empty!");
        return findMin(root).data;
    }

    /**
     * 查找最小值节点
     *
     * @param p
     * @return
     */
    private BinaryNode<T> findMin(BinaryNode<T> p) {
        if (p == null)
            return null;
        else if (p.left == null)
            return p;
        return findMin(p.left);
    }

    @Override
    public T findMax() {
        if (isEmpty())
            throw new RuntimeException("BinarySearchTree is empty!");
        return findMax(root).data;
    }

    /**
     * 查找最大值节点
     *
     * @param p
     * @return
     */
    private BinaryNode<T> findMax(BinaryNode<T> p) {
        if (p == null)
            return null;
        else if (p.right == null)
            return p;
        return findMax(p.right);
    }

    @Override
    public BinaryNode findNode(T data) {
        return null;
    }

    @Override
    public boolean contains(T data) throws Exception {
        if (data == null)
            throw new RuntimeException("data can \'Comparable be null !");
        BinaryNode<T> node = root;
        while (node != null) {
            int compareResult = data.compareTo(node.data);
            if (compareResult < 0) {
                node = node.left;
            } else if (compareResult > 0)
                node = node.right;
            else
                return true;
        }
        return false;
    }

    @Override
    public void clear() {

    }

    /**
     * 根据先根和后根遍历算法构造二叉树
     *
     * @param preList
     * @param inList
     * @param preStart
     * @param preEnd
     * @param inStart
     * @param inEnd
     * @return
     */
    public BinaryNode<T> createBinarySearchTreeByPreIn(T[] preList, T[] inList, int preStart, int preEnd, int inStart, int inEnd) {
        BinaryNode<T> p = new BinaryNode<>(preList[preStart]);
        if (preStart == preEnd && inStart == inEnd)
            return p;

        int root = 0;
        for (root = inStart; root < inEnd; root++) {
            if (preList[preStart].compareTo(inList[root]) == 0)
                break;
        }
        int leftLength = root - inStart;
        int rightLength = inEnd - root;

        if (leftLength > 0)
            p.left = createBinarySearchTreeByPreIn(preList, inList, preStart + 1, preStart + leftLength, inStart, root - 1);
        if (rightLength > 0)
            p.right = createBinarySearchTreeByPreIn(preList, inList, preStart + leftLength + 1, preEnd, root + 1, inEnd);
        return p;
    }

    public BinaryNode<T> createBinarySearchTreeByPostIn(T[] postList, T[] inList, int postStart, int postEnd, int inStart, int inEnd) {
        BinaryNode<T> p = new BinaryNode<>(postList[postEnd]);
        if (postStart == postEnd && inStart == inEnd)
            return p;

        int root = 0;
        for (root = inStart; root < inEnd; root++)
            if (postList[postEnd].compareTo(inList[root]) == 0)
                break;

        int leftLength = root - inStart;
        int rightLength = inEnd - root;

        if (leftLength > 0)
            p.left = createBinarySearchTreeByPostIn(postList, inList, postStart, postStart + leftLength - 1, inStart, root - 1);
        if (rightLength > 0)
            p.right = createBinarySearchTreeByPostIn(postList, inList, postStart + leftLength, postEnd - 1, root + 1, inEnd);
        return p;
    }
}
