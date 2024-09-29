import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tans=new ArrayList<>();
        pathSum(root, targetSum, tans, ans);
        return ans;
    }

    private void pathSum(TreeNode root, int targetSum, List<Integer> tans, List<List<Integer>> ans) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                tans.add(root.val);
                ans.add(new ArrayList<>(tans));
                tans.remove(tans.size()-1);
            }
            return;
        }
        tans.add(root.val);
        pathSum(root.left, targetSum-root.val, tans, ans);
        pathSum(root.right, targetSum-root.val, tans, ans);
        tans.remove(tans.size()-1);
    }
}
