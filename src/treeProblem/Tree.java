package treeProblem;

import java.util.*;



public class Tree {
    public static void main(String args[])
    {

    }
    /*
    给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。

如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。

如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/leaf-similar-trees
    * */
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> res1=new ArrayList<>();
        ArrayList<Integer> res2=new ArrayList<>();
        levelNode(root1,res1);
        levelNode(root2,res2);
        if(res1.size()!=res2.size())
            return false;
        for(int i=0;i<res1.size();i++)
        {
            if(res1.get(i)!=res2.get(i))
                return false;
        }
        return true;


    }
    public static  void levelNode(TreeNode root,ArrayList<Integer> list)
    {

         if(root==null)
             return;
         levelNode(root.left,list);
         if(root.left==null&&root.right==null)
             list.add(root.val);
         levelNode(root.right,list);

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
