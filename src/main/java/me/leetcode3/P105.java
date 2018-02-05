package me.leetcode3;

import me.TreeNode;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper (int[] preorder, int[] inorder, int preStartIdx, int preEndIdx, int inStartIdx, int inEndIdx) {
        if (preStartIdx<preEndIdx || inStartIdx > inEndIdx) {
            return null;
        }

        TreeNode curRoot = new TreeNode(preorder[preStartIdx]);
        int inorderRootIdx = 0;
        for (int i = inStartIdx; i <= inEndIdx; i++) {
            if (curRoot.val == inorder[i]) {
                inorderRootIdx = i;
                break;
            }
        }

        int leftTreeLen = inorderRootIdx - inStartIdx;

        curRoot.left = helper(preorder, inorder, preStartIdx + 1, preStartIdx + leftTreeLen, inStartIdx, inorderRootIdx - 1);
        curRoot.right = helper(preorder, inorder, preStartIdx + leftTreeLen + 1, preEndIdx, inorderRootIdx + 1, inEndIdx);

        return curRoot;
    }
}
