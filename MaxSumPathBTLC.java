public class MaxSumPathBTLC {
    class Pair{
        int strMax;
        int maxPath;
        Pair(){

        }
        Pair(int strMax, int maxPath){
            this.strMax=strMax;
            this.maxPath=maxPath;
        }
    }
    public int maxPathSum(TreeNode root) {
        return maxPathSum_(root).maxPath;
    }
    private int max(int... a){
        int max = Integer.MIN_VALUE;
        for(int ele:a){
            max=Math.max(max,ele);
        }
        return max;
    }
    private Pair maxPathSum_(TreeNode root) {
        if(root == null){
            return new Pair(-(int)1e8, -(int)1e8);
        }
        if(root.left == null && root.right ==null){
            return new Pair(root.val, root.val);
        }
        Pair lp = maxPathSum_(root.left);
        Pair rp = maxPathSum_(root.right);
        Pair myAns=new Pair();
        myAns.strMax=max(max(lp.strMax, rp.strMax)+root.val,root.val);
        myAns.maxPath=max(lp.maxPath, rp.maxPath, root.val+lp.strMax+rp.strMax, myAns.strMax);
        return myAns;
    }
}
