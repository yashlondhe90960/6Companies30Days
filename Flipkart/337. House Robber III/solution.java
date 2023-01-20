/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] result = getMax(root);
        return Math.max(result[0], result[1]);
    }
    public int[] getMax(TreeNode root)
    {
        if(root == null)
            return new int[2];
        int[] left = getMax(root.left);
        int[] right = getMax(root.right);

        int weithRoot = left[1]+ right[1] + root.val;
        int withoutRoot = Math.max(left[0], left[1])+ Math.max(right[0], right[1]);
        return new int[]{weithRoot,withoutRoot };
    }
}