

public class BST2DLL {
    private static TreeNode prev = null;

    private static void bToDLL_(TreeNode root){
        if(root == null){
            return ;
        }
        bToDLL_(root.left);

        prev.right = root;
        root.left = prev;
        prev = root;

        bToDLL_(root.right);
    }
    public static TreeNode bToDLL(TreeNode root){
        TreeNode dummy=new TreeNode(-1);
        prev = dummy;
        bToDLL_(root);

        TreeNode head = dummy.right;
        dummy.right=head.left=null;

        head.left = prev;
        prev.right = head;

        return head;
    }

    public static TreeNode bToDLLMO(TreeNode root){
        TreeNode dummy=new TreeNode(-1);
        TreeNode prev = dummy;
        TreeNode curr = root;
        while(curr!=null){
            TreeNode ln = curr.left;
            if(ln == null){
                
                prev.right=curr;
                curr.left = prev;
                prev = curr;

                curr=curr.right;
                continue;
            }
            while(ln.right!=null || ln.right!=curr){
                ln=ln.right;
            }
            if(ln.right == null){
                ln.right = curr;
                curr=curr.left;
            }else{
                ln.right = null;
                //System.out.println(curr.val);
                prev.right=curr;
                curr.left = prev;
                prev = curr;

                curr=curr.right;
            }
        }
        TreeNode head = dummy.right;
        dummy.right = head.left = null;

        prev.right=head;
        head.left = prev;

        return head;
    }
}
