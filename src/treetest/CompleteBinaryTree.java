package treetest;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CompleteBinaryTree<T extends Comparable> extends BinarySearchTree<T> {
    public CompleteBinaryTree() {
        super();
    }

    public CompleteBinaryTree(T[] levelOrderArray) {
        this.root = create(levelOrderArray, 0);
    }

    public BinaryNode<T> create(T[] levelOrderArray, int i) {
        if (levelOrderArray == null) {
            throw new RuntimeException("the param 'array' of create method can\'t be null!");
        }
        BinaryNode<T> p = null;
        if (i < levelOrderArray.length) {
            p = new BinaryNode<>(levelOrderArray[i], null, null);
            p.left = create(levelOrderArray, 2 * i + 1);
            p.right = create(levelOrderArray, 2 * i + 2);
        }
        return p;
    }

    @Override
    public boolean contains(T data) throws Exception {
        ConcurrentLinkedQueue<BinaryNode<T>> queue = new ConcurrentLinkedQueue<>();
        BinaryNode<T> p = this.root;
        while (p != null) {
            if (data.compareTo(p.data) == 0)
                return true;
            if (p.left != null)
                queue.add(p.left);
            if (p.right != null)
                queue.add(p.right);
            p = queue.poll();
        }


        return false;
    }

    public static void main(String args[]) throws Exception {

        String[] levelorderArray = {"A", "B", "C", "D", "E", "F"};
        CompleteBinaryTree<String> cbtree = new CompleteBinaryTree<>(levelorderArray);
        System.out.println("先根遍历:" + cbtree.preOrder());
        //System.out.println("非递归先根遍历:"+cbtree.preOrderTraverse());
        System.out.println("中根遍历:" + cbtree.inOrder());
        //System.out.println("非递归中根遍历:"+cbtree.inOrderTraverse());
        System.out.println("后根遍历:" + cbtree.postOrder());
        //System.out.println("非递归后根遍历:"+cbtree.postOrderTraverse());
        System.out.println("查找最大结点(根据搜索二叉树):" + cbtree.findMax());
        System.out.println("查找最小结点(根据搜索二叉树):" + cbtree.findMin());
        System.out.println("判断二叉树中是否存在E:" + cbtree.contains("E"));
        System.out.println("判断二叉树中是否存在G:" + cbtree.contains("G"));

    }
}
