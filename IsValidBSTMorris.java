import java.util.ArrayList;
import java.util.List;

class IsValidBSTMorris {
    public boolean isValidBST(TreeNode root) {
        
        if (root == null) {
            return true;
        }
        TreeNode prev = null;
        TreeNode curr = root;

        while (curr != null) {
            TreeNode ln = curr.left;
            if (ln == null) {
                if(prev != null && curr.val <= prev.val){
                    return false;
                }
                prev = curr;
                curr = curr.right;
                continue;
            }
            while (ln.right != null && ln.right != curr) {
                ln = ln.right;
            }
            if (ln.right == null) {
                ln.right = curr;
                curr = curr.left;
            } else {
                if(prev != null && curr.val <= prev.val){
                    return false;
                }
                prev = curr;
                ln.right = null;
                curr = curr.right;
            }
        }
        return true;
    }
}
