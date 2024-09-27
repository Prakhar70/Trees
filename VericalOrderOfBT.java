//https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
import java.util.ArrayList;
import java.util.LinkedList;

class Node{
    Node right;
    Node left;
    int data;
    Node (int data){
        this.data = data;
    }
}
class Pair {
    Node node;
    int vl;

    Pair(Node node, int vl) {
        this.node = node;
        this.vl = vl;
    }
}

class Solution
{
static void widthOfTree(Node root, int[] minMax, int vl) {

    if (root == null) {
        return;
    }
    minMax[0] = Math.min(minMax[0], vl);
    minMax[1] = Math.max(minMax[1], vl);
    widthOfTree(root.left, minMax, vl - 1);
    widthOfTree(root.right, minMax, vl + 1);
}

static ArrayList<Integer> verticalOrder(Node root) {

    int[] minMax = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
    widthOfTree(root, minMax, 0);
    int width = (minMax[1] - minMax[0]) + 1;
    
    ArrayList<Integer>[] al = new ArrayList[width];
    ArrayList<Integer> ans=new ArrayList<>();

    for (int i=0;i<al.length;i++) {
        al[i]=new ArrayList<>();
    }
   
    Pair pp = new Pair(root, -minMax[0]);
    LinkedList<Pair> que=new LinkedList<>();
    que.addLast(pp);
    while (que.size() > 0) {
        int size = que.size();
        while (size-- > 0) {
            Pair rPair = que.removeFirst();
            al[rPair.vl].add(rPair.node.data);
            
            if (rPair.node.left != null) {
                que.addLast(new Pair(rPair.node.left, rPair.vl - 1));
            }
            if (rPair.node.right != null) {
                que.addLast(new Pair(rPair.node.right, rPair.vl + 1));
            }
        }
    }
    for (int i=0;i<al.length;i++) {
        for(int ele:al[i]){
            ans.add(ele);
        }
    }
    return ans;
}
}