package xiao.Tree5;


import Util.TreeNode;

import java.util.Stack;

/*中序遍历*/
public class Tree {
    public static void main(String[] args) {
        //构建测试用例
        /*          1
        *            \
        *             2
        *            /
        *           3
        * */
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);

        TreeNode tree2 = new TreeNode(8);
        tree2.left= new TreeNode(9);
        tree2.right= new TreeNode(2);

        TreeNode tree3 = new TreeNode(2);

        System.out.println(new Solution2().HasSubtree(tree2,tree2));
    }
}

/*判断两棵树是否相同*/
/*同步层序遍历也可以*/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q== null)   return true;
        if(p == null || q == null)  return false;
        if(p.val == q.val)
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        else
            return false;
    }
}

/*判断两棵树中，一棵树是否是另一颗的子树*/
class Solution2 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null)   return false;
        //遍历树root1,判断其子树与root2是否相同
        //写中序遍历
        Stack<TreeNode> stack = new Stack();
        //根节点入栈
        stack.push(root1);
        TreeNode iterator = root1;
        boolean flag = true;
        while(stack.size() != 0 ){
            while(iterator.left != null && flag){
                stack.push(iterator.left);
                iterator = iterator.left;
            }
            //左节点为空，弹出栈顶
            iterator = stack.pop();
            flag = false;
            if(isSameTree(iterator, root2)) return true;
            //将迭代器的右子树入栈
            if(iterator.right != null){
                stack.push(iterator.right);
                iterator = iterator.right;
                flag = true;
            }
        }

        int k = 1;

        return false;

    }
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q== null)   return true;
        if(p == null || q == null)  return false;
        if(p.val == q.val)
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        else
            return false;
    }
}
