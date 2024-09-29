import java.util.ArrayList;

public class BurningTree {
    private static int maxTime =0;
    //Variation 1
    public static void burnTree(TreeNode root, TreeNode blockNode, int time){
        if(root == null || root == blockNode){
            return;
        }
        maxTime = Math.max(maxTime, time);
        burnTree(root.left, blockNode, time+1);
        burnTree(root.right, blockNode, time+1);
    }
    //Variation 2
    public static void burnTree002(TreeNode root, TreeNode blockNode, int time, ArrayList<ArrayList<Integer>> ans){
        if(root == null || root == blockNode){
            return;
        }
        if(time == ans.size()){
            ans.add(new ArrayList<>());
        }
        ans.get(time).add(root.val);
        burnTree002(root.left, blockNode, time+1, ans);
        burnTree002(root.right, blockNode, time+1, ans);
    }
    public static int burningTree(TreeNode root, int fireNode){
        if(root == null){
            return 0;
        }
        if(root.val == fireNode){
            burnTree(root, null, 0);
            return 1;
        }
        int leftTime = burningTree(root.left, fireNode);
        if(leftTime > 0){
            burnTree(root, root.left, leftTime);
            return leftTime+1;
        }
        int rightTime = burningTree(root.right, fireNode);
        if(rightTime > 0){
            burnTree(root, root.right, rightTime);
            return rightTime+1;
        }
        return 0;
    }
}
