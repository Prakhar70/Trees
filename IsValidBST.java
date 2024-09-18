
public class IsValidBST {
    class Pair {
        long maxi;
        long mini;
        boolean isBST;


        Pair(long maxi, long mini, boolean isBST) {
            this.maxi = maxi;
            this.mini = mini;
            this.isBST = isBST;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST_(root).isBST;
    }

    private long max(long... arr) {
        long max = Long.MIN_VALUE;
        for (long ele : arr) {
            max = Math.max(max, ele);
        }
        return max;
    }

    private long min(long... arr) {
        long min = Long.MAX_VALUE;
        for (long ele : arr) {
            min = Math.min(min, ele);
        }
        return min;
    }

    private Pair isValidBST_(TreeNode root) {
        if (root == null) {
            return new Pair(Long.MIN_VALUE, Long.MAX_VALUE, true);
        }
        Pair ln = isValidBST_(root.left);
        Pair rn = isValidBST_(root.right);
        Pair ans = new Pair(
                max(ln.maxi, rn.maxi, root.val),
                min(rn.mini, ln.mini, root.val),
                (ln.isBST && rn.isBST && root.val > ln.maxi && root.val < rn.mini));

        return ans;
    }
}
