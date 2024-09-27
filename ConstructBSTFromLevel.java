import java.util.LinkedList;

class Pair {
    TreeNode parent;
    int lr;
    int rr;

    Pair(TreeNode parent, int lr, int rr) {
        this.parent = parent;
        this.lr = lr;
        this.rr = rr;
    }
}

public class ConstructBSTFromLevel {
    public TreeNode build (int[] levelOrder){
        TreeNode root = new TreeNode(levelOrder[0]);
        LinkedList<Pair> que = new LinkedList<Pair>();
        que.add(new Pair(root, Integer.MIN_VALUE, root.val));
        que.add(new Pair(root, root.val, Integer.MAX_VALUE));
        int idx=1;
        while(idx < levelOrder.length){
            Pair rPair = que.removeFirst();
            if(levelOrder[idx]>rPair.lr && levelOrder[idx]<rPair.rr){
                TreeNode nn = new TreeNode(levelOrder[idx]);
                if (rPair.rr == rPair.parent.val){
                    rPair.parent.left = nn;
                }else if (rPair.lr == rPair.parent.val){
                    rPair.parent.right = nn;
                }
                que.addLast(new Pair(nn, rPair.lr, nn.val));
                que.addLast(new Pair(nn, nn.val, rPair.rr));
                idx++;
            }
        }
        return root;
    }
}
