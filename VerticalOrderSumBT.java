import java.util.ArrayList;
import java.util.LinkedList;
class Pair{
    TreeNode node;
    int vl;
    Pair(TreeNode node, int vl){
        this.node=node;
        this.vl=vl;
    }
}
public class VerticalOrderSumBT {
    
    public static void widthOfBT(TreeNode root, int[] minMax, int vl){
        if(root == null){
            return;
        }
        minMax[0]=Math.min(minMax[0], vl);
        minMax[1]=Math.min(minMax[1], vl);
        widthOfBT(root, minMax, vl+1);
        widthOfBT(root, minMax, vl-1);
    }
    public static ArrayList<Integer> verticalOrderSum(TreeNode root){
        int[] minMax =new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        widthOfBT(root, minMax, 0);
        int width=minMax[1]-minMax[0]+1;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<width;i++){
            ans.add(0);
        }
        LinkedList<Pair> que=new LinkedList<>();
        que.addLast(new Pair(root, Math.abs(minMax[0])));
        
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                Pair rNode=que.removeFirst();
                ans.set(rNode.vl,ans.get(rNode.vl)+rNode.node.val);
                if(rNode.node.left!=null){
                    que.addLast(new Pair(rNode.node.left, rNode.vl-1));
                }
                if(rNode.node.right!=null){
                    que.addLast(new Pair(rNode.node.right, rNode.vl+1));
                }
            }
        }
        return ans;

    }
}
