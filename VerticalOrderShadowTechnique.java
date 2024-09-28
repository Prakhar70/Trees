import java.util.ArrayList;

import org.w3c.dom.NodeList;

public class VerticalOrderShadowTechnique {
    public static class DNode{
        DNode prev;
        DNode next;
        int data;
        DNode(int data){
            this.data=data;
        }
    }
    public static void dfs(Node root, DNode node){

        node.data+=root.data;
        if(root.left!=null){
            if(node.prev==null){
                DNode nnode=new DNode(0);
                nnode.next=node;
                node.prev=nnode;
            }
            dfs(root.left, node.prev);
        }
        if(root.right!=null){
            if(node.next==null){
                DNode nnode=new DNode(0);
                nnode.prev=node;
                node.next=nnode;
            }
            dfs(root.right, node.next);
        }
    }
    public static ArrayList<Integer> VerticalOrderSum(Node root){
        
        DNode node = new DNode(0);
        dfs(root, node);
        ArrayList<Integer> ans =new ArrayList<>();
        if(root ==null){
            return ans;
        }
        DNode cur=node;
        while(cur.prev!=null){
            cur=cur.prev;
        }
        while(cur.next!=null){
            ans.add(cur.data);
            cur=cur.next;
        }
        return ans;
    }

}
