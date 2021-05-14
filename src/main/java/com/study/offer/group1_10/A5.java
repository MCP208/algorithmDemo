package com.study.offer.group1_10;

import java.util.Arrays;

/**
 * @author ZJP
 * @create 2021-04-15 15:47
 */
public class A5 {

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如，给出
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *     3                    val(3)
     *    / \                   / \
     *   9  20             left    right
     *     /  \             /       \
     *    15   7        val(9)     val(20)
     *                              /    \
     *                           left    right
     *                          /           /
     *  `                val(15)         val(7)
     *                    /  \              /  \
     *               left    right      left    right
     *               /          \       /          \
    *             null           null null           null
     * 限制：
     * 0 <= 节点个数 <= 5000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /** 知识点：
     * 前序遍历：根节点->左子树->右子树（根->左->右）
     * 中序遍历：左子树->根节点->右子树（左->根->右）
     * 后序遍历：左子树->右子树->根节点（左->右->根）
     */


    /** 思路：
     * 1.根据前序遍历的结果确定根节点，前序遍历是先遍历根节点的，所以第一个元素也就是索引为0的就是他的根节点
     * 2.找到根节点，再去中序遍历的结果中，找到根节点所在位置的下标，该下标之前的都是左子树。之后的都是右子树
     * 3.递归调用，把当前子树作为完整树，再次进行调用,直到 preorder.length==0d的时候，说明处理完成，返回结果
     */

    public static void main(String[] args) {
        //这个不是很懂坐等春鹏大佬解释
        int []  preorder={3,9,20,15,7};
        int []  inorder={9,3,15,20,7};

        A5 five = new A5();
        TreeNode treeNode = five.buildTree(preorder, inorder);
        System.out.println("返回二点二叉树是："+treeNode);
    }

    public class TreeNode {
      int val;  //根节点
      TreeNode left; //左子树
      TreeNode right;   //右子树
      TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0)
            return null;
        int rootVal = preorder[0], rootIndex = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, n), Arrays.copyOfRange(inorder, rootIndex + 1, n));
        return root;
    }

}
