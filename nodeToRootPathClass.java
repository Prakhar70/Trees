import java.util.ArrayList;

public class nodeToRootPathClass {
    public static boolean findData(TreeNode root, int data, ArrayList<TreeNode> list) {
        if (root == null)
            return false;
        if(root.val == data){
            list.add(root);
            return true;
        }
        boolean ans = findData(root.left,data, list) || findData(root.right, data,list);
        if(ans){
            list.add(root);
        }
        return ans;
    }
    public static ArrayList<TreeNode> nodeToRootPath(TreeNode root, int data){
        ArrayList<TreeNode> list = new ArrayList<>();
        findData(root, data, list);
        return list;
    }
    public static ArrayList<TreeNode> nodeToRootPath002(TreeNode root, int data){
        
        if(root== null){
            return null;
        }
        if(root.val == data){
            ArrayList<TreeNode> res=new ArrayList<>();
            res.add(root);
            return res;
        }
        ArrayList<TreeNode> left = nodeToRootPath002(root.left, data);
        if(left!=null){
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right = nodeToRootPath002(root.right, data);
        if(right!=null){
            right.add(root);
            return right;
        }

        return null;
    }
    public static ArrayList<TreeNode> nodeToRootPath001(TreeNode root, int data){
        ArrayList<TreeNode> res = nodeToRootPath002(root, data);
        return res!=null?res:new ArrayList<>();
    }

}
