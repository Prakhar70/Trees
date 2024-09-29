public class MaximumPathSum {
    class Pair{
        int NTLMaxSum;
        int LTLMaxSum;
        Pair(){
            
        }
        Pair(int NTLMaxSum, int LTLMaxSum){
            this.NTLMaxSum=NTLMaxSum;
            this.LTLMaxSum=LTLMaxSum;
        }
    }
    public Pair maxPathSum(TreeNode root){
        if(root == null){
            return new Pair(-(int)1e9, -(int)1e9);
        }
        if(root.left == null && root.right ==null){
            return new Pair(root.val, -(int)1e9);
        }
        Pair lp = maxPathSum(root.left);
        Pair rp = maxPathSum(root.right);

        Pair myAns=new Pair();
        myAns.LTLMaxSum=Math.max(lp.LTLMaxSum, rp.LTLMaxSum);
        if(root.left != null && root.right != null){
            myAns.LTLMaxSum=Math.max(myAns.LTLMaxSum, lp.NTLMaxSum+rp.NTLMaxSum+root.val);
        }
        myAns.NTLMaxSum=Math.max(lp.NTLMaxSum, rp.NTLMaxSum)+root.val;
        return myAns;
    }
}
