package Tree5;


import Util.TreeNode;

import java.util.Stack;

/*数的深度*/
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

        System.out.println(1);
    }
}


/*递归实现*/
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)    return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
