import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class VerticalOrder {
    class Pair {
        TreeNode node;
        int vl;
        int hl;

        Pair(TreeNode node, int vl, int hl) {
            this.node = node;
            this.vl = vl;
            this.hl = hl;
        }
    }

    private void widthOfTree(TreeNode root, int[] minMax, int vl) {

        if (root == null) {
            return;
        }
        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);
        widthOfTree(root.left, minMax, vl - 1);
        widthOfTree(root.right, minMax, vl + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        int[] minMax = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        widthOfTree(root, minMax, 0);
        int width = (minMax[1] - minMax[0]) + 1;
        System.out.println(width);
        ArrayList<Integer>[] al = new ArrayList[width];

        for (int i=0;i<al.length;i++) {
            al[i]=new ArrayList<>();
        }
        int horizontal_level = 1;
        Pair pp = new Pair(root, -minMax[0], horizontal_level);
        PriorityQueue<Pair> que=new PriorityQueue<>((a,b)->{
            if(a.hl != b.hl){
                return a.hl-b.hl;
            }else if (a.vl != b.vl){
                return a.vl-b.vl;
            }else{
                return a.node.val-b.node.val;
            }
        });
        que.add(pp);
        while (que.size() > 0) {
            int size = que.size();
            horizontal_level++;
            while (size-- > 0) {
                Pair rPair = que.remove();
                al[rPair.vl].addLast(rPair.node.val);
                
                if (rPair.node.left != null) {
                    que.add(new Pair(rPair.node.left, rPair.vl - 1, horizontal_level));
                }
                if (rPair.node.right != null) {
                    que.add(new Pair(rPair.node.right, rPair.vl + 1, horizontal_level));
                }
            }
        }
        return Arrays.asList(al);
    }
}
