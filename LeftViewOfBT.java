import java.util.ArrayList;
import java.util.LinkedList;

public class LeftViewOfBT {
    public static ArrayList<Integer> leftView(TreeNode root){
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
               if(rNode.left!=null){
                   que.addLast(rNode.left);
               }
               if(rNode.right!=null){
                que.addLast(rNode.right);
               }
            }
        }
        return ans;
    }
}
