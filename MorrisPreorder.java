import java.util.ArrayList;
import java.util.List;

public class MorrisPreorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        TreeNode curr = root;
        while (curr != null) {
            TreeNode ln = curr.left;
            if (ln == null) {
                ans.add(curr.val);
                curr = curr.right;
                continue;
            }
            while (ln.right != null && ln.right != curr) {
                ln = ln.right;
            }
            if (ln.right == null) {
                ans.add(curr.val);
                ln.right = curr;
                curr = curr.left;
            } else {
                ln.right = null;
                
                curr = curr.right;
            }
        }
        return ans;
    }
}
