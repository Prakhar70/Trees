import java.util.ArrayList;
import java.util.LinkedList;

public class RightViewOfBT {
    public static ArrayList<Integer> rightSideView(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        while (que.size()>0){
            int size = que.size();
            ans.add(que.getFirst().val);
            while(size-->0){
               
               TreeNode rNode = que.removeFirst();
               if(rNode.right!=null){
                   que.addLast(rNode.right);
               }
               if(rNode.left!=null){
                que.addLast(rNode.left);
               }
            }
        }
        return ans;
    }
}
