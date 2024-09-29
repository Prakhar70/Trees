import java.util.ArrayList;

public class SingleChildParent {
    public static void exactlyOneChild(TreeNode root, ArrayList<TreeNode> ans) {
        if(root == null || (root.left ==null && root.right == null)){
            return;
        }
        if(root.left == null || root.right == null){
            ans.add(root);
        }
        exactlyOneChild(root.left, ans);
        exactlyOneChild(root.right, ans);
    }
    public static int CountOneChild(TreeNode root) {
        if(root == null || (root.left ==null && root.right == null)){
            return 0;
        }
        int cnt=0;
        if(root.left == null || root.right == null){
            cnt=1;
        }
        cnt+=CountOneChild(root.left);
        cnt+=CountOneChild(root.right);
        return cnt;
    }
}
