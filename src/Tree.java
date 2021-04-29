import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Tree {
    public static void main(String args[])
    {

    }
    /*leetcode https://leetcode-cn.com/problems/increasing-order-search-tree/submissions/ 897*/
    public static TreeNode increasingBST(TreeNode root) {
        if(root==null)
            return root;
        ArrayList<Integer> list=new ArrayList<>();
        inOrder(root,list);
        TreeNode t=new TreeNode(-1);
        TreeNode next=t;
        for(int i=0;i<list.size();i++)
        {
            next.right=new TreeNode(list.get(i));
            next=next.right;
            System.out.println(next.val+" ");
        }
        return t;

    }
    public static  void inOrder(TreeNode root, ArrayList<Integer> list)
    {
        if(root==null) {
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
