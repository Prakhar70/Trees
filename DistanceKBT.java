import java.util.ArrayList;
import java.util.List;

public class DistanceKBT {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> ans=new ArrayList<>();
        findData(root, target.val, ans,k);
        
        return ans;

    }
    private void kDownAdd(TreeNode root, int k, TreeNode blocker, List<Integer> ans) {
        if(root ==null || root == blocker||k<0){
            return;
        }
        if(k==0){
            ans.add(root.val);
            return;
        }
        kDownAdd(root.left, k-1, blocker, ans);
        kDownAdd(root.right, k-1, blocker, ans);
    }
    public int findData(TreeNode root, int data, List<Integer> ans, int k ){
        if(root == null){
            return 0;
        }
        if(root.val == data){
            kDownAdd(root, k, null, ans);
            return 1;
        }
        int left = findData(root.left, data ,ans, k);
        if(left > 0){
            kDownAdd(root, k-left, root.left, ans);
            return left+1;
        }
        int right = findData(root.right, data, ans, k);
        if(right > 0){
            kDownAdd(root, k-right, root.right, ans);
            return right+1;
        }
        return 0;

    }
}
