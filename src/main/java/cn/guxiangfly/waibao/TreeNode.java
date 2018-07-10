package cn.guxiangfly.waibao;

import com.sun.mail.imap.Rights;

/**
 * TreeNode
 *
 * @author guxiang
 * @date 2017/12/15
 */
public class TreeNode<T> {
    public T value;

    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
        left = right=null;
    }


}


class TestTree{
    public static void main(String[] args) {
        Tree<String> tr = new Tree<>();

        String arr[] = {
                "tomatoes","papayas","cantalopes",
                "kiwis","blackberries","pears",
                "apples","boisenberries","peaches",
                "pumpkins"
        };
        for (String s : arr) {
            tr.insert(s);
        }

        System.out.println(tr.getRoot());
        System.out.println(tr.getDepth());
    }
}