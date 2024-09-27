import java.util.ArrayList;
import java.util.LinkedList;
//https://www.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
public class DiagonalOrderOfBTGG {
    public ArrayList<Integer> diagonal(Node root){
          LinkedList<Node> que=new LinkedList<>();
          ArrayList<Integer> ans=new ArrayList<>();
          que.add(root);
          while(que.size()!=0){
            Node rNode = que.removeFirst();
            while(rNode!=null){
                if(rNode.left!=null){
                    que.addLast(rNode.left);
                }
                ans.add(rNode.data);
                rNode=rNode.right;
            }
          }
          return ans;
    }
}
