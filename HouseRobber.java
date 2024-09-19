class Pair {
    int is;
    int nis;

    Pair(int is, int nis) {
        this.is = is;
        this.nis = nis;
    }
}

class HouseRobber {
    public int rob(TreeNode root) {
        Pair p = rob_(root);
        int ans = Math.max(p.is, p.nis);
        return ans;
    }

    public Pair rob_(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair ln = rob_(root.left);
        Pair rn = rob_(root.right);
        int is = root.val + ln.nis + rn.nis;
        int nis = Math.max(ln.nis, ln.is) + Math.max(rn.nis, rn.is);
        return new Pair(is, nis);
    }
}