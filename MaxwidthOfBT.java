import java.util.LinkedList;

public class MaxwidthOfBT {
    class Pair{
        TreeNode node;
        int lvl;
        Pair(TreeNode node, int lvl){
            this.node= node;
            this.lvl = lvl;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxWidth=1;
        LinkedList<Pair> que=new LinkedList<>();
        que.add(new Pair(root, 0));
        while(que.size()>0){
            int size=que.size();
            int width = que.getLast().lvl-que.getFirst().lvl+1;
            maxWidth=Math.max(maxWidth, width);
            while(size-->0){
                Pair rPair=que.removeFirst();
                if(rPair.node.left!=null){
                    que.addLast(new Pair(rPair.node.left, (rPair.lvl)*2));
                }
                if(rPair.node.right!=null){
                    que.addLast(new Pair(rPair.node.right, (rPair.lvl)*2+1));
                }
            }
        }
        return maxWidth;
    }
}
