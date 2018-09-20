package com.test.lintcode.tree;

/**
 * Created by le on 2017/3/11.
 * 根据前序遍历结果和中序遍历结果还原二叉树
 */
public class RestoreBinaryTreeByTwoTraverseOder  {

    //返回根节点               前序遍历         中序遍历
    public Node restore(int[] preorder, int[] inorder) {
        if (preorder.length == 0 ||  inorder.length == 0) {
            return null;
        }
        //前序遍历的第一个一定是跟节点
        Node root = new Node(preorder[0]);
        int rootIndexInInorder = findIndexByValue(preorder[0], inorder);
        int lengthOfSubPreorder1 = rootIndexInInorder;
        int[] subPreorder1 = {};    //左子树的前序遍历结果
        if (lengthOfSubPreorder1 > 0) {
            // generate subPreorder1 2485
            subPreorder1 = new int[lengthOfSubPreorder1];
            //将perorder数组从第一个元素开始复制到subpreorder1数组中从0开始复制长度lengthOfSubPreorder1
            System
                    .arraycopy(preorder, 1, subPreorder1, 0,
                            lengthOfSubPreorder1);
        }
        // remain subPreorder
        int lengthOfSubPreorder2 = preorder.length - lengthOfSubPreorder1 - 1;
        int[] subPreorder2 = {};    //右子树的前序遍历结果
        if (lengthOfSubPreorder2 > 0) {
            // generate subPreorder2 367
            subPreorder2 = new int[lengthOfSubPreorder2];
            System.arraycopy(preorder, preorder.length
                    - lengthOfSubPreorder2, subPreorder2, 0, lengthOfSubPreorder2);
        }

        int lengthOfSubinorder1 = rootIndexInInorder;
        int[] subinorder1 = {};     //左子数的中序遍历结果
        if (lengthOfSubinorder1 > 0) {
            subinorder1 = new int[lengthOfSubinorder1];
            // generate subPreorder1 8425
            System.arraycopy(inorder, 0, subinorder1, 0, lengthOfSubinorder1);
        }
        // remain subInorder
        int lengthOfSubInorder2 = preorder.length - lengthOfSubinorder1 - 1;
        int[] subinorder2 = {};     //右子树的中序遍历结果
        if (lengthOfSubInorder2 > 0) {
            subinorder2 = new int[lengthOfSubInorder2];
            // generate subPreorder2 637
            System.arraycopy(inorder, inorder.length
                    - lengthOfSubInorder2, subinorder2, 0, lengthOfSubPreorder2);
        }
        //递归调用求左子树和右子数
        root.setLeft(restore(subPreorder1,subinorder1));
        root.setRight(restore(subPreorder2,subinorder2));
        return root;
    }

    /**
     * find the index of the same value of compareValue in array a
     *
     * @param compareValue
     * @param a
     * @return
     */
    public int findIndexByValue(int compareValue, int[] a) {
        if (null == a || a.length == 0) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == compareValue) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //12485367; inorder traversal : 84251637;
        int[] preorder = {1,2,4,5,7,3,6,8,9};
        int[] inorder = {4,2,5,7,1,3,8,6,9};
        RestoreBinaryTreeByTwoTraverseOder runner = new RestoreBinaryTreeByTwoTraverseOder();
        Node head = new Node(-1);//
        head = runner.restore(preorder, inorder);
        if(null == head){
            return ;
        }
        runner.preorderTraverse(head);
        System.out.println();
        runner.inorderTraverse(head);
    }
    /**
     * Traverse in preorder
     * @param root
     */
    public void preorderTraverse(Node root){
        if(null == root)
            return;
        System.out.print(root.getKey());
        preorderTraverse(root.getLeft());
        preorderTraverse(root.getRight());
    }
    /**
     * Traverse in inorder
     * @param root
     */
    public void inorderTraverse(Node root){
        if(null == root)
            return;
        inorderTraverse(root.getLeft());
        System.out.print(root.getKey());
        inorderTraverse(root.getRight());
    }
}

class Node {
    public Node() {
    };

    public Node(int key) {
        this.key = key;
    }

    private int key;
    private Node left;
    private Node right;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }


}
