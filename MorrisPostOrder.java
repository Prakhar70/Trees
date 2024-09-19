import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MorrisPostorder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            TreeNode ln = curr.left;
            if (ln == null) {
                st.add(curr);
                curr = curr.right;
                continue;
            }
            while (ln.right != null && ln.right != curr) {
                ln = ln.right;
            }
            if (ln.right == null) {
                st.add(curr);
                ln.right = curr;
                curr = curr.left;
            } else {
                while (st.peek() != curr) {
                    ans.add(st.pop().val);
                }
                ln.right = null;
                curr = curr.right;
            }
        }
        while (st.size() != 0) {
            ans.add(st.pop().val);
        }
        return ans;
    }
}
