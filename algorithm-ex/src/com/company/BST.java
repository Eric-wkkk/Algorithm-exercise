package com.company;

public class BST {

    static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value){
            this.value=value;
        }
    }

    public TreeNode root;

    //前序遍历：先访问节点自己，然后访问左子树，最后再访问右子树，对于每个节点迭代此操作
    public void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }


    //中序遍历： 先访问左子树上的节点，再访问自己，最后再访问右子树上的节点
    //有序遍历
    public void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value+" ");
        inOrderTraversal(root.right);
    }

    //后续遍历： 先访问左右子树，最后再访问自己
    public void postOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value+" ");
    }

    public TreeNode get(int key){
        TreeNode cur = root;
        while(cur!=null&&cur.value!=key){
            if(cur.value>key){
                cur = cur.left;
            }else if(cur.value<key){
                cur = cur.right;
            }
        }
        return cur==null? null:cur;
    }


    public void insert(int key){
        if(root == null){
            root = new TreeNode(key);
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while(true){
            parent=cur;
            if(key<parent.value){
                cur = parent.left;
                if(cur == null){
                    parent.left = new TreeNode(key);
                    return;
                }
            }
            else if(key > parent.value){
                cur = parent.right;
                if(cur == null){
                    parent.right = new TreeNode(key);
                    return;
                }
            }
            else{
                return;
            }
        }
    }
    public static void main(String[] args) {
        BST bst = new BST();
        bst.root = new BST.TreeNode(5);
        bst.insert(3);
        bst.insert(4);
        bst.insert(-1);
        bst.insert(8);
        bst.insert(-6);
        bst.insert(0);
        /*
         *               5
         *              / \
         *             3   8
         *            / \
         *          -1   4
         *          / \
         *        -6   0
         * */

        bst.preOrderTraversal(bst.root);
        System.out.println();
        bst.inOrderTraversal(bst.root);
        System.out.println();
        bst.postOrderTraversal(bst.root);

    }

}
