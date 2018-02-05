package me.leetcode3;

import me.TreeNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P106 {


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        return helper(inorder,0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStartIdx, int inEndIdx, int[] postorder, int postStartIdx, int postEndIdx) {
        if (inStartIdx > inEndIdx || postStartIdx > postEndIdx) {
            return null;
        }
        TreeNode curRoot = new TreeNode(postorder[postEndIdx]);
        int inorderRootIdx = 0;
        for (int i = inStartIdx; i <= inEndIdx; i++) {
            if (curRoot.val == inorder[i]) {
                inorderRootIdx = i;
                break;
            }
        }

        int leftTreeLen = inorderRootIdx - inStartIdx;
        // 注意，这里的下标处理方式与上一题不同
        // 后序遍历的时候，左子树的长度是包括postStartIdx的，所以左子树的结束下标是postStartIdx + leftTreeLen -1
        curRoot.left = helper(inorder, inStartIdx, inorderRootIdx - 1, postorder, postStartIdx, postStartIdx + leftTreeLen - 1);
        curRoot.right = helper(inorder, inorderRootIdx + 1, inEndIdx, postorder, postStartIdx + leftTreeLen, postEndIdx - 1);
        return curRoot;
    }
}
