class Pair {
    int maxPathLen;
    int rightMaxPathLen;
    int leftMaxPathLen;

    Pair() {
        this.maxPathLen = 0;
        this.leftMaxPathLen = 0;
        this.rightMaxPathLen = 0;
    }

    Pair(int maxPathLen, int leftMaxPathLen, int rightMaxPathLen) {
        this.maxPathLen = maxPathLen;
        this.leftMaxPathLen = leftMaxPathLen;
        this.rightMaxPathLen = rightMaxPathLen;
    }
}

class LongestZigZag {
    public int longestZigZag(TreeNode root) {
        return longestZigZag_(root).maxPathLen;
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
            return new Pair(0, -1, -1);
        }
        Pair ln = longestZigZag_(root.left);
        Pair rn = longestZigZag_(root.right);
        Pair ans = new Pair();
        ans.leftMaxPathLen = ln.rightMaxPathLen + 1;
        ans.rightMaxPathLen = rn.leftMaxPathLen + 1;
        ans.maxPathLen = max(ln.maxPathLen, rn.maxPathLen, ans.leftMaxPathLen, ans.rightMaxPathLen);
        return ans;
    }
}
