package cn.guxiangfly.waibao;

/**
 * Tree
 *
 * @author guxiang
 * @date 2017/12/15
 */
public class Tree <T extends Comparable<T>> {
    private TreeNode<T> root;
    private int depth;

    public Tree(){
        root = null;
        depth =-1;
    }

    public void  insert(T value){
        if (root == null)
        {
            root = new TreeNode<>(value);
            depth=0;
            return;
        }

        int maybedepth=-1;
        TreeNode<T> cur = root;
        while (true){
            if (value.compareTo(cur.value)<0){
                maybedepth++;

                if (cur.left!=null){
                    cur=cur.left;
                }
                else {
                    cur.left = new TreeNode<>(value);
                    if (maybedepth>depth){
                        depth=maybedepth;
                    }
                    return;
                }
            }

            if (value.compareTo(cur.value)>0){
                maybedepth++;

                if (cur.right!=null){
                    cur=cur.right;
                }
                else {
                    cur.right = new TreeNode<>(value);
                    if (maybedepth>depth){
                        depth=maybedepth;
                    }
                    return;
                }
            }
            else return;
        }
    }

    public int getDepth() {
        return depth;
    }

    public T getRoot() {
        return root.value;
    }
}
