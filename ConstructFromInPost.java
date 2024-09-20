public class ConstructFromInPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        return buildTree(postorder, inorder, 0 , postorder.length-1, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] postorder, int[] inorder, int psi, int pei, int isi, int iei) {
        if(psi>pei){
            return null;
        }
        TreeNode root = new TreeNode(postorder[pei]);
        int i=0;
        for(i=isi; i<=iei; i++){
            if(inorder[i]==root.val){
                break;
            }
        }
        root.left = buildTree(postorder, inorder, psi, psi+(i-isi)-1, isi, i-1);
        root.right = buildTree(postorder, inorder, psi+(i-isi), pei-1, i+1, iei);
        return root;
    }
}
