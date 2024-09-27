import java.util.ArrayList;
import java.util.LinkedList;

public class DiagonalOrderSumBFS {
    public static ArrayList<Integer> diagonalSum(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);
        while(que.size()!=0){
            int size=que.size();
            int sum=0;
            while(size-->0){
                Node rNode = que.removeFirst();
                while(rNode!=null){
                    if(rNode.left != null){
                        que.addLast(rNode.left);
                    }
                    sum+=rNode.data;
                    rNode=rNode.right;
                }
            }
            ans.add(sum);
        }
        return ans;
    }
}
