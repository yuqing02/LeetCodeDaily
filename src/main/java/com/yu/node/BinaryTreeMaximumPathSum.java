package com.yu.node;

import org.junit.Test;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Definition for a binary tree node.
 */
public class BinaryTreeMaximumPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int ans = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return ans;
    }

    private static int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        int max = Math.max(l, r);

        ans = Math.max(ans, root.val);
        ans = Math.max(ans, root.val + max);
        ans = Math.max(ans, root.val + l + r);

        return (max + root.val) > 0 ? max + root.val : 0;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }

    /**
     * 非递归实现
     *
     * @param treeNode
     * @return
     */
    public static List<Integer> binaryTreePreOrderByStack(TreeNode treeNode) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (treeNode == null) {
            return res;
        }
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);

            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }

    /**
     * 递归方式实现
     *
     * @param treeNode
     * @return
     */
    public static List<Integer> res = new ArrayList<>();

    public static List<Integer> binaryTreePreOrderByRecursion(TreeNode treeNode) {

        if (treeNode == null) {
            return res;
        }
        preOrder(treeNode);

        return res;
    }

    public static void preOrder(TreeNode node) {

        if (node == null) {
            return;
        }
        res.add(node.val);

        preOrder(node.left);
        preOrder(node.right);
    }

    public static List<Integer> resInOrder = new ArrayList<>();

    public static List<Integer> binaryTreeInOrderByRecursion(TreeNode node) {

        if (node == null) {
            return resInOrder;
        }

        processInorder(node);

        return resInOrder;
    }

    public static void processInorder(TreeNode node) {
        if (node == null) {
            return;
        }

        processInorder(node.left);
        resInOrder.add(node.val);
        processInorder(node.right);
    }

    public static List<Integer> binaryTreeInOrderByUnRecursion(TreeNode node) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        if (node == null) {
            return res;
        }

        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {

            TreeNode cur = stack.pop();
            res.add(cur.val);

            if (cur.right != null) {
                cur = cur.right;

                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return res;
    }

    static List<Integer> resPost = new ArrayList<>();

    public static List<Integer> binaryTreePostOrderByRecursion(TreeNode node) {

        if (node == null) {
            return resPost;
        }

        processPost(node);
        return resPost;

    }

    public static void processPost(TreeNode node) {

        if (node == null) {
            return;
        }

        processPost(node.left);
        processPost(node.right);
        resPost.add(node.val);
    }

    public static List<Integer> binaryTreePostOrderByUnRecursion(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (node == null) {
            return res;
        }
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        Collections.reverse(res);
        return res;

    }


    public static void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inProcess(node);
    }

    public static void inProcess(TreeNode node){
        if(node == null){
            return;
        }
        inProcess(node.left);
        res.add(node.val);
        inProcess(node.right);
    }

    /**
     * 中序遍历
     *
     * @param pRoot
     * @return
     */
    public int k;
     TreeNode kthNodeCore(TreeNode pRoot) {
        TreeNode target = null;

        if (pRoot.left != null) {
            target = kthNodeCore(pRoot.left);
        }
        // 核心
        if (target == null) {
            if (k == 1) {
                target = pRoot;
            }
            k--;
        }

        if (target == null && pRoot.right != null) {
            target = kthNodeCore(pRoot.right);
        }

        return target;
    }



    /**
     * 二叉搜索树的第K大节点
     *
     * @param pRoot
     * @param k
     * @return
     */
     TreeNode kthNode(TreeNode pRoot, int k) {
        // 防止特殊输入
        if (pRoot == null || k == 0) {
            return null;
        }
        this.k = k;
//        this.k = k;
        return kthNodeCore(pRoot);

    }

    Stack<TreeNode> stack = new Stack<>();


    TreeNode kthNode3(TreeNode pRoot, int k) {

        process(pRoot);

        if (stack.size() < k){
            return null;
        }
        TreeNode target =  null;
        while (k-- > 0) {
            target = stack.pop();
        }

        return target;
    }

    void process(TreeNode node){

        if (node ==null)
            return ;

        process(node.right);
        stack.add(node);
        process(node.left);
    }

    @Test
    public void test(){

        String[] xx = new String[]{"ss","ww"};
        int[] ii = new int[]{1,2};
        List<String> ll = Arrays.asList(xx);

        boolean c1 = IntStream.of(ii).anyMatch(v->v==2);
        boolean c2 = IntStream.of(ii).anyMatch(v->v==3);
        System.out.println(c1);
        System.out.println(c2);

//        double count = 4;
//        int PAGE_SIZE = 2;
//        double page = (int) Math.ceil(count/PAGE_SIZE);
//
//        System.out.println(page);
//
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(7);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(8);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//
//        System.out.println(res);
//        TreeNode treeNode =  kthNode3(root,2);
    }

    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        inOrder(pRoot);
        if(k <=0 || k>=res.size()){
            return null;
        }
        return new TreeNode(res.get(k-1));
    }

    private static TreeNode lastNode;

    public static TreeNode convert(TreeNode pRootOfTree) {

        convertChild(pRootOfTree);
        TreeNode firstNode = lastNode;
        while (lastNode != null && firstNode.left !=null) {
            firstNode = firstNode.left;
        }
        return firstNode;

    }

    public static void convertChild(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        TreeNode current = pRootOfTree;
        if (current.left != null) {
            convertChild(current.left);
        }
        // 关键
        current.left = lastNode;
        if (lastNode != null) {
            // 关键
            lastNode.right = current;
        }
        lastNode = current;
        if (current.right != null) {
            convertChild(current.right);
        }
    }
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return result;
    }

     ArrayList<ArrayList<Integer>> ssa = new ArrayList<>();
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot == null){
            return ssa;
        }
        ArrayList<TreeNode> next = new ArrayList();
        next.add(pRoot);
