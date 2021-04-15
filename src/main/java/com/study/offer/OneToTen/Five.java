package com.study.offer.OneToTen;








import java.util.Arrays;

/**
 * @author ZJP
 * @create 2021-04-15 15:47
 */
public class Five {
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     *  
     *
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *  
     * 限制：
     *
     * 0 <= 节点个数 <= 5000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /** 思路
     * 前序遍历：根节点->左子树->右子树（根->左->右）
     *
     * 中序遍历：左子树->根节点->右子树（左->根->右）
     *
     * 后序遍历：左子树->右子树->根节点（左->右->根）
     *
     *二叉树前序遍历的顺序为：
     *
     * 先遍历根节点；
     *
     * 随后递归地遍历左子树；
     *
     * 最后递归地遍历右子树。
     *
     * 二叉树中序遍历的顺序为：
     *
     * 先递归地遍历左子树；
     *
     * 随后遍历根节点；
     *
     * 最后递归地遍历右子树。
     *
     */

    public static void main(String[] args) {
        //这个不是很懂坐等春鹏大佬解释
        int []  preorder={3,9,20,15,7};
        int []  inorder={9,3,15,20,7};

        Five five = new Five();
        TreeNode treeNode = five.buildTree(preorder, inorder);
        System.out.println("返回二点二叉树是："+treeNode);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
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
