class Pair {
    int llzp;
    int rlzp;
    int lzp;

    Pair() {
        this.llzp = 0;
        this.rlzp = 0;
        this.lzp = 0;
    }

    Pair(int llzp, int rlzp, int lzp) {
        this.lzp = lzp;
        this.llzp = llzp;
        this.rlzp = rlzp;
    }
}

class LongestZigZag {
    public int longestZigZag(TreeNode root) {
        return longestZigZag_(root).lzp;
    }

    public int max(int... arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public Pair longestZigZag_(TreeNode root) {
        if (root == null) {
            return new Pair(-1, -1, 0);
        }
        Pair ln = longestZigZag_(root.left);
        Pair rn = longestZigZag_(root.right);
        Pair ans = new Pair();
        ans.llzp = ln.rlzp + 1;
        ans.rlzp = rn.llzp + 1;
        ans.lzp = max(ln.lzp, rn.lzp, ans.llzp, ans.rlzp);
        return ans;
    }
}
