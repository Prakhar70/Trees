import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class DiagonalOrderOfBT {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        LinkedList<TreeNode> que=new LinkedList<>();
        que.addLast(root);

        while(que.size()>0){
            int size=que.size();
            ArrayList<Integer> tempList=new ArrayList<>();
            while(size-->0){
                TreeNode rNode = que.removeFirst();
                while(rNode!=null){
                    if(rNode.left != null){
                        que.addLast(rNode.left);
                    }
                    tempList.addLast(rNode.val);
                    rNode=rNode.right;
                }
                
            }
            ans.add(tempList);
        }
        return ans;

    }
}