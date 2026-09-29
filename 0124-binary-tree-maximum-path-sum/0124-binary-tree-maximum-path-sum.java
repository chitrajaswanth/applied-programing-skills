class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        // Maximum contribution from left subtree
        // Ignore it if it is negative
        int left = Math.max(0, dfs(node.left));

        // Maximum contribution from right subtree
        // Ignore it if it is negative
        int right = Math.max(0, dfs(node.right));

        // Path passing through the current node
        int currentPath = node.val + left + right;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPath);

        // Return the best single-sided path to parent
        return node.val + Math.max(left, right);
    }
}