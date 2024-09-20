public class ConstructBSTFromPre {
    static int idx = 0;

    TreeNode buildTree(int[] preorder) {
        return buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] preorder, int lr, int rr) {
        if (idx == preorder.length) {
            return null;
        }
        if (preorder[idx] > lr && preorder[idx] < rr) {
            TreeNode root = new TreeNode(preorder[idx]);
            idx++;
            root.left = buildTree(preorder, lr, root.val);
            root.right = buildTree(preorder, root.val, rr);
            
            return root;
        } else {
            return null;
        }

    }
}
