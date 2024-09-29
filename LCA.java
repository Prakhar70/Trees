public class LCA {
    private static TreeNode LCA;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LCA = null;
        lowestCommonAncestor_(root, p, q);
        return LCA;
    }
    private int lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return 0;
        }
        int cnt=0;
        if(root == p || root == q){
            cnt++;
        }
        int la = lowestCommonAncestor_(root.left, p, q);
        int ra = lowestCommonAncestor_(root.right, p, q);
        if(la == 1 ){
            cnt++;
        }
        if(ra == 1){
            cnt++;
        }
        if(cnt == 2){
            if(LCA == null)
                LCA = root;
        }
        if(cnt>=1){
            return 1;
        }
        return 0;

    }

}
