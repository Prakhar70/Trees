public class DLL2BST {
    public static TreeNode midNode(TreeNode node){
        if(node == null || node.right == null){
            return node;
        }
        TreeNode slow =node, fast = node;
        while(fast.right != null && fast.right.right != null){
            fast=fast.right.right;
            slow= slow.right;
        }
        return slow;
    }
    public static TreeNode SortedDLLToBST(TreeNode head){
        if(head == null || head.right == null){
            return head;
        }
        TreeNode midNode = midNode(head);
        TreeNode prev = midNode.right;
        TreeNode forwd = midNode.left;
        forwd.left = midNode.left = midNode.right = null;
        if(prev != null){
            prev.right=null;
        }

        TreeNode leftHead = prev!=null?head:null;
        TreeNode rightHead = forwd;
        TreeNode root = midNode;

        root.left = SortedDLLToBST(leftHead);
        root.right=SortedDLLToBST(rightHead);
        return root;
    }
}