//        nextNodes(next);
        return ssa;
    }

    void nextNodes(List<TreeNode> nexts) {

        List<TreeNode> nextInner = new ArrayList();
        List<Integer> resNext = new ArrayList();
        for (int i = 0; i < nexts.size(); i++) {
            TreeNode next = nexts.get(i);
            resNext.add(next.val);
            if (next.left != null) {
                nextInner.add(next.left);
            }
            if (next.right != null) {
                nextInner.add(next.right);
            }
        }
        ssa.add((ArrayList<Integer>) resNext);
        if (resNext.isEmpty() || nextInner.isEmpty()) {
            return;
        }
        nextNodes(nextInner);
    }

    public static void main(String[] args) {

        double supply = 0.03989;
        double demand = 0.15528;
        double ratio = supply / demand;
        String xx =  String.format("%." + (ratio < 10 ? 2 : 1) + "f", ratio);
        System.out.println(xx);


//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.left.left = new TreeNode(8);
//        root.left.left.right = new TreeNode(-1);
//        root.left.right = new TreeNode(5);
//        root.left.right.left = new TreeNode(9);
//        root.left.right.right = new TreeNode(-1);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//        root.right.right.left = new TreeNode(-3);
//        root.right.right.right = new TreeNode(-4);





        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode result = convert(root);

//        TreeNode treeNode =  KthNode(root,3);

        System.out.println("hello");
//        List<Integer> treeNodes = binaryTreePreOrderByStack(root);
//        List<Integer> treeNodesByRecursion = binaryTreePreOrderByRecursion(root);
//        List<Integer> inorderLst = binaryTreeInOrderByRecursion(root);
//        List<Integer> inOrderByUnRecursion = binaryTreeInOrderByUnRecursion(root);
//        List<Integer> postOrderByUnRecursion = binaryTreePostOrderByRecursion(root);
//        List<Integer> postOrderByUnRecursion = binaryTreePostOrderByUnRecursion(root);

//        System.out.println(treeNodes);
//        int sum = BinaryTreeMaximumPathSum.maxPathSum(root);
//        System.out.println(sum);
    }
}
