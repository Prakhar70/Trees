class Pair {
    int ansWithInclusion;
    int ansWithoutInclusion;

    Pair(int ansWithInclusion, int ansWithoutInclusion) {
        this.ansWithInclusion = ansWithInclusion;
        this.ansWithoutInclusion = ansWithoutInclusion;
    }
}

class HouseRobber {
    public int rob(TreeNode root) {
        Pair p = rob_(root);
        int ans = Math.max(p.ansWithInclusion, p.ansWithoutInclusion);
        return ans;
    }

    public Pair rob_(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }
        Pair ln = rob_(root.left);
        Pair rn = rob_(root.right);
        int ansWithInclusion = root.val+ln.ansWithoutInclusion+rn.ansWithoutInclusion;
        int ansWithoutInclusion = Math.max(ln.ansWithoutInclusion,ln.ansWithInclusion)+Math.max(rn.ansWithoutInclusion,rn.ansWithInclusion);
        return new Pair(ansWithInclusion, ansWithoutInclusion);
    }
}