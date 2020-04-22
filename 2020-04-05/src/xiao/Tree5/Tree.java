package xiao.Tree5;


import Util.TreeNode;

import java.util.*;

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




        new Solution4().postorderTraversal(tree);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*递归大法*/
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root == null) return res;

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);

        return res;
    }
}

/*栈遍历大法*/
class Solution1 {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        boolean flag = false;
        if(root == null) return res;
        //根节点入栈
        stack.push(root);
        TreeNode iterator = root;
        //直到栈为空，结束迭代
        while(stack.size() != 0){
            //一路向左入栈，直到左节点为空
            while(iterator.left != null && flag == false){
                stack.push(iterator.left);
                iterator = iterator.left;
            }
            //不能再左时弹出栈顶并访问
            iterator = stack.pop();
            res.add(iterator.val);
            //如果栈顶的右子节点不为空，则右子节点入栈，重复其左子节点不断入栈
            if(iterator.right != null) {
                stack.push(iterator.right);
                iterator = iterator.right;
                flag = false;
            }
            //否则，继续弹出栈顶元素
            else{
                flag = true;
            }
        }

        return res;
    }
}

/*前序非递归遍历*/
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack();
        TreeNode iterator = root;
        //根节点入栈
        stack.push(root);
        while(stack.size() != 0){
            //弹栈顶，右子节点入栈，左子节点入栈
            iterator = stack.pop();
            res.add(iterator.val);
            if(iterator.right != null)
                stack.push(iterator.right);
            if(iterator.left != null)
                stack.push(iterator.left);
        }

        return res;
    }
}

/*后序非递归遍历*/
class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        //根节点入栈
        stack.push(root);
        TreeNode iterator = root;
        TreeNode tmp;
        while(stack.size() != 0){
            tmp = stack.peek();
            //如果栈顶元素是叶子节点或者上次弹出的元素是栈顶的子节点
            if(!hasChild(tmp) || isChild(iterator, tmp)){
                iterator = stack.pop();
                res.add(iterator.val);
            }
            //否则，将栈顶的右、左子节点入栈
            else{
                if(tmp.right != null)
                    stack.push(tmp.right);
                if(tmp.left != null)
                    stack.push(tmp.left);
            }

        }

        return res;
    }

    private boolean hasChild(TreeNode node){
        if(node.left == null && node.right == null) return false;
        return true;
    }

    private boolean isChild(TreeNode iterator, TreeNode stackTop){
        if(iterator == stackTop.left || iterator == stackTop.right)
            return true;
        return false;
    }
}

/*后序采用逆前序非递归遍历*/
class Solution4 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Integer> resStack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack();
        TreeNode iterator = root;
        //根节点入栈
        stack.push(root);
        while(stack.size() != 0){
            //弹栈顶，右子节点入栈，左子节点入栈
            iterator = stack.pop();
            resStack.push(iterator.val);
            if(iterator.left != null)
                stack.push(iterator.left);
            if(iterator.right != null)
                stack.push(iterator.right);
        }

        //反转结果
        for(int i = 0; i < resStack.size(); i++){
            res.add(resStack.pop());
        }
        return res;
    }
}

/*层序遍历*/
class Solution5 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return  res;
        Queue<TreeNode> queue = new LinkedList<>();
        int cnt = 0;
        //采用队列实现
        //先将root入队
        queue.add(root);
        cnt++;
        List<Integer> tmp = new ArrayList<>();
        while(queue.size() != 0){
            //队头的左右子节点入队
            if(queue.peek().left != null){
                queue.add(queue.peek().left);
            }

            if(queue.peek().right != null){
                queue.add(queue.peek().right);
            }
            //队头出队
            //计算当前层有多少个元素：等于队列的长度
            tmp.add(queue.poll().val);
            cnt--;
            if(cnt == 0){
                res.add(tmp);
                tmp = new ArrayList<>();
                cnt = queue.size();
            }
        }

        //如何统计每一层元素个数，通过两个计数器实现
        return res;
    }
}