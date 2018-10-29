package cn.guxiangfly.algorithm.tree.binarySearchTree;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/7/18
 * @desc : JavaHomeWork
 */
public class BinarySearchTree<E extends Comparable> {

    private class Node {
        E e;
        Node left;
        Node right;


        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }


    private int size;
    private Node root;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public boolean isEmply() {
        return size == 0;
    }

    //向二分搜索树中添加新元素
    public void add(E e) {
       // root = add(root, e);

        if (root == null) {
            size++;
            root =  new Node(e);
            return;
        }
        nodeAdd2(root,e);
    }

    // 向node为根的节点添加新元素
    public Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.equals(node.e)) {
            return node;
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }



    // 向node为根的节点添加新元素
    public void nodeAdd2(Node node, E e) {

        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
        }

        if (e.compareTo(node.e) < 0) {
            nodeAdd2(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            nodeAdd2(node.right, e);
        }
    }


    public boolean contains(E e) {
        return contains(root, e);
    }

    public boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.equals(node.e)) {
            return true;
        }
        if (e.compareTo(node.e) < 0) {
            contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            contains(node.right, e);
        }
        return false;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        postOrder(node.left);
        postOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        generateStringBuilder(root, 0, stringBuilder);
        return stringBuilder.toString();
    }

    private void generateStringBuilder(Node node, int depth, StringBuilder resString) {
        if (node == null) {
            resString.append(generatedepthString(depth) + "null\n");
            return;
        }
        resString.append(generatedepthString(depth) + node.e + "\n");

        generateStringBuilder(node.left,depth+1,resString);
        generateStringBuilder(node.right,depth+1,resString);
    }

    private String generatedepthString(int depth) {
        StringBuilder deepstring = new StringBuilder();
        for (int j = 0; j < depth; j++) {
            deepstring.append("--");
        }
        return deepstring.toString();
    }
}