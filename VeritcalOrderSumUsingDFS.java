import java.util.ArrayList;

class Pair {
    TreeNode node;
    int vl;

    Pair(TreeNode node, int vl) {
        this.node = node;
        this.vl = vl;
    }
}

public class VeritcalOrderSumUsingDFS {

    public static void widthOfBT(TreeNode root, int[] minMax, int vl) {
        if (root == null) {
            return;
        }
        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.min(minMax[1], vl);
        widthOfBT(root, minMax, vl + 1);
        widthOfBT(root, minMax, vl - 1);
    }

    private static void dfs(TreeNode root, int vl, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.set(vl, ans.get(vl) + root.val);
        dfs(root.left, vl - 1, ans);
        dfs(root.right, vl + 1, ans);
    }

    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        int[] minMax = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        widthOfBT(root, minMax, 0);
        int width = minMax[1] - minMax[0] + 1;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            ans.add(0);
        }
        dfs(root, -minMax[0], ans);
        return ans;
    }

}